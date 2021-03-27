package org.deneb.poc.server.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;


@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"org.deneb.poc.server"})
public class ServerConfig implements WebMvcConfigurer {
	 @Autowired
	    private ApplicationContext applicationContext;

	    @Bean
	    public SpringResourceTemplateResolver templateResolver() {

	        var templateResolver = new SpringResourceTemplateResolver();

	        templateResolver.setApplicationContext(applicationContext);
	        templateResolver.setPrefix("classpath:/templates/");
	        templateResolver.setSuffix(".html");

	        return templateResolver;
	    }

	    @Bean
	    public SpringTemplateEngine templateEngine() {

	        var templateEngine = new SpringTemplateEngine();
	        templateEngine.setTemplateResolver(templateResolver());
	        templateEngine.setEnableSpringELCompiler(true);

	        return templateEngine;
	    }

	    @Bean
	    public ViewResolver viewResolver() {

	        var resolver = new ThymeleafViewResolver();
	        var registry = new ViewResolverRegistry(null, applicationContext);

	        resolver.setTemplateEngine(templateEngine());
	        registry.viewResolver(resolver);

	        return resolver;
	    }
	
}
