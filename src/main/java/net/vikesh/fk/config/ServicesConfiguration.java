package net.vikesh.fk.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.transaction.Transactional;

/**
 * Created by vikes on 04-07-2017.
 */
@Configuration
@Transactional
@ComponentScan(basePackages = {"net.vikesh.fk.service"})
public class ServicesConfiguration {
}
