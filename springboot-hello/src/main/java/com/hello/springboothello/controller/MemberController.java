package com.hello.springboothello.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.hello.springboothello.ex.domain.Member;
import com.hello.springboothello.ex.domain.MemberForm;
import com.hello.springboothello.ex.service.MemberService;

@Controller
public class MemberController {

	// private final MemberService memberService = new memberService;
	// 여러 번 생성할 필요가 없고 한 번만 생성해서 공용으로 사용하면 됨
	// 이제부터 스프링 컨테이너에 등록하고 쓰자. 스프링 컨테이너에는 딱 하나만 등록이 됨.
	
	private final MemberService memberService;
	
	// 생성자 설정
	// @Autowired
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@GetMapping("/members/new")  // URL 접근, 조회은 보통 @GetMapping
	public String createForm() {
		return "members/createMemberForm";
	}
	
	@PostMapping("/members/new")  // form에 내용을 담아서 넘길 때 @PostMapping
	public String create(MemberForm form) {
		Member member = new Member();
		member.setName(form.getName());
		
		System.out.println("member = " + member.getName());
		memberService.join(member);

		return "redirect:/";
	}
	
	@GetMapping("/members")
	public String list(Model model) {
		List<Member> members = memberService.findMembers();
		model.addAttribute("members", members);
		return "members/memberList";
	}
}
	

/*
스프링 컨테이터가 뜰 때 @Controller을 보고 MemberController 객체를 생성하여 갖고있다
(이를 스프링 컨테이터에서 스프링 빈이 관리된다라고 표현함)
MemberController가 생성자 호출도 같이함
그런데 생성자에 @Autowired가 있으면 스프링이 스프링 컨테이터에 있는 MemberService memberService를 연결해줌
지금 상태에서 실행하면 ~that could not be found. 나옴. 이유는 스프링이 MemberService 가치를 모르기 때문
그래서 그 전에 MemberService에 @Service을 붙이면 스프링이 스프링 컨테이너에 MemberService를 등록해줌
*/
/*
* DI 주입 방법1 - 생성자 주입
* DI 주입 방법2 - 필드 주입
  단점: 더 이상 수정이 힘들다
@Autowired
private MemberService memberService;
	
* DI 주입 방법3 - setter 주입
  단점: Controller를 호출했을 때 public void setMemberService 상태여야 한다.
  public으로 노출되어 있어 바뀔 수 있는 상황이고, 중간에 잘못 바꾸면 문제가 된다. 사실 처음에만 setter를 만지지만 이후에는 만질 일이 없다.

private MemberService memberService;
@Autowired
public void setMemberService(MemberService memberService) {
	this.memberService = memberService;
	}
	
*/