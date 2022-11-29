package com.bitacademy.springbootex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootExApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootExApplication.class, args);
	}

}


/**
 * 
 * Maven project(jar) springboot-ex 내용 
 *
 * @SpringBootApplication 기본틀
 * 메인: SpringApplication.run(SpringbootExApplication.class, args);
 * properties: 향후 수정 소요 있을만한 것들
 * test: 메인 실행 전 테스트
 * 
 */