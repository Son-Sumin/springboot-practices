package com.hello.springboothello.ex.service;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hello.springboothello.ex.repository.JdbcMemberRepository;
import com.hello.springboothello.ex.repository.MemberRepository;


/*
 자바 코드로 직접 스프링 빈 등록하기
 스프링이 뜰때 @Configuration 확인 후 @Bean을 찾아 Bean 등록해준다.
  
 */
@Configuration
public class SpringConfig {

	private DataSource dataSource;
	
	@Bean
	public MemberService memberService() {
		return new MemberService(memberRepository());
	}
	
	@Bean
	public MemberRepository memberRepository() {
		//return new MemoryMemberRepository();    // interface는 당연히 객체 생성 불가
		return new JdbcMemberRepository(dataSource);
	}
} 
