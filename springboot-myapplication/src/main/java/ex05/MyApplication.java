package ex05;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * package com.bitacademy.springboot.helloworld.HelloWorldApplication 참고!
 * 
 * Application Context가 구성된 이후(3번 이후) 실행할 코드(Application Context 환경에 의존, 즉 그 안에 Bean을 사용)가 있는 경우,
 * ApplicationRunner 인터페이스의 구현 클래스(HelloWorldRunner)빈 사용하기
 */
@SpringBootApplication
public class MyApplication {
	public static void main(String[] args) {
		try(ConfigurableApplicationContext ac = SpringApplication.run(MyApplication.class, args)) {}
	}	
}
