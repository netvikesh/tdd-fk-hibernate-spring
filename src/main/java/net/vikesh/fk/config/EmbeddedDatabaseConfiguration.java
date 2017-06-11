package net.vikesh.fk.config;

import org.hsqldb.jdbc.JDBCPool;
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
@Profile(value = "develop")
@PropertySource(value = "classpath:/develop.properties")
public class EmbeddedDatabaseConfiguration {

    @Resource
    private Environment env;

    @Bean
    public DataSource dataSource() {
        JDBCPool dataSource = new JDBCPool();
        dataSource.setUser("SA");
        dataSource.setUrl(env.getProperty("db.url"));
        dataSource.setUser(env.getProperty("db.username"));
        dataSource.setPassword(env.getProperty("db.password"));
        return dataSource;
    }


    @Bean(name = "jpaProperties")
    public Properties jpaProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect", "org.hibernate.dialect.HSQLDialect"));
        properties.setProperty("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto", "update"));
        properties.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql", "true"));
        properties.setProperty("hibernate.format_sql", env.getProperty("hibernate.format_sql", "true"));
        return properties;
    }

}
