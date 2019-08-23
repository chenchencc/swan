package com.swan.dao.jdbc;


import com.swan.string.StringUtils;
import java.sql.Connection;
import java.sql.SQLException;
import org.springframework.beans.factory.InitializingBean;

public class SingleDataSource extends AbstractDataSource implements InitializingBean {

    private String jdbcRef;
    private int maxActiveSize;
    private int minActiveSize;
    private int coreActiveSize;
    private String dataSourceType;

    @Override
    public void init() {

    }

    @Override
    public Connection getConnection() throws SQLException {
        return null;
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return null;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (StringUtils.isEmpty(jdbcRef)) {
            throw new IllegalArgumentException("datasource jdbcRef is empty");
        }

        if (StringUtils.isEmpty(dataSourceType)) {
            throw new IllegalArgumentException("datasource type is empty");
        }

        init();
    }
}
