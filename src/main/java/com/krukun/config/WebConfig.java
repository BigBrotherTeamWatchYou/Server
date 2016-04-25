package com.krukun.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by Eugeniy Krukun on 25.04.2016.
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.krukun")
public class WebConfig extends WebMvcConfigurerAdapter{

}
