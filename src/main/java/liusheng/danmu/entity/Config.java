package liusheng.danmu.entity;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * 2020年:  05 月:  11 日:  13小时:  52分钟:
 * 用户名: 👨‍LiuSheng👨‍
 */

public class Config {

    private static Properties properties = new Properties();

    static {
        try {
            properties.load(new FileInputStream("config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String name) {
        return properties.getProperty(name);
    }

    public static void setProperty(String name, String value) {
        properties.setProperty(name, value);
        try {
            properties.store(new FileOutputStream("config.properties"),"store");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
