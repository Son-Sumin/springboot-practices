package com.hello.springboothello.ex.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import com.hello.springboothello.ex.domain.Member;

public class JpaMemberRepository implements MemberRepository {
	
	private final EntityManager em;  // JPA를 사용하면 EntityManager 주입 받아야함. 스프링부트가 EntityManager에게 라이브러리, db connection 정보, .properties 정보들 다 연결해줌
	
	public JpaMemberRepository(EntityManager em) {
		this.em = em;
	}
	
	@Override
	public Member save(Member member) {
		em.persist(member);
		return member;
	}
	
	@Override
	public Optional<Member> findById(Long id) {
		Member member = em.find(Member.class, id);  // find(조회할 타입, 식별자 PK)
		return Optional.ofNullable(member);
	}
	
	@Override
	public Optional<Member> findByName(String name) {
		List<Member> result = em.createQuery("select m from Member m where m.name = :name", Member.class)
				.setParameter("name", name)
				.getResultList();
		
		return result.stream().findAny();
	}
	
	@Override
	public List<Member> findAll() {
		List<Member> result = em.createQuery("select m from Member m", Member.class).getResultList();
		return result;
		// jpql query 언어 : 테이블 대상이 아닌 객체 대상으로 정확히 entity 대상으로 쿼리를 날린다, 그럼 sql로 번역됨
		// select m : 객체 자체를 select
	}
}

// 여러 개의 리스트를 갖고 돌릴 때는 jpql query 필요