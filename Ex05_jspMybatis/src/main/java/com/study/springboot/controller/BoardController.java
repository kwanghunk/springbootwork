package com.study.springboot.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.springboot.dto.Board;
import com.study.springboot.service.BoardService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class BoardController {
	
	@Autowired // new OOOO(); 대신 @Autowired로 객체 생성
	BoardService boardService;
	
	@RequestMapping("/")
	public String root() throws Exception{
		return "redirect:list";
	}
	
	/*
	 * 요청 처리 후 응답페이지로 포워딩 또는 url 재요청시 응답 데이터를 담는 방법
	    1. Model 객체
			- 포워딩할 뷰로 전달하고자 하는 데이터를 맵 형식<key-value>로 담을 수 있는 영역
			- requestScope임. 
			- 단, setAttribute가 아닌 addAttribute(String key, Object value)메소드 이용
				ex)  model.addAttribute(~~~)
	    2. ModelAndView
			- Model은 데이터를 맵 형식<key-value>로 담을 수 있는 영역
			- View는 응답뷰에 대한 정보를 담을 수 있는 공간
	 */
	@RequestMapping("/list")
	public String userListPage(Model model){
		model.addAttribute("totalRecord", boardService.totalRecord());
		model.addAttribute("list", boardService.list());
		return "list"; //"OOO"에서 OOO은 url임
	}
	
	/* 
	 * 요청시 전달한 값(파라미터)를 받는 방법	(detail로 넘어가면서 들어온 boardno 받는 법)
		1. HttpServletRequest를 이용하여 전달받는 방법
			메서드의 매개변수에 넣는 방법
			ex) 
				@RequestMapping("/detail")
					public String detailView(HttpServletRequest r) {
						String bno = r.getParameter("boardno");
						return "detail";
				}
				
		2. 어노테이션을 사용하는 방법 : @RequestParam : HTTP 요청 파라미터를 메서드의 매개변수에 매핑할 때 사용
												, 쿼리 스트링이나 폼 데이터의 값을 가져올 때 
			- 변수에 저장할 때 : request.getParameter("키")
			ex)
				@RequestMapping("/detail")
				public String detailView(@RequestParam("boardno") String bno,
									     @RequestParam(value="writer", defaultBalue="홍길동") {
					return "detail";
				}
	 */
	
	@RequestMapping("/detail")
	public String detailView(HttpServletRequest request, Model model) {
		String bno = request.getParameter("boardno");
		model.addAttribute("detailBoard", boardService.detailBoard(bno));
		return "detail";
	}
	
	@RequestMapping("/delete")
	public String deleteContent(HttpServletRequest request, Model model) {
		int bno = Integer.parseInt(request.getParameter("boardno"));
		model.addAttribute("deleteBoard", boardService.deleteBoard(bno));
		return "redirect:list";
	}
	
	@RequestMapping("/writerForm")
	public String writerForm() {
		return "writerForm";
	}
	/*
	 * 커맨드 객체 방식
		: 들어오는 값이 많아 객체로 받을 때 주로 사용
			- 요청시 전달값의 키(name속성의 값)를 객체에 담고자하는 필드명으로 작성
				-> 필드명 private String write;이고 name="write"이면 스프링컨테이너가 해당 객체를 
				   기본생성자로 생성 후 자동으로 setter메소드를 호출해서 넣어줌
			ex) 
			@RequestMapping("/write")
			public String write(Board b) { <- Board b에는 title, writer, content가 자동으로 들어와 있는 상태임
				String title = b.getTitle();
			}
	 
	 * @ModelAttribute 어노테이션을 이용하는 방법
		: 객체로 받을 때 사용
			- 요청시 전달값의 키(name속성의 값)를 객체에 담고자하는 필드명으로 작성
				-> 필드명 private String write;이고 name="write"이면 스프링컨테이너가 해당 객체를 
				   기본생성자로 생성 후 자동으로 setter메소드를 호출해서 넣어줌
			ex)
			@RequestMapping("/write")
			public String write(@ModelAttribute("form") Board b) {
				String title = b.getTitle();
			}
	 */
	/*
	@RequestMapping("/write")
	public String write(HttpServletRequest request) {
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("title", title);
		map.put("writer", writer);
		map.put("content", content);
		
		boardService.insertBoard(map);
		return "redirect:list";
	}
	*/
	
	@RequestMapping("/write")
	public String write(Board b) {
		String title = b.getTitle();
		String writer = b.getWriter();
		String content = b.getContent();
		
		boardService.insertBoard(b);
		return "redirect:list";
	}
	
}
	
	
	
	
	
	
