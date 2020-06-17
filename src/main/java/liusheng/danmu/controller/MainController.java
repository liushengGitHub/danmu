package liusheng.danmu.controller;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * 2020年:  05 月:  10 日:  21小时:  03分钟:
 * 用户名: 👨‍LiuSheng👨‍
 */

public class MainController implements Initializable {
    @FXML
    private VBox mainBox;

    private VBox playListBox;
    private VBox searchListBox;
    private VBox settingBox;
    private HBox musicPane;

    public  void  playList() {

        ObservableList<Node> children = mainBox.getChildren();
        children.set(0,playListBox);
    }
    public  void  searchList() {
        ObservableList<Node> children = mainBox.getChildren();
        children.set(0,searchListBox);
    }

    public  void  setting() {
        ObservableList<Node> children = mainBox.getChildren();
        children.set(0,settingBox);
    }

    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<Node> children = mainBox.getChildren();
        try {
            playListBox = FXMLLoader.load(MainController.class.getClassLoader().getResource("playList.fxml"));
            searchListBox = FXMLLoader.load(MainController.class.getClassLoader().getResource("musicList.fxml"));
            settingBox = FXMLLoader.load(MainController.class.getClassLoader().getResource("setting.fxml"));
            // playListBox.getChildren().add();
            musicPane = FXMLLoader.load(MainController.class.getClassLoader().getResource("musicPane.fxml"));
            children.add(playListBox);
            children.add(musicPane);
        } catch (IOException e) {
            throw  new RuntimeException(e);
        }

    }
}
