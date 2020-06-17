package liusheng.danmu.entity;

/**
 * 2020年:  05 月:  10 日:  21小时:  58分钟:
 * 用户名: 👨‍LiuSheng👨‍
 */

public class PlayListItem {
    private String index;
    private String name;
    private String author;
    private String url;
    private String player;

    private long time;

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public PlayListItem() {
        super();
    }

    public PlayListItem(String name, String author, String player) {
        this.name = name;
        this.author = author;
        this.player = player;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }
}
