package liusheng.danmu.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import liusheng.danmu.entity.MusicItem;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

/**
 * 2020年:  05 月:  10 日:  20小时:  04分钟:
 * 用户名: 👨‍LiuSheng👨‍
 */

public class MusicListController implements Initializable {
    @FXML
    private JFXButton searchButton;
    @FXML
    private JFXTextField searchText;
    @FXML
    private ListView<MusicItem> searchList;

    public void search(ActionEvent actionEvent) {
        searchList.getItems().add(new MusicItem());
    }

    public void initialize(URL location, ResourceBundle resources) {
        searchList.setCellFactory(list -> {
            return new ListCell<MusicItem>() {
                @Override
                protected void updateItem(MusicItem item, boolean empty) {
                    super.updateItem(item, empty);
                    if (!empty && Objects.nonNull(item)) {
                        setGraphic(new MusicItemHBox(item));
                    } else {
                        setGraphic(null);
                    }
                }
            };
        });
    }
}
