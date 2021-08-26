package com.atguigu.boot.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Arrays;

@Configuration
public class DataSourceConfig {

    @Bean
    @ConfigurationProperties("spring.datasource")
    public DataSource dataSource() throws SQLException {
        DruidDataSource druidDataSource = new DruidDataSource();
        //druidDataSource.setFilters("stat,wall");
        return druidDataSource;
    }

    /*监控网站*/
    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        StatViewServlet statViewServlet = new StatViewServlet();
        ServletRegistrationBean<StatViewServlet> registrationBean =
                new ServletRegistrationBean<>(statViewServlet, "/druid/*");
        registrationBean.addInitParameter("loginUsername","root");
        registrationBean.addInitParameter("loginPassword","root");
        return registrationBean;
    }

    /*web-jdbc*/
    /*请求的次数*/

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        WebStatFilter webStatFilter = new WebStatFilter();
        FilterRegistrationBean<WebStatFilter> webStatFilterFilterRegistrationBean =
                new FilterRegistrationBean<>(webStatFilter);
        webStatFilterFilterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png.*.css,*.ico,/druid/*");
        webStatFilterFilterRegistrationBean.setUrlPatterns(Arrays.asList("/*"));

        return webStatFilterFilterRegistrationBean;

    }

    /*防火墙*/

}
