package liusheng.danmu.utils;

import okhttp3.OkHttpClient;

/**
 * 2020年:  05 月:  11 日:  09小时:  02分钟:
 * 用户名: 👨‍LiuSheng👨‍
 */

public class HttpClientUtils {
    private static OkHttpClient httpClient = new OkHttpClient();

    public static OkHttpClient httpClient() {
        return httpClient;
    }
}
