package com.hello.springboothello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootHelloApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootHelloApplication.class, args);
	}

}

/*
스프링 빈을 등록하는 2가지 방법
1. 컴포넌트 스캔과 자동 의존관계 설정
2. 자바 코드로 직접 스프링 빈 등록하기

1 방법 중에서
@Component 를 포함하는 다음 애노테이션도 스프링 빈으로 자동 등록된다.
@Controller  @Service  @Repository

그런데 아무 곳에나 @ 붙으면 실행이 될까?
아니다!!

SpringbootHelloApplication에서 실행하고 있는데 이 패키지 포함한 그 아래에 있는 패키지들부터 컴포넌트 스캔한다.
그래서 실행파일 아래에 @이 위치해야 한다.

*/