package com.hehe.springBootDemo.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DruidConfig {

    //绑定以spring.datasource开头的属性(application.yml)
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druid() {
        return new DruidDataSource();
    }

    // 配置druid的监控
    // 1.配置一个管理后台的servlet
    @Bean
    public ServletRegistrationBean statViewServlet() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        Map<String, String> map = new HashMap<>(16);
        map.put("loginUsername", "admin");
        map.put("loginPassword", "password");
        map.put("allow", "");//允许访问ip
        map.put("deny", "");//拒绝访问ip
        servletRegistrationBean.setInitParameters(map);
        return servletRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
        Map<String,String> map = new HashMap<>(16);
        map.put("exclusions","*.js,*.css,/druid/*");
        filterRegistrationBean.setInitParameters(map);
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/*"));
        return filterRegistrationBean;
    }

}
