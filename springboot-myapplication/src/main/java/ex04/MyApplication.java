package ex04;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @SpringBootApplication 메타 어노테이션
 * 
 *  + @SpringBootConfiguration : cf. @Configuration -> ex01, ex02
 *  + @ComponentScan           : ex04 패키지의 하부 패키지를 스캐닝한다.
 *  + @EnableAutoConfiguration :
 *      1. MVC, AOP, Security, JPA 등을 자동 "디폴트"(***미세설정 필수-알아야한다!!***) 설정
 *      2. 발견된 Starter Dependency(Library) 기반으로 설정한다.
 *
 * 참고) 
 * ex01은 @Configuration + @Bean   [Spring]
 * ex02는 @SpringBootConfiguration + @Bean   [SpringBoot]
 * ex03은 @SpringBootConfiguration  + @ComponentScan + 각각의 패키지
 */
@SpringBootApplication
public class MyApplication {
	public static void main(String[] args) {
		try(ConfigurableApplicationContext ac = SpringApplication.run(MyApplication.class, args)) {}	
	}
}
