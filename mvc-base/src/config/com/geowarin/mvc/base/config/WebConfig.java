package com.geowarin.mvc.base.config;

import java.nio.charset.StandardCharsets;


import org.springframework.beans.BeansException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.geowarin.mvc" })
public class WebConfig extends WebMvcConfigurerAdapter implements ApplicationContextAware {


	private ApplicationContext applicationContext;
	private static final String UTF8 = "UTF-8";
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
		
	}



	/**
	 * Used to create viewResolver (a way of building views in Spring mvc). We can
	 * use 'default' viewResolver like internalResourceViewResolver or we can use
	 * apache tiles view resolver or even Thymeleaf viewresolver.
	 * 
	 * @return
	 */

	// @Bean
	// public ViewResolver viewResolver() {
	//
	// InternalResourceViewResolver viewResolver = new
	// InternalResourceViewResolver();
	// // viewResolver.setViewClass(JstlView.class);
	// viewResolver.setPrefix("/WEB-INF/views/");
	// viewResolver.setSuffix(".jsp");
	// viewResolver.setExposeContextBeansAsAttributes(true);
	// return viewResolver;
	// }
	
	 @Bean
	    public ViewResolver viewResolver() {
	        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
	        resolver.setTemplateEngine(templateEngine());
	        resolver.setCharacterEncoding(UTF8);
	        return resolver;
	    }

	    private TemplateEngine templateEngine() {
	        SpringTemplateEngine engine = new SpringTemplateEngine();
	        engine.setTemplateResolver(templateResolver());
	        return engine;
	    }

	    private ITemplateResolver templateResolver() {
	        SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
	        resolver.setApplicationContext(applicationContext);
	        resolver.setPrefix("/WEB-INF/views/");
	        resolver.setSuffix(".html");
	        resolver.setTemplateMode(TemplateMode.HTML);
	        return resolver;
	    }


	/**
	 * Used to bind messages from view with some properties files that contains
	 * text.
	 * 
	 * @return
	 */

	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("messages");
		return messageSource;
	}

}
