package com.swan.dao.jdbc;


import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Logger;
import javax.sql.DataSource;
import org.springframework.beans.factory.InitializingBean;

public class GroupDataSource implements DataSource,InitializingBean {

    private Object defaultTargetDataSource;
    private Map<String,DataSource> targetDataSource;
    private DataSource defaultDataSource;
    private PrintWriter out;
    private int timeout;

    public Object getDefaultTargetDataSource() {
        return defaultTargetDataSource;
    }

    public void setDefaultTargetDataSource(Object defaultTargetDataSource) {
        this.defaultTargetDataSource = defaultTargetDataSource;
    }

    public Map<String, DataSource> getTargetDataSource() {
        return targetDataSource;
    }

    public void setTargetDataSource(Map<String, DataSource> targetDataSource) {
        this.targetDataSource = targetDataSource;
    }

    @Override
    public Connection getConnection() throws SQLException {
        return obtainDataSource().getConnection();
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return obtainDataSource().getConnection(username,password);
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return obtainDataSource().unwrap(iface);
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return obtainDataSource().isWrapperFor(iface);
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return out;
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {
        this.out = out;
    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {
        this.timeout = seconds;
    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (Objects.isNull(targetDataSource)) {
            throw new IllegalArgumentException(" default dataSource param is empty");
        }

        if (targetDataSource instanceof  DataSource) {
            defaultDataSource = (DataSource) targetDataSource;
        }



        throw new IllegalArgumentException(" default dataSource type is not datasource");
    }

    private DataSource obtainDataSource() {
        return defaultDataSource;
    }
}
