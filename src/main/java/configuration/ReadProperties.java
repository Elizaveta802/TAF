package configuration;

import java.io.IOException;
import java.util.Properties;

public class ReadProperties {
    private static final Properties properties;

    static {
        properties = new Properties();
        try {
            properties.load(ReadProperties.class.getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getUrl() {
        return properties.getProperty("url");
    }

    public static String browserName() {
        return properties.getProperty("browser");
    }


    public static String webAddress() {
        return properties.getProperty("wad");
    }

    public static String firstName() {
        return properties.getProperty("firstname");
    }

    public static String lastName() {
        return properties.getProperty("lastname");
    }

    public static String workEmail() {
        return properties.getProperty("elizaveta.naumovich@mail.ru");
    }

    public static String organization() {
        return properties.getProperty("organization");
    }



    public static boolean isHeadless() {
        return properties.getProperty("headless").equalsIgnoreCase("true");
    }
}
