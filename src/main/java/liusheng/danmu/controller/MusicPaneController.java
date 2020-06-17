package liusheng.danmu.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXSlider;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.NodeOrientation;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.VBox;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

/**
 * 2020年:  05 月:  11 日:  15小时:  09分钟:
 * 用户名: 👨‍LiuSheng👨‍
 */

public class MusicPaneController implements Initializable {
    public static MusicPaneController musicPaneController;
    @FXML
    private JFXButton playButton;
    @FXML
    private JFXButton nextButton;
    @FXML
    private Label songSlid;
    @FXML
    private Label songName;
    @FXML
    private JFXSlider progressSlid;

    private JFXSlider volumnsSlid;

    private Stage stage;

    public Label getSongName() {
        return songName;
    }

    public JFXSlider getProgressSlid() {
        return progressSlid;
    }

    public void setProgressSlid(JFXSlider progressSlid) {
        this.progressSlid = progressSlid;
    }

    public JFXSlider getVolumnsSlid() {
        return volumnsSlid;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        musicPaneController = this;
        playButton.setStyle("-fx-background-color: black");
        nextButton.setStyle("-fx-background-color: red");
        songSlid.setStyle("-fx-background-color: blue");
        volumnsSlid = new JFXSlider(0, 1, 1);
        stage = new Stage();
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setResizable(false);

        playButton.setOnAction(e -> {
            MediaPlayer mediaPlayer = PlayListItemController.playListItemController
                    .getMediaPlayer();
            if (Objects.nonNull(mediaPlayer)) {
                if (mediaPlayer.getStatus() != MediaPlayer.Status.DISPOSED
                        && mediaPlayer.getStatus() != MediaPlayer.Status.PLAYING) {
                    mediaPlayer.play();
                } else {
                    mediaPlayer.pause();
                }
            }
        });

        VBox root = new VBox();
        root.getChildren().add(volumnsSlid);
        volumnsSlid.setPrefSize(20, 100);
        volumnsSlid.setOrientation(Orientation.VERTICAL);
        stage.setScene(new Scene(root, 20, 100));
        songSlid.setOnMouseClicked(e -> {
            double x = e.getScreenX() - e.getX() + songSlid.getWidth() / 2 - volumnsSlid.getPrefWidth() / 2;
            double y = e.getScreenY() - e.getY();
            stage.setX(x);
            stage.setY(y - volumnsSlid.getPrefHeight());
            stage.show();
        });

        volumnsSlid.focusedProperty().addListener((a, o, n) -> {
            if (!n) {
                stage.hide();
            }
        });

    }
}
