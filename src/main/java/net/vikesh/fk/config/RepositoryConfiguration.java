package net.vikesh.fk.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by vikes on 11-06-2017.
 */
@Configuration
@EnableJpaRepositories(basePackages = "net.vikesh.fk.repository")
@Import(value = {EntityManagerConfiguration.class})
public class RepositoryConfiguration {
}
