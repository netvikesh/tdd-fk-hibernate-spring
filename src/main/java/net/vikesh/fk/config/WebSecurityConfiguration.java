package net.vikesh.fk.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author Vikesh
 */
@Configuration
@EnableWebSecurity
@Import(value = RepositoryConfiguration.class)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
}
