package com.hello.springboothello.ex.service;

import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

import com.hello.springboothello.ex.domain.Member;
import com.hello.springboothello.ex.repository.MemberRepository;

//@Service
@Transactional   // JPA 사용하기 위해 꼭 필요함. 데이터 저장, 변경하는데 꼭 필요함.
public class MemberService {

	private final MemberRepository memberRepository;
	
	//@Autowired
	public MemberService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}
	
	/* 회원가입 */
	public Long join(Member member) {
		validateDuplicateMember(member);	// 중복 회원 검증
		memberRepository.save(member);
		return member.getId();				// 임의로 Id만 반환하는 것으로 설정
	}
	
	// 같은 이름이 있는 중복회원X
	private void validateDuplicateMember(Member member) {
		memberRepository.findByName(member.getName())
				.ifPresent(m -> {
					throw new IllegalStateException("이미 존재하는 회원입니다.");
				});
		// null의 가능성이 있으면 Optional 사용
		/*
		  Optional<Member> result = memberRepository.findByName(member.getName());
		  result.ifPresent(m ->{ ~ }
		  위를 코드 정리 
		  result가 있으면 ifPresent 작동 => Optional<Member>이기에 가능함. Optional에 많은 메소드 존재
		 */

	}
	
	/* 전체 회원 조회 */
	public List<Member> findMembers() {
		return memberRepository.findAll();
	}
	
	public Optional<Member> findOne(Long memberId) {
		return memberRepository.findById(memberId);
	}
	
}
