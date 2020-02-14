package credentials;

import credentials.ReadPropertiesFile;

import java.io.IOException;
import java.util.Properties;

public class AmazonCredentialsManager {
    public static String getUsername() {
        Properties prop = null;
        try {
            prop = ReadPropertiesFile.readPropertiesFile("src/test/java/credentials/login.properties");
        } catch (IOException e) {
            e.printStackTrace();
        }
        String username = prop.getProperty("username");
        return username;
    }
    public static String getPassword() {
        Properties prop = null;
        try {
            prop = ReadPropertiesFile.readPropertiesFile("src/test/java/credentials/login.properties");
        } catch (IOException e) {
            e.printStackTrace();
        }
        String password = prop.getProperty("password");
        return password;
    }
}
