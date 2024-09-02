package com.study.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.springboot.domain.Cart;
import com.study.springboot.service.CartService;

@RestController
@RequestMapping("/react")//리액트 메인페이지 루트
public class CartController {
	
	@Autowired
	CartService cartService;
	
	@PostMapping("/addCart")//장바구니에 추가하기
	public String addcart(@RequestBody Cart cart) {
		cart.setMemId("user01");
		Cart result = cartService.addcart(cart);
		return "ok";
	}
	
	@GetMapping("/getCart")//장바구니 DB 불러오기
	public List<Cart> getCart() {
		return cartService.getCart("user01");
	}
	
	
}
