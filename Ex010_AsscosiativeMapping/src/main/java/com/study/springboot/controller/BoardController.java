package com.study.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.springboot.domain.Board;
import com.study.springboot.domain.Member;
import com.study.springboot.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@RequestMapping("/binsert")
	public String binsert(Board board, Model model) {
		Member m = new Member(); // Board.java에서 외래키로 묶여있으므로 member 객체를 생성하여 아래처럼 보내줌
		m.setId("user01");
		
		board.setMember(m);
		Board b = boardService.binsert(board);
		model.addAttribute("board", b);
		return "binsert";
	}
}
