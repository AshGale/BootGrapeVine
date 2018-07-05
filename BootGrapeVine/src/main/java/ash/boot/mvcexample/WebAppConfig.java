package ash.boot.mvcexample;

import java.util.Set;

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
import org.thymeleaf.templateresolver.ITemplateResolver;

@Configuration
@EnableWebMvc
@ComponentScan("ash.boot.mvcexample")
public class WebAppConfig implements  WebMvcConfigurer {
	
	@Bean
    @Description("Thymeleaf template resolver serving HTML 5")
    public ClassLoaderTemplateResolver templateResolver() {
        
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
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/ajaxCSRF").setViewName("ajaxCSRF");
       // registry.addViewController("/home").setViewName("home");
        registry.addViewController("/greet").setViewName("greet");
        //registry.addViewController("/ajax").setViewName("ajaxIndex");
        registry.addViewController("/securityHome").setViewName("securityHome");
        registry.addViewController("/hello").setViewName("hello");
        registry.addViewController("/login").setViewName("login");
    }
}