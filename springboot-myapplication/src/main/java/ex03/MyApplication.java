package ex03;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// @SpringBootApplication은 아래 2개를 포함함
// ex01은 @Configuration + @Bean   [Spring]
// ex02는 @SpringBootConfiguration + @Bean   [SpringBoot]
// ex03은 @SpringBootConfiguration  + @ComponentScan + 각각의 패키지

@SpringBootConfiguration
@ComponentScan
public class MyApplication {
	public static void main(String[] args) {
		try(ConfigurableApplicationContext ac = SpringApplication.run(MyApplication.class, args)) {}
		
	}
}
