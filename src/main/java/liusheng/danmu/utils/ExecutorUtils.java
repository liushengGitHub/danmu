package liusheng.danmu.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 2020年:  05 月:  11 日:  09小时:  38分钟:
 * 用户名: 👨‍LiuSheng👨‍
 */

public class ExecutorUtils {

    private static ExecutorService executorService = Executors.newFixedThreadPool(8);

    public static ExecutorService executorService() {
        return executorService;
    }
}
