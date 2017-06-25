package net.vikesh.fk.config;

import org.apache.logging.slf4j.Log4jMarker;
import org.slf4j.Marker;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value = {RepositoryConfiguration.class})
public class ApplicationConfig {
}
