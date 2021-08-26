package com.atguigu.boot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

@SpringBootTest
class Boot01HelloworldApplicationTests {

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    DataSource dataSource;

    @Test
    void contextLoads() {

        //List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from payment");
       // System.out.println(maps);
        System.out.println(dataSource.getClass());

    }

}
