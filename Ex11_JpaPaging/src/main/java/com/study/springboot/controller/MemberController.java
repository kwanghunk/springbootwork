package com.study.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.springboot.domain.Member;
import com.study.springboot.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	@RequestMapping("/")
	public String root() {
		return "menu";
	}
	
	@RequestMapping("/selectByNameLike")
	public String selectByNameLike(String name, int page, Model model) {
		String search = name + "%";
		/*
		 * Pageable 인터페이스(Paging 처리를 위한 인터페이스)
		   : Spring에서 Pagination을 지원하는 Pageable 인터페이스 제공
		   - getPageNumber() : 현재 페이지 번호를 반환(0부터 시작)
		   - getPageSize() : 한 페이지당 항목 수를 반환
		   - getOffset() : 현재 페이지의 시작위치를 반환
		   - getSort() : 정렬한 정보를 반환
		   - next() : 다음 페이지의 정보를 반환
		   - previous() : 이전 페이지의 정보를 반환
		   
		 * PageRequest 클래스
		   : Spring Data JPA에서 제공하는 Pageable 구현체 중 하나로 페이지 정보를 생성하는 클래스
		   - page : 조회할 페이지 번호(0부터 시작)
		   - size : 한 페이지당 항목 수
		   - sort : 정렬 정보
		   - direction : 정렬 방향(ASC, DESC)
		   - properties : 정렬 대상 속성명
		   
		   > 생성자
		   PageRequest(int page, int size)
		   PageRequest(int page, int size, Sort sort)
		   PageRequest(int page, int size, Sort.Direction direction, String... properties)
		 */
		
		Sort sort = Sort.by(Sort.Order.desc("name"));
		
		/* 체이닝 방법
		Pageable pr = PageRequest.ofSize(10)
								 .withPage(page-1)
								 .withSort(sort);
		
		Pageable pageable = PageRequest.of(page-1, 10, Sort.by("name").ascending());	//오름차순
		Pageable pageable = PageRequest.of(page-1, 10, Sort.by("name").descending());	//내림차순
		*/
		
		Pageable pagealbe = PageRequest.of(page-1, 10, sort);
		
		Page<Member> result = memberService.selectByNameLike(search, pagealbe);
		
		
		List<Member> content = result.getContent();	// .getContent() : 실제 객체가 담긴 List<Member>가 반환
		long totalElements = result.getTotalElements(); //.getTotalElements() : 총 레코드 수 반환(리턴타입 Long)
		int totalPages = result.getTotalPages(); //.getTotalPages() : 총 페이지 수 반환(리턴타입 int)
		int size = result.getSize(); //.getSize() : 한 페이지 당 항목 수 반환(리턴타입 int)
		int nowPage = result.getNumber(); //.getNumber() : 현재 페이지 반환(리턴타입 int / 0부터 시작)
		int NumberOfElements = result.getNumberOfElements(); //.getNumberOfElements() : 현재 페이지의 레코드(항목) 수 반환(리턴타입 int)
		
		model.addAttribute("members", content);
		model.addAttribute("totalElements", totalElements);
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("size", size);
		model.addAttribute("nowPage", nowPage);
		model.addAttribute("NumberOfElements", NumberOfElements);
		
		return "selectList";
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
}