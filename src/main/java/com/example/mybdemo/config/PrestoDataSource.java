package com.example.mybdemo.config;

import com.alibaba.druid.pool.DruidDataSource;
import java.sql.SQLException;
import javax.sql.DataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * DataSource配置
 * @author
 * @date 2020-03-23
 */
@Slf4j
@Configuration
@EnableTransactionManagement
public class PrestoDataSource {

    @Autowired
    private Environment env;

    @Bean(name = "mySQLJdbcDataSource")
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(env.getProperty("spring.datasource.mysql01.url"));
        dataSource.setDriverClassName(env.getProperty("spring.datasource.mysql01.driver-class-name"));
        dataSource.setUsername(env.getProperty("spring.datasource.mysql01.username"));
        dataSource.setPassword(env.getProperty("spring.datasource.mysql01.password"));

        //配置统一属性
        /* */
        dataSource.setInitialSize(2);
        dataSource.setMinIdle(1);
        dataSource.setMaxActive(50);
        dataSource.setMaxWait(10000);
        dataSource.setTestOnBorrow(false);
        dataSource.setTestOnReturn(false);

        try {
            dataSource.setFilters("stat");
        } catch (SQLException e) {
            log.error("Druid configuration initialization filter error.", e);
        }

        return dataSource;
    }

    @Bean(name = "mySQLJdbcTemplate")
    public JdbcTemplate prestoJdbcTemplate(@Qualifier("mySQLJdbcDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
