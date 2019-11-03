package com.spring.security.config;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.beans.PropertyVetoException;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.spring.security")
@PropertySource("classpath:persistence_mysql.properties")
public class DemoAppConfig {

    //holding properties
    @Autowired
    private Environment env;

    //define a bean for view resolver
    @Bean
    public ViewResolver viewResolver(){

        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/view/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    //Bean for dataSource
    @Bean
    public DataSource securityDataSource() throws PropertyVetoException {

        //creating a pool
        ComboPooledDataSource securityDataSource = new ComboPooledDataSource();

        //set JDBC driver class
        securityDataSource.setDriverClass(env.getProperty("jdbc.driver"));

        //set database connection props
        securityDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
        securityDataSource.setUser(env.getProperty("jdbc.user"));
        securityDataSource.setPassword(env.getProperty("jdbc.pass"));

        //
        System.out.println("JDBC.url " + env.getProperty("jdbc.url"));
        System.out.println("JDBC.user " + env.getProperty("jdbc.user"));
        System.out.println("JDBC.pass " + env.getProperty("jdbc.pass"));

        //set connection pool props
        securityDataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
        securityDataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
        securityDataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
        securityDataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));
        return securityDataSource;
    }

    private int getIntProperty(String propName){
        String popVal=env.getProperty(propName);
        int intPropVal = Integer.parseInt(popVal);
        return intPropVal;
    }


}
