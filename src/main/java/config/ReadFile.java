package config;

import java.io.FileReader;
import java.util.Properties;

public class ReadFile {
    public Boolean check_username_password(String username, String password){
        Boolean result = false;

        String username_conf = null;
        String password_conf = null;

        try (FileReader reader = new FileReader("src/app.conf")) {
            Properties properties = new Properties();
            properties.load(reader);

            username_conf = properties.getProperty("username");
            password_conf = properties.getProperty("password");


        } catch (Exception exception) {
            exception.printStackTrace();
        }
        if (username_conf.equals(username) && password_conf.equals(password)) {
            result = true;
        }
        return result;
    }
}
