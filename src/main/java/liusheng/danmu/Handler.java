package liusheng.danmu;

import liusheng.danmu.entity.PlayListItem;

import java.util.List;

/**
 * 年: 2020  月: 05 日: 11 小时: 13 分钟: 03
 * 用户名: LiuSheng
 */

public interface Handler {
    List<PlayListItem> handle(String url);
}
