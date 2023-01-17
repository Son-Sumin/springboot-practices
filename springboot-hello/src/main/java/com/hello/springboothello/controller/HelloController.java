package com.hello.springboothello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
	
	@GetMapping("hello")
	public String hello(Model model) {
		model.addAttribute("data", "hello!!");   // (attributeName, attributeValue)
		return "hello";
	}
}

/*
 * 동작 원리 *
웹 브라우저에서 localhost:8080/hello 을 던지면
스프링부트에 내장된 톰켓 서버가 스프링 컨테이너에게 넘긴다.
스프링 컨테이너 안에 있는 HelloController 중 @GetMapping에 반응하여 get방식으로 넘어온 "hello"가 @GetMapping("hello") 매칭된다.

HelloController 안에 있는 String hello 메소드가 실행된다.
스프링이 model이라는 것을 만들어 "data" 넣어준다.
스프링이 templates/hello.html을 찾아서 model에 넘기고 Thymeleaf 템플릿 엔진이 hello.html 처리를 해준다.

컨트롤러에서 리턴 값으로 문자를 반환하면 뷰 리졸버(viewResolver)가 화면을 찾아서 처리한다.
  - 스프링 부트 템플릿엔진 기본 viewName 매핑
  - resources:templates/ +{ViewName}+ .html

 */
