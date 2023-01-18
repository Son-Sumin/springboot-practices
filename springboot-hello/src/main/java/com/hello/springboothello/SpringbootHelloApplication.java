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
   스프링이 뜰때 @Configuration 확인 후 @Bean을 찾아 Bean 등록해준다.
   참고: SpringConfig.java

1 방법 중에서
@Component 를 포함하는 다음 애노테이션도 스프링 빈으로 자동 등록된다.
@Controller  @Service  @Repository

그런데 아무 곳에나 @ 붙으면 실행이 될까?
아니다!!

SpringbootHelloApplication에서 실행하고 있는데 이 패키지 포함한 그 아래에 있는 패키지들부터 컴포넌트 스캔한다.
그래서 실행파일 아래에 @이 위치해야 한다.
*/

/*
실무에서는 주로 정형화된 컨트롤러, 서비스, 리포지토리 같은 코드는 컴포넌트 스캔을 사용한다. 
그리고 정형화되지 않거나, 상황에 따라 구현 클래스를 변경해야 하면 설정을 통해 스프링 빈으로 등록한다.
지금처럼 DB가 결정되지 않았다는 시나리오 아래에서 일단 메모리를 만들고 추후에 이 메모리를 교체할 때 기존 코드 수정 없이 SpringConfig만 수정하면 이상없이 돌아간다.

그래서 수동 설정도 알아야 하고 중요하다.
*/