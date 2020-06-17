package liusheng.danmu.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXSlider;
import com.jfoenix.controls.JFXTextField;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;
import liusheng.danmu.entity.MusicItem;
import liusheng.danmu.entity.PlayListItem;
import liusheng.danmu.filter.DanmuFilter;

import java.net.URL;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

/**
 * 2020年:  05 月:  10 日:  20小时:  04分钟:
 * 用户名: 👨‍LiuSheng👨‍
 */

public class PlayListItemController implements Initializable {

    public static PlayListItemController playListItemController = null;
    @FXML
    private ListView<PlayListItem> playList;
    @FXML
    private HBox musicPlayerHBox;

    private MediaPlayer mediaPlayer;

    public MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }

    private DurationListener durationListener = new DurationListener();

    class DurationListener implements ChangeListener<Duration> {

        @Override
        public void changed(ObservableValue<? extends Duration> observable, Duration oldValue, Duration newValue) {
            //179983.673469
            if (Math.abs(newValue.subtract(mediaPlayer.getTotalDuration()).toMillis()) <= 500) {
                stopMediaAndNext();
            }
        }


    }

    public void stopMediaAndNext() {
        mediaPlayer.stop();
        removeFirst();
        PlayListItem first = getFirst();
        if (first == null) {
            mediaPlayer = null;
        } else {
            playProperty(first);
        }
    }

    public void removeFirst() {
        getItems().remove(0);
    }

    public ObservableList<PlayListItem> getItems() {
        return playList.getItems();
    }

    public void add(PlayListItem playListItem) {
        getItems().add(playListItem);
        if (mediaPlayer == null) {
            playProperty(playListItem);
        }
    }

    public void remove(PlayListItem playListItem) {
        getItems().remove(playListItem);
    }

    private void playProperty(PlayListItem playListItem) {
        mediaPlayer = new MediaPlayer(new Media(playListItem.getUrl()));
        mediaPlayer.play();
        mediaPlayer.currentTimeProperty().addListener(durationListener);
        mediaPlayer.volumeProperty()
                .bind(MusicPaneController.musicPaneController
                        .getVolumnsSlid().valueProperty());
        JFXSlider slid = MusicPaneController.musicPaneController
                .getProgressSlid();

        Label songName = MusicPaneController.musicPaneController
                .getSongName();
        songName.setText(playListItem.getName());
        slid.valueProperty()
                .addListener((a, o, n) -> {
                    if (slid.isValueChanging()) {
                        mediaPlayer.seek(mediaPlayer.getTotalDuration().multiply(n.doubleValue() / 100.0));
                    }
                });
        mediaPlayer.currentTimeProperty()
                .addListener((a, o, n) -> {
                    if (Objects.nonNull(mediaPlayer)) {
                        slid.setValue(n.toMillis() * 1.0 / mediaPlayer.getTotalDuration().toMillis() * 100);
                    }
                });

    }

    public PlayListItem getFirst() {
        ObservableList<PlayListItem> items = getItems();
        if (items.size() > 0) {
            return items.get(0);
        } else {
            return null;
        }
    }

    public void initialize(URL location, ResourceBundle resources) {
        playListItemController = this;


        playList.setCellFactory(list -> {
            return new ListCell<PlayListItem>() {
                @Override
                protected void updateItem(PlayListItem item, boolean empty) {
                    super.updateItem(item, empty);
                    if (!empty && Objects.nonNull(item)) {
                        item.setIndex(String.valueOf(getIndex()));
                        setGraphic(new PlayListItemHBox(item));
                    } else {
                        setGraphic(null);
                    }
                }
            };
        });

    }


}
