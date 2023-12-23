package edu.misis.nastyusha;

import java.util.Objects;
import java.util.Properties;

public class DBProperties {

    private static final String URL = "database.url";
    private static final String USER = "database.user";
    private static final String PASSWORD = "database.password";

    private static DBProperties INSTANSE;

    private String url;
    private String user;
    private String password;
    private DBProperties() {}

    private void init(Properties properties) {
        url = properties.getProperty(URL);
        user = properties.getProperty(USER);
        password = properties.getProperty(PASSWORD);
    }

    public String getUrl() {
        return url;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public static DBProperties getProperties() {
        if(Objects.isNull(INSTANSE)) {
            INSTANSE = new DBProperties();

            INSTANSE.init(ApplicationProperties.getInstance().getProperties());
        }

        return INSTANSE;
    }

}