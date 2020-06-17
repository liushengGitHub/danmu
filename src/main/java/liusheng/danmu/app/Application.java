package liusheng.danmu.app;

import com.google.gson.Gson;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import liusheng.danmu.BilibiliDanmuHandler;
import liusheng.danmu.bilibili.BiliDanmuEntity;
import liusheng.danmu.controller.PlayListItemController;
import liusheng.danmu.controller.SettingController;
import liusheng.danmu.entity.MusicInfo;
import liusheng.danmu.entity.MusicListInfo;
import liusheng.danmu.entity.PlayListItem;
import liusheng.danmu.filter.DanmuFilter;
import liusheng.danmu.utils.ExecutorUtils;
import liusheng.danmu.utils.HttpClientUtils;
import okhttp3.FormBody;
import okhttp3.FormBody.Builder;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * 2020年:  05 月:  10 日:  19小时:  58分钟:
 * 用户名: 👨‍LiuSheng👨‍
 * https://api.live.bilibili.com/xlive/web-room/v1/dM/gethistory
 */

public class Application extends javafx.application.Application {

    public static final String MUSIC_LIST_INFO = "http://search.5sing.kugou.com/home/json?keyword=%s";
    public static final String MUSIC_INFO = "http://service.5sing.kugou.com/song/getsongurl?songid=%d&songtype=%s";
    private BilibiliDanmuHandler bilibiliDanmuHandler = new BilibiliDanmuHandler();
    private Gson gson = new Gson();
    ;

    public void start(Stage primaryStage) throws Exception {


        primaryStage.setScene(new Scene(getParent(), 600, 480));
        primaryStage.setTitle("点歌软件");
        primaryStage.setResizable(false);
        primaryStage.show();

        //
        //
        //http://music.163.com/song/media/outer/url?id=1345848098.MP3
        new Thread(() -> {
            while (true) {
                try {
                    List<PlayListItem> playListItems = bilibiliDanmuHandler.handle(SettingController.settingController.getUrlText().getText());
                    if (!playListItems.isEmpty()) {
                        playListItems.forEach(playListItem -> {
                            String name = playListItem.getName();
                            String[] strings = name.split("[ \t]", 2);
                            if (strings.length != 2) return;
                            playListItem.setName(strings[1]);
                            ExecutorUtils
                                    .executorService()
                                    .execute(() -> {
                                        try {
                                            String url = String.format(MUSIC_LIST_INFO, strings[1]);
                                            MusicListInfo musicListInfo = getMusicListInfo(url);
                                            List<MusicListInfo.ListBean> list = musicListInfo.getList();
                                            if (list.isEmpty()) {
                                                return;
                                            }
                                            MusicListInfo.ListBean listBean = list.stream()
                                                    .filter(listBean1 -> listBean1.getType() != 3)
                                                    .sorted(Comparator.comparing(MusicListInfo.ListBean::getType))
                                                    .findFirst().orElse(null);
                                            if (Objects.isNull(listBean)) return;
                                            int songId = listBean.getSongId();
                                            int type = listBean.getType();
                                            MusicInfo musicInfo = getMusicInfo(String.format(MUSIC_INFO, songId, getType(type)));
                                            String lqurl = musicInfo.getData().getLqurl();
                                            if (lqurl == null || lqurl.length() == 0) return;
                                            playListItem.setUrl(lqurl);
                                            playListItem.setAuthor(listBean.getSinger());
                                            Platform.runLater(() -> {
                                                PlayListItemController.playListItemController.add(playListItem);
                                            });
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                    });
                        });

                    }
                    TimeUnit.SECONDS.sleep(5);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }).start();

    }

    public static String[] types = new String[]{"", "yc", "fc", "bz"};

    private String getType(int type) {
        return types[type];
    }

    private MusicListInfo getMusicListInfo(String url) throws IOException {
        String json = HttpClientUtils.httpClient()
                .newCall(new Request.Builder()
                        .url(url)
                        .build()).execute().body().string();

        return gson.fromJson(json, MusicListInfo.class);
    }

    private MusicInfo getMusicInfo(String url) throws IOException {
        String json = HttpClientUtils.httpClient()
                .newCall(new Request.Builder()
                        .url(url)
                        .build()).execute().body().string();

        return gson.fromJson(json, MusicInfo.class);
    }

    private Parent getParent() throws IOException {
        VBox main = FXMLLoader.<VBox>load(Application.class.getClassLoader().getResource("main.fxml"));

        return main;
    }
}
