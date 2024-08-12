package com.study.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.study.springboot.domain.Member;
import com.study.springboot.repository.MemberRepository;

@Service
public class MemberService {
	
	@Autowired
	MemberRepository memberrepository;
	
	public Member insert(Member member) {
		// save() : insert할 때의 메소드(save()은 JPA에 만들어져 있음)
		
		Member rMember = memberrepository.save(member);
		return rMember;
	}
	
	
	/*
	 * Optional<T> : NullpointerException 발생을 방지하기 위해 사용
					 기존의 반환 값에 타입 T를 Optional<T> Wrapping하여,
	  				 null 대신 Optional안에 빈 타입 객체를 돌려주는 기법
	  		ex) Member member = memberrepository.findById(id);
	  			member.getId(); => NullpointerException 발생
	  
	 */
	public Optional<Member> selectOne(Long id) {
		Optional<Member> member = memberrepository.findById(id);
		return member;
	}

	public List<Member> selectAll() {
		return memberrepository.findAll();
	}


	public Member update(Member m) {
		// save() : insert할 떄의 메소드(JPA에 API)
		//			동일한 키가 있으면 update, 키가 없으면 insert
		return memberrepository.save(m);
	}


	public void delete(Member m) {
		memberrepository.delete(m);
	}

	

}
