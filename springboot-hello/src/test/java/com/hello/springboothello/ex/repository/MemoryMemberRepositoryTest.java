package com.hello.springboothello.ex.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import com.hello.springboothello.ex.domain.Member;

class MemoryMemberRepositoryTest {  // 다른 곳에서 사용할 것이 아니므로 public일 필요 없음
	// test는 순서에 의존적으로 설계하면 안 된다!!
	// JUnit method 순서 지정 불가
	// findByName()과 findAll()의 setName이 동일하여 test 결과 Failure 발생
	// 모든 test는 각각 끝날 때마다 데이터 클리어를 해줘야한다!!!!  @AfterEach
	
	MemoryMemberRepository repository = new MemoryMemberRepository();
	
	// 각 method의 동작이 끝날 때마다 @AfterEach 동작함
	@AfterEach
	public void afterEach() {
		repository.clearStore();
	}
	
	@Test
	public void save() {
		Member member = new Member();
		member.setName("spring");
		
		repository.save(member);
		
		Member result = repository.findById(member.getId()).get();
		// System.out.println("result = " + (result == member));
		// Assertions.assertEquals(result, member);  // (expected, actual)
		assertThat(result).isEqualTo(member);
	}
	
	@Test
	public void findByName() {
		Member member1 = new Member();
		member1.setName("spring1");
		repository.save(member1);
		
		Member member2 = new Member();
		member2.setName("spring2");
		repository.save(member2);
		
		Member result = repository.findByName("spring1").get();  // get() 사용하면 Optional<Member> result -> Member result 가능
		
		assertThat(result).isEqualTo(member1);
	}
	
	@Test
	public void findAll() {
		Member member1 = new Member();
		member1.setName("spring1");
		repository.save(member1);
		
		Member member2 = new Member();
		member2.setName("spring2");
		repository.save(member2);
		
		List<Member> result = repository.findAll();
		
		assertThat(result.size()).isEqualTo(2);
	}
}

/*

회원 리포지토리 케이스 만들고 회원 리포지토리 테스트 케이스를 만들었다.
그런데 이의 순서를 완전히 뒤집어 실행하는 방법도 있다. 
이를 테스트 주도 개발(TTD)라 한다.
테스트를 먼저 만들고 구현 클래스를 만드는 것

*/