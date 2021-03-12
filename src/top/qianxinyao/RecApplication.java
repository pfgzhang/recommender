package top.qianxinyao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RecApplication {

    public static void main(String[] args) {
        SpringApplication.run(RecApplication.class, args);
    }
    /*@Bean
    public InternalResourceViewResolver set(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/static/public/");
        resolver.setSuffix(".html");
        return resolver;
    }*/

}
