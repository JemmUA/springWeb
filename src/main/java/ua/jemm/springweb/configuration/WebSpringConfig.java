package ua.jemm.springweb.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("ua.jemm.springweb.configuration")
@PropertySource("classpath:application.properties")
public class WebSpringConfig {

}
