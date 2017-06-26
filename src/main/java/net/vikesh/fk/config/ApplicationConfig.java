package net.vikesh.fk.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value = {RepositoryConfiguration.class})
public class ApplicationConfig {
}
