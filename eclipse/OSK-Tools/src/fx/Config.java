package fx;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Config {
    
	/**
	 * ���������
	 */
	public static String _1;//
	/**
	 * ���������
	 */
    public static String _2;//
    /**
     * ��������
     */
    public static String _3;//
    /**
     * home��Welcome to OSK Tools��������ɫ
     */
    public static String _4;//
    /**
     * home����Ϣ��������ɫ
     */
    public static String _5;//
    /**
     * set���������ֵ���ɫ
     */
    public static String _6;//
    /**
     * set�д��������������ɫ
     */
    public static String _7;//
    /**
     * ���빤���У�ȫ��������ɫ
     */
    public static String _8;//
    /**
     * �����У�����������ɫ
     */
    public static String _9;//
    /**
     * �����У������ı���ɫ
     */
    public static String _10;//
    /**
     * ������Ϣ
     */
    public static String _11;

    // ��ѡ�����ڳ�ʼ�����õķ���
    public static void initConfig() {
        try {
            // ��ȡ��Դ�ļ���������
            InputStream is = Config.class.getResourceAsStream("/res/config.txt");
            if (is == null) {
                throw new FileNotFoundException("Resource /res/config.txt not found");
            }

            // ʹ�� BufferedReader ��ȡ�ļ�
            BufferedReader reader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
            String line;
            int index = 1;

            while ((line = reader.readLine()) != null && index <= 11) {
                String fieldName = "_" + index;
                // ʹ�÷������þ�̬�ֶε�ֵ
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
