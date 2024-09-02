package com.study.springboot.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.study.springboot.domain.Member;
import com.study.springboot.service.MemberService;

@Controller
public class MemberController {

	@Autowired	// 자동 Bean생성 어노테이션(자동객체생성)
	MemberService memberService;
	
	@RequestMapping("/")
	public String root() {
		return "menu";
	}
	
	@RequestMapping("/insert")
	public String insert(@RequestParam("name") String name, Model model) {
		Member member = Member.builder()
							  .name(name)
							  .createDate(LocalDate.now())
							  .build();
		Member result = memberService.insert(member);
		model.addAttribute("member", result); // <- db에 넣을 값 result에 담고 가져가기 위해 Model에 담아서 가져옴
		return "insert";
	}
	
	@RequestMapping("/select")
	public String selectOne(@RequestParam("id") Long id, Model model) {
		Optional<Member> member = memberService.selectOne(id);
		if(member.isPresent()) { //.isPresent() : 데이터가 있는지 체크(있으면 true 반환)
			model.addAttribute("member", member.get() ); // member.get() : Optional의 wrapping을 풀어서 Member만 가져오기
		} else {
			model.addAttribute("member", null);
		}
		return "select";
	}
	
	@RequestMapping("/selectAll")
	public String selectAll(Model model) {
		List<Member> alist = memberService.selectAll();
		model.addAttribute("mList", alist);
		return "selectAll";
	}
	
	@RequestMapping("/update")
	public String update(Member m, Model model) {
		Member member = memberService.update(m);
		m.setCreateDate(LocalDate.now());
		model.addAttribute("m", member); 
		return "update";
	}
	
	@RequestMapping("/delete")
	public void delete(@RequestParam("id") Long id, Model model) {
		memberService.delete(id);
		
		
	}
	
	
}
