package net.vikesh.fk.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * Created by vikekumar on 6/12/2017.
 */
@Configuration
@EnableWebMvc
@ComponentScan(value = {"net.vikesh.fk.web"})
public class DispatcherConfig extends WebMvcConfigurerAdapter {

    private final static Logger LOGGER = LoggerFactory.getLogger(DispatcherConfig.class);

    @Resource
    private Environment environment;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/ui/**").addResourceLocations("/WEB-INF/dist/");
        String[] activeProfiles = environment.getActiveProfiles();
        List<String> activeProfilesList = Arrays.asList(activeProfiles);
        if (LOGGER.isDebugEnabled()) {
            activeProfilesList.forEach(profile -> {
                LOGGER.debug("Active Profiles " + profile);
            });
        }
        if (activeProfilesList.contains("develop")) {
            registry.addResourceHandler("/app/**").addResourceLocations("/WEB-INF/app-dev/");
        }
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.viewResolver(internalResourceViewResolver());
    }


    private ViewResolver internalResourceViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
}
