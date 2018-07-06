package ash.boot.mvcexample;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

@Configuration
@EnableWebMvc
@ComponentScan("ash.boot.mvcexample")
public class WebAppConfig implements  WebMvcConfigurer {
	
	@Bean
    @Description("Thymeleaf template resolver serving HTML 5")
    public ClassLoaderTemplateResolver templateResolver() {
        //bean required to use Thymeleaf and it's perks, eg auto csrf
        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        
        templateResolver.setPrefix("WEB-INF/html/");
        templateResolver.setCacheable(false);
        templateResolver.setSuffix(".html");        
        templateResolver.setTemplateMode("HTML");
        templateResolver.setCharacterEncoding("UTF-8");
        
        return templateResolver;
    }
	
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
		//used to make these files available for use when called in html header
        registry.addResourceHandler(
                "/webjars/**",
                "/img/**",
                "/css/**",
                "/js/**")
                .addResourceLocations(
                        "classpath:/META-INF/resources/webjars/",
                        "classpath:/WEB-INF/img/",
                        "classpath:/WEB-INF/css/",
                        "classpath:/WEB-INF/js/");
    }

    @Bean
    @Description("Thymeleaf template engine with Spring integration")
    public SpringTemplateEngine templateEngine() {
    	
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());

        return templateEngine;
    }

    @Bean
    @Description("Thymeleaf view resolver")
    public ViewResolver viewResolver() {

        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        
        viewResolver.setTemplateEngine(null);
        viewResolver.setCharacterEncoding("UTF-8");

        return viewResolver;
    }    

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
    	//Set mappings for View resolver
        registry.addViewController("/").setViewName("/navigations/home");
        registry.addViewController("/home").setViewName("/navigations/home");
        registry.addViewController("/securityHome").setViewName("/security/securityHome");
        registry.addViewController("/hello").setViewName("/security/hello");
        registry.addViewController("/login").setViewName("/security/login");
    }
}