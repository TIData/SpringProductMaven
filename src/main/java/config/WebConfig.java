package config;

import domain.Product;
import domain.ProductManager;
import domain.SimpleProductManager;
import java.util.ArrayList;
import java.util.Arrays;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("controller")
public class WebConfig extends WebMvcConfigurerAdapter {

    @Bean
    public ProductManager productManager() {
//zonder databank
        Product[] products = {new Product("Lamp", 5.751),
            new Product("Tafel", 75.2), new Product("Stoel", 22.791)};
        SimpleProductManager productManager = new SimpleProductManager();
        productManager.setProducts(new ArrayList<>(Arrays.asList(products)));
        return productManager;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**").addResourceLocations("resources/css/");
    }

    @Bean
    public ViewResolver viewResolver() {

        InternalResourceViewResolver resolver
                = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/jsp/");
        resolver.setSuffix(".jsp");
        return resolver;

    }
    
    @Bean
    public MessageSource messageSource()
    {
        ResourceBundleMessageSource messageSource = 
                new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        return messageSource;
    }
}
