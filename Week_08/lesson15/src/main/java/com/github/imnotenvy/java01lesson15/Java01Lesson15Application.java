package com.github.imnotenvy.java01lesson15;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootApplication
public class Java01Lesson15Application implements CommandLineRunner {

    Logger logger = LoggerFactory.getLogger(Java01Lesson15Application.class);

    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(Java01Lesson15Application.class, args);
    }

    public void showConnection() throws SQLException {
        logger.info("dataSource: {}", dataSource.getClass().getName());
        Connection connection = dataSource.getConnection();
        logger.info("Connection: {}", connection.toString());
    }

    public void insertData() throws SQLException {
        jdbcTemplate.execute("INSERT INTO t_order VALUES (1, 'SUCCESS')");
        jdbcTemplate.execute("INSERT INTO t_order VALUES (2, 'SUCCESS')");
        jdbcTemplate.execute("INSERT INTO t_order VALUES (3, 'SUCCESS')");
        jdbcTemplate.execute("INSERT INTO t_order VALUES (4, 'SUCCESS')");
        jdbcTemplate.execute("INSERT INTO t_order VALUES (5, 'SUCCESS')");
        jdbcTemplate.execute("INSERT INTO t_order VALUES (120312, 'SUCCESS')");
    }

    public void queryData() throws SQLException {
        jdbcTemplate.execute("SELECT * FROM t_order WHERE user_id = 3");

    }

    @Override
    public void run(String... args) throws Exception {
        insertData();
    }
}
