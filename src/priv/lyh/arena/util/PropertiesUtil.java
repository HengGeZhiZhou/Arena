package priv.lyh.arena.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

public class PropertiesUtil {
    private static Properties propertiesA = new Properties();
    private static Properties propertiesC = new Properties();
    static {
        try {
           URL urlA=ClassLoader.class.getClassLoader().getResource("mailAccount.properties");
           URL urlC=ClassLoader.class.getClassLoader().getResource("mailAccount.properties");
            propertiesA.load(new FileInputStream(urlA.getPath()));
            propertiesC.load(new FileInputStream(urlC.getPath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String getAccountForm() {
        return propertiesA.getProperty("mail.from");
    }

    public static String getAccountUsername() {
        return propertiesA.getProperty("mail.username");
    }

    public static String getAccountPassword() {
        return propertiesA.getProperty("mail.password");
    }

    public static String getAccountHost(){
        return propertiesA.getProperty("mail.smtp.host");
    }

    public static Properties getPropertiesConnect() {
        return propertiesC;
    }
}
