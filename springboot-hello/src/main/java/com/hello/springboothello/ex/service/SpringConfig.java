package com.hello.springboothello.ex.service;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hello.springboothello.ex.repository.JpaMemberRepository;
import com.hello.springboothello.ex.repository.MemberRepository;


/*
 자바 코드로 직접 스프링 빈 등록하기
 스프링이 뜰때 @Configuration 확인 후 @Bean을 찾아 Bean 등록해준다.
  
 */
@Configuration
public class SpringConfig {

	// 스프링 데이터 JPA에 만들어 놓은 구현체가 등록된다
	private final MemberRepository memberRepository;
	
	@Autowired
	public SpringConfig(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}
	
//	private EntityManager em;
//	
//	@Autowired
//	public SpringConfig(EntityManager em) {
//		this.em = em;
//	}
	
//	private DataSource dataSource;
//	
//	@Autowired
//	public SpringConfig(DataSource dataSource) { this.dataSource = dataSource; }
	
	@Bean
	public MemberService memberService() {
		return new MemberService(memberRepository);
	}
	
//	@Bean
//	public MemberRepository memberRepository() {
		//return new MemoryMemberRepository();    // interface는 당연히 객체 생성 불가
		//return new JdbcMemberRepository(dataSource);
		//return new JdbcTemplateMemberRepository(dataSource);
//		return new JpaMemberRepository(em);
//	}
} 
