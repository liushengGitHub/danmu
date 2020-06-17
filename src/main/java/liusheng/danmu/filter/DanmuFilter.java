package liusheng.danmu.filter;

import liusheng.danmu.entity.PlayListItem;

import java.util.function.Predicate;

/**
 * 2020年:  05 月:  11 日:  09小时:  42分钟:
 * 用户名: 👨‍LiuSheng👨‍
 */

public class DanmuFilter implements Predicate<PlayListItem> {
    private  long time;

    public DanmuFilter(long time) {
        this.time = time;
    }

    @Override
    public boolean test(PlayListItem playListItem) {
        return  playListItem.getTime() >= time && playListItem.getName().startsWith("点歌");
    }
}
