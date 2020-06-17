package liusheng.danmu.controller;

import com.jfoenix.controls.JFXButton;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import liusheng.danmu.entity.MusicItem;
import liusheng.danmu.entity.PlayListItem;

/**
 * 2020年:  05 月:  10 日:  21小时:  19分钟:
 * 用户名: 👨‍LiuSheng👨‍
 */

public class PlayListItemHBox extends HBox {
    PlayListItem playListItem;

    public PlayListItemHBox(PlayListItem playListItem) {
        super();
        this.playListItem = playListItem;
        setAlignment(Pos.CENTER);
        Label index = new Label(playListItem.getIndex());
        index.setPrefSize(50, 30);
        HBox.setMargin(index, new Insets(0, 0, 0, 10));
        Label name = new Label(playListItem.getName());
        name.setPrefSize(100, 30);
        HBox.setMargin(name, new Insets(0, 0, 0, 10));

        Label player = new Label(playListItem.getPlayer());
        player.setPrefSize(100, 30);
        HBox.setMargin(player, new Insets(0, 0, 0, 10));
        Label author = new Label(playListItem.getAuthor());
        HBox.setMargin(author, new Insets(0, 0, 0, 10));
        author.setPrefSize(100, 30);
        JFXButton jfxButton = new JFXButton("上");

        jfxButton.setPrefSize(60, 30);
        jfxButton.setOnAction(e -> {
            ObservableList<PlayListItem> items = PlayListItemController
                    .playListItemController.getItems();
            if (items.get(1) == playListItem) {
                PlayListItemController
                        .playListItemController.stopMediaAndNext();
            } else {
                int i = items.indexOf(playListItem);
                items.remove(playListItem);
                items.add(i-1, playListItem);
            }
        });
        JFXButton deleteButton = new JFXButton("删除");
        deleteButton.setPrefSize(60, 30);
        deleteButton.setOnAction(e -> {
            PlayListItem first = PlayListItemController
                    .playListItemController.getFirst();

            if (first == playListItem) {
                PlayListItemController
                        .playListItemController.stopMediaAndNext();
            } else {
                PlayListItemController
                        .playListItemController.remove(playListItem);
            }
        });
        getChildren().addAll(index, name, player, author, jfxButton, deleteButton);
    }
}
