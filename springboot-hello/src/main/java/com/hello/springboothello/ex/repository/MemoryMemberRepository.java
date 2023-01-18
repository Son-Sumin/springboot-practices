package com.hello.springboothello.ex.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.hello.springboothello.ex.domain.Member;

//@Repository
public class MemoryMemberRepository implements MemberRepository {

	private static Map<Long, Member> store = new HashMap<>();
	private static long sequence = 0L;
	
	@Override
	public Member save(Member member) {
		member.setId(++sequence);
		store.put(member.getId(), member);
		return member;
	}
	
	@Override
	public Optional<Member> findById(Long id) {
		return Optional.ofNullable(store.get(id));  // null이 반환될 가능성이 있으면 Optional.ofNullable()로 감싸기
	}
	
	@Override
	public Optional<Member> findByName(String name) {
		return store.values().stream()										// loop로 돌리기
						.filter(member -> member.getName().equals(name))	// 람다 사용, member.getName()이 변수 'name'과 같은지 확인, 같은 경우만 필터링
						.findAny();		// 하나라도 찾으면 반환
										// 없으면 Optional의 null이 포함되어 반환됨
	}
	
	@Override
	public List<Member> findAll() {
		return new ArrayList<>(store.values());		//  Map<Long, Member>의 Member가 values() 의미함
	}
	
	public void clearStore() {
		store.clear();
	}
}
