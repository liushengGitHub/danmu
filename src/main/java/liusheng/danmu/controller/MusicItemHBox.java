package liusheng.danmu.controller;

import com.jfoenix.controls.JFXButton;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import liusheng.danmu.entity.MusicItem;

/**
 * 2020年:  05 月:  10 日:  21小时:  19分钟:
 * 用户名: 👨‍LiuSheng👨‍
 */

public class MusicItemHBox extends HBox {
    public MusicItemHBox(MusicItem musicItem) {
        super();
        setAlignment(Pos.CENTER);
        Label name = new Label(musicItem.getName());
        name.setPrefSize(100,30);
        HBox.setMargin(name,new Insets(0,0,0,100));
        Label author = new Label(musicItem.getAuthor());
        HBox.setMargin(author,new Insets(0,0,0,100));
        author.setPrefSize(100,30);
        JFXButton jfxButton = new JFXButton("下载");
        jfxButton.setPrefSize(100,30);
        jfxButton.setOnAction(e->{
        });
        getChildren().addAll(name,author,jfxButton);
    }
}
