package com.koreait.myproject.controller;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	// field
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	private SqlSession sqlSession;
	
	// constructor
	@Autowired
	public HomeController(SqlSession sqlSession) {
		super();
		this.sqlSession = sqlSession;
	}
	
	@GetMapping(value="/")
	public String index() {
		return "index";
	}
	
	@GetMapping(value="loginPage.do")
	public String loginPage() {
		return "home/login";
	}
	
	@GetMapping(value="joinPage.do")
	public String joinPage() {
		return "home/join";
	}
	
	
	
	
	
}
