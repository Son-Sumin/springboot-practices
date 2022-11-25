package com.bitacademy.springboot.helloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * HelloWorldApplication 클래스의 역할
 * 1. 스프링 애플리케이션의 부트스트래핑 역할(Bootstrapping Class)
 * 2. 설정 클래스 역할(Configuration Class)
 * 
 *  Bootstrapping Class 최상단에 둔다
 *  그 이하로 다 찾으라고 지시하기에
 */

@SpringBootApplication
public class HelloWorldApplication {

	public static void main(String[] args) {
		/**
		 * SpringApplication.run(...) 안에서 일어나는 일(Bootstrap)
		 *      -> 모든 BootString class는 위 코드를 꼭 쓴다.
		 * 
		 * 1. 애플리케이션 컨텍스트(Application Context, so called Spring Container) 생성
		 * 2. 만약 웹 애플리케이션이면(Library 확인하면 알 수 있음), 웹애플리케이션 타입을 결정(Spring MVC or Reactive)
		 * 3. 어노테이션 스캐닝(Auto) + Configuration Class(Explicity) 통한 Bean 생성/등록/와이어링(DI) 작업
		 * 4. 만약 웹애플리케이션이고 타입이 Spring MVC(tomcat 실행됨)이면 
		 *     - 내장(embeded) 서버(TomcatEmbeddedServiceServletContainer) 인스턴스 생성
		 *     - 서버 인스턴스에 웹 애플리케이션을 배포
		 *     - 서버 인스턴스 실행
		 * 5. ApplicationRunner 인터페이스를 구현한 빈을 Application Context에서 찾아서 실행(run 호출)
		 * 
		 */
		
//		ConfigurableApplicationContext ac = null;
//		try {
//			 ac = SpringApplication.run(HelloWorldApplication.class, args);
//		} catch(Throwable ex) {
//			ex.printStackTrace();
//		} finally {
//			ac.close();
//		}
		
		// try ~ with ~ resources 구문 사용 예정, try만 사용하면 됨 (위가 너무 길다!!)
		try(ConfigurableApplicationContext ac = SpringApplication.run(HelloWorldApplication.class, args)) {}

		
	}

}
