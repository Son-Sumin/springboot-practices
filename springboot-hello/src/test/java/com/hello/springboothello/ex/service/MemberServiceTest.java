package com.hello.springboothello.ex.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.hello.springboothello.ex.domain.Member;
import com.hello.springboothello.ex.repository.MemoryMemberRepository;

// test의 메소드명은 한글도 가능하다!!
/*
 * given : 무언가가 주어졌을 때
 * when : 이것을 실행했을 때
 * then : 이런 결과가 나와야 한다
 */

/*
 * MemberService memberService = new MemberService();
 * private final MemberRepository memberRepository;
 * 
 * 위 2개는 서로 다른 객체임. 같은 객체로서 활용하기 위해 private final~ 을 public을 통해 외부에서 넣어줄 수 있도록 함
 * -> DI(Dependency Injection)
 */

class MemberServiceTest {
	
	MemberService memberService;
	MemoryMemberRepository memberRepository;
	
	@BeforeEach
	public void beforeEach() {
		memberRepository = new MemoryMemberRepository();
		memberService = new MemberService(memberRepository);
	}
	
	@AfterEach
	public void afterEach() {
		memberRepository.clearStore();
	}
	
	@Test
	void 회원가입() {
		// given
		Member member = new Member();
		member.setName("spring");
		
		// when
		Long saveId = memberService.join(member);
		
		// then
		Member findMember = memberService.findOne(saveId).get();
		assertThat(member.getName()).isEqualTo(findMember.getName());
	}

	@Test
	public void 중복회원예외() {
		// given
		Member member1 = new Member();
		member1.setName("spring");
		
		Member member2 = new Member();
		member2.setName("spring");
		
		// when
		memberService.join(member1);
		IllegalStateException e = assertThrows(IllegalStateException.class,
				() -> memberService.join(member2));  // () -> memberService.join(member2) 실행하기 위해 IllegalStateException 발생해야함
		
		assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
		
		/* try~catch 사용
		try {
			memberService.join(member2);
			fail("예외가 발생해야 합니다");
		} catch (IllegalStateException e) {
			assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
		}
		 */
		
		// then
		
	}

	@Test
	void findMembers() {
	}

	@Test
	void findOne() {
	}

}
