package kr.or.connect.bookservice.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({DBConfig.class})
@ComponentScan(basePackages= {"kr.or.connect.bookservice.dao","kr.or.connect.bookservice.service"})
public class ApplicationConfig {

}
