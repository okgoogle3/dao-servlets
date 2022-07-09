package com.avtopark.Model;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.util.ResourceBundle;

public class ConnectionPool {
    public static DataSource getDatasource() {
        ResourceBundle rs = ResourceBundle.getBundle("db");
        HikariConfig config = new HikariConfig();
        config.setUsername(rs.getString("user"));
        config.setPassword(rs.getString("password"));
        config.setJdbcUrl(rs.getString("url"));
        DataSource ds = new HikariDataSource(config);
        return ds;
    }
}
