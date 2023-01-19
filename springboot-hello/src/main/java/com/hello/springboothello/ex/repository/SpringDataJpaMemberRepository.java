package com.hello.springboothello.ex.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hello.springboothello.ex.domain.Member;

// extends : interface가 interface에게 받을 때 사용
// interface는 여러 개 상속받을 수 있음
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

		@Override
		Optional<Member> findByName(String name);
		// JPQL : select m from Member m where m.name = ?
}

// 스프링 데이터 JPA가 JpaRepository를 받고 있으면 SpringDataJpaMemberRepository를 보고 객체를 생성하여 스프링 빈으로 자동 등록해준다
// 우리는 이것을 DI하여 사용했던 것이다.

// name, username, email 등 비지니스마다 갖고 있는 이를 의미하는 것이 다양하기에 공통 구현 불가.
// 이런 것을 SpringDataJpaMemberRepository에 구현한다.

// 스프링 데이터 JPA 제공 기능
// 1. 인터페이스를 통한 기본적인 CRUD
// 2. findByName() , findByEmail() 처럼 메서드 이름만으로 조회 기능 제공
// 3. 페이징 기능 자동 제공