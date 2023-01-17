package com.hello.springboothello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	
	@GetMapping("hello")
	public String hello(Model model) {
		model.addAttribute("data", "hello!!");   // (attributeName, attributeValue)
		return "hello";
	}
	
	@GetMapping("hello-mvc")
	public String helloMvc(@RequestParam("name") String name, Model model) {
		model.addAttribute("name", name);
		return "hello-template";
	}
	// localhost:8080/hello-mvc?name=spring!
	// @RequestParam(value = "name", required = false)  =>   hello null
	// required은 default가 true이고, 기본값을 넣어야한다. false면 안 넣어도 된다.
	
	@GetMapping("hello-string")
	@ResponseBody
	public String helloMvc(@RequestParam("name") String name) {
		return "hello " + name;
	}
}

/*
 * 동작 원리 *
 * @GetMapping("hello")
웹 브라우저에서 localhost:8080/hello 을 던지면
스프링부트에 내장된 톰켓 서버가 스프링 컨테이너에게 넘긴다.
스프링 컨테이너 안에 있는 HelloController 중 @GetMapping에 반응하여 get방식으로 넘어온 "hello"가 @GetMapping("hello") 매칭된다.

HelloController 안에 있는 String hello 메소드가 실행된다.
스프링이 model이라는 것을 만들어 "data" 넣어준다.
스프링이 templates/hello.html을 찾아서 model에 넘기고 Thymeleaf 템플릿 엔진이 hello.html 처리를 해준다.

컨트롤러에서 리턴 값으로 문자를 반환하면 뷰 리졸버(viewResolver)가 화면을 찾아서 처리한다.
  - 스프링 부트 템플릿엔진 기본 viewName 매핑
  - resources:templates/ +{ViewName}+ .html
  
  
 * 동작 원리 *
 * @GetMapping("hello-mvc")
웹 브라우저에서 localhost:8080/hello-mvc 를 넘기면
스프링부트에 내장된 톰켓 서버가 스프링 컨테이너에게 넘긴다.
스프링 컨테이너 안에 있는 HelloController 중 @GetMapping에 반응하여 get방식으로 넘어온 "hello-mvc" @GetMapping("hello-mvc") 매칭된다. 

스프링은 HelloController 안에 있는 String helloMvc 메소드를 호출해준다.
그리고 hello-template.html을 model과 스프링에 반환한다. 스프링은 이를 viewResolver에게 넘겨준다.
이 때 model의 키값 name: 값 value 를 넣어준다.

스프링은 viewResolver(화면 구성)가 view를 찾아주고 template engine을 연결시켜준다.
viewResolver가 리턴받은 "hello-template"와 똑같은 이름을 가진 templates/hello-template.html 찾는다.
찾은 것을 Thymeleaf 템플릿 엔진 처리해달라고 Thymeleaf에게 넘긴다.
  - 스프링 부트 템플릿엔진 기본 viewName 매핑
템플릿 엔진이 렌더링 후 변환한 html을 웹 브라우저에 넘긴다.

정적컨텐츠는 변환없이 넘긴다.
 */
