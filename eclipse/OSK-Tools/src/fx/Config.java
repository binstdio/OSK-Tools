package fx;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Config {
    
	/**
	 * 主题包名称
	 */
	public static String _1;//
	/**
	 * 主题包作者
	 */
    public static String _2;//
    /**
     * 主题包简介
     */
    public static String _3;//
    /**
     * home中Welcome to OSK Tools的文字颜色
     */
    public static String _4;//
    /**
     * home中信息的文字颜色
     */
    public static String _5;//
    /**
     * set中运行文字的颜色
     */
    public static String _6;//
    /**
     * set中待运行项的文字颜色
     */
    public static String _7;//
    /**
     * 密码工具中，全局文字颜色
     */
    public static String _8;//
    /**
     * 设置中，标题文字颜色
     */
    public static String _9;//
    /**
     * 设置中，其他文本颜色
     */
    public static String _10;//
    /**
     * 关于信息
     */
    public static String _11;

    // 可选：用于初始化配置的方法
    public static void initConfig() {
        try {
            // 获取资源文件的输入流
            InputStream is = Config.class.getResourceAsStream("/res/config.txt");
            if (is == null) {
                throw new FileNotFoundException("Resource /res/config.txt not found");
            }

            // 使用 BufferedReader 读取文件
            BufferedReader reader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
            String line;
            int index = 1;

            while ((line = reader.readLine()) != null && index <= 11) {
                String fieldName = "_" + index;
                // 使用反射设置静态字段的值
                java.lang.reflect.Field field = Config.class.getField(fieldName);
                field.set(null, line.trim());
                index++;
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
