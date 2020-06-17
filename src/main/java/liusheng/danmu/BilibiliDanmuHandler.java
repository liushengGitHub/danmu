package liusheng.danmu;

import com.google.gson.Gson;
import javafx.application.Platform;
import liusheng.danmu.bilibili.BiliDanmuEntity;
import liusheng.danmu.controller.PlayListItemController;
import liusheng.danmu.entity.PlayListItem;
import liusheng.danmu.utils.HttpClientUtils;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 2020年:  05 月:  11 日:  13小时:  05分钟:
 * 用户名: 👨‍LiuSheng👨‍
 */

public class BilibiliDanmuHandler implements Handler {

    public static final String DANMU_URL = "https://api.live.bilibili.com/xlive/web-room/v1/dM/gethistory";
    public static final String PATTERN_URL = "https://live.bilibili.com/(\\d+)/?";

    private long time = System.currentTimeMillis();

    private final Pattern namePattern  = Pattern.compile("点歌[ \t](.+)");

    @Override
    public List<PlayListItem> handle(String url) {

        OkHttpClient httpClient = HttpClientUtils.httpClient();
        String roomId = getRoomId(url);
        if (roomId == null) {

            return Collections.emptyList();
        }
        FormBody formBody = new FormBody.Builder().add("roomid", roomId).build();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Response response = httpClient.newCall(new Request.Builder()
                    .post(formBody)
                    .url(DANMU_URL)
                    .build()).execute();

            String string = response.body().string();

            BiliDanmuEntity danmuEntity = new Gson().fromJson(string, BiliDanmuEntity.class);
            Date date = new Date();

            List<BiliDanmuEntity.DataBean.RoomBean> roomBeans = danmuEntity.getData()
                    .getRoom();
            if (roomBeans.isEmpty()) {
                return Collections.emptyList();
            }
            time += 1;
            List<PlayListItem> playListItems = new LinkedList<>();
            for (int i = 0; i < roomBeans.size(); i++) {

                BiliDanmuEntity.DataBean.RoomBean roomBean = roomBeans.get(i);
                PlayListItem playListItem = new PlayListItem(roomBean.getText(), "", roomBean.getNickname());

                Date dateParse = null;
                try {
                    dateParse = dateFormat.parse(roomBean.getTimeline());
                } catch (ParseException e) {
                    e.printStackTrace();
                    dateParse = date;
                }

                if (i == roomBeans.size() - 1 && ( time < dateParse.getTime())) {
                    time = dateParse.getTime();
                }

                playListItem.setTime(dateParse.getTime());
                if (playListItem.getTime() >= time && namePattern.matcher(roomBean.getText()).matches()) {
                    playListItems.add(playListItem);
                }

            }
            return playListItems;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private String getRoomId(String url) {
//https://live.bilibili.com/291623
        Matcher matcher = Pattern.compile(PATTERN_URL)
                .matcher(url);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }
}
