package io.how2coder.demo.db.connection;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

public class ConnectionManager {

    private static final String DATA_SOURCE_PROP_FILE = "datasource.properties";

    private static volatile HikariDataSource dataSource;

    private ConnectionManager() {
    }

    public static Connection getConnection() throws Exception {
        if (dataSource == null) {
            synchronized (ConnectionManager.class) {
                if (dataSource == null) {
                    InputStream inputStream = ClassLoader.getSystemResourceAsStream(DATA_SOURCE_PROP_FILE);
                    Properties properties = new Properties();
                    properties.load(inputStream);

                    HikariConfig config = new HikariConfig(properties);
                    dataSource = new HikariDataSource(config);
                }
            }
        }
        return dataSource.getConnection();
    }
}
