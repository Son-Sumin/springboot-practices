package com.hello.springboothello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.hello.springboothello.ex.service.MemberService;

/*
 스프링 컨테이터가 뜰 때 @Controller을 보고 MemberController 객체를 생성하여 갖고있다
(이를 스프링 컨테이터에서 스프링 빈이 관리된다라고 표현함)
MemberController가 생성자 호출도 같이함
그런데 생성자에 @Autowired가 있으면 스프링이 스프링 컨테이터에 있는 MemberService memberService를 연결해줌
지금 상태에서 실행하면 ~that could not be found. 나옴. 이유는 스프링이 MemberService 가치를 모르기 때문
그래서 그 전에 MemberService에 @Service을 붙이면 스프링이 스프링 컨테이너에 MemberService를 등록해줌
 */

@Controller
public class MemberController {

	// private final MemberService memberService = new memberService;
	// 여러 번 생성할 필요가 없고 한 번만 생성해서 공용으로 사용하면 됨
	// 이제부터 스프링 컨테이너에 등록하고 쓰자. 스프링 컨테이너에는 딱 하나만 등록이 됨.
	
	private final MemberService memberService;
	
	// 생성자 설정
	@Autowired
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}
}
