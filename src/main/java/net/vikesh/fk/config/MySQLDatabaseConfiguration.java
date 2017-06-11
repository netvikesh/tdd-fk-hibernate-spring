package net.vikesh.fk.config;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by vikes on 11-06-2017.
 */
@Configuration
@Profile(value = "production")
@PropertySource("classpath:/production.properties")
public class MySQLDatabaseConfiguration {

    @Resource
    private Environment env;

    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUsername(env.getProperty("db.username"));
        dataSource.setPassword(env.getProperty("db.password"));
        dataSource.setUrl(env.getProperty("db.url"));
        dataSource.setValidationQuery(env.getProperty("db.validationQuery"));
        dataSource.setMaxIdle(Integer.parseInt(env.getProperty("db.maxIdle")));
        dataSource.setDriverClassName(env.getProperty("db.driver"));
        return dataSource;
    }

    @Bean(name = "jpaProperties")
    public Properties jpaProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect", "org.hibernate.dialect.MySQL57Dialect"));
        properties.setProperty("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto", "update"));
        properties.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql", "false"));
        properties.setProperty("hibernate.format_sql", env.getProperty("hibernate.format_sql", "false"));
        return properties;
    }
}
