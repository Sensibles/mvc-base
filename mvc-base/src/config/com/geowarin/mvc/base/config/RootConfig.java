package com.geowarin.mvc.base.config;

import org.springframework.context.annotation.*;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = { "com.geowarin.mvc.base.controller" },
excludeFilters={
@Filter(type=FilterType.ANNOTATION, value=EnableWebMvc.class)
})
public class RootConfig {

}