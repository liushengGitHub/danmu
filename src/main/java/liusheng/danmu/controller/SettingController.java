package liusheng.danmu.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import liusheng.danmu.entity.Config;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * 2020年:  05 月:  10 日:  21小时:  03分钟:
 * 用户名: 👨‍LiuSheng👨‍
 */

public class SettingController implements Initializable {
    @FXML
    private JFXTextField urlText;
    public static SettingController settingController;

    public JFXTextField getUrlText() {
        return urlText;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        settingController = this;
        urlText.setText(Config.getProperty("liveUrl"));
        urlText.textProperty()
                .addListener((a, o, n) -> {
                    Config.setProperty("liveUrl", n);
                });
    }
}
