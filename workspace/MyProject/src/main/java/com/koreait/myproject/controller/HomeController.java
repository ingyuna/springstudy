package com.koreait.myproject.controller;

import java.util.Map;

import javax.print.attribute.standard.JobImpressionsCompleted;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.koreait.myproject.command.EmailAuthCommand;
import com.koreait.myproject.command.JoinCommand;
import com.koreait.myproject.command.LoginCommand;

@Controller
public class HomeController {

	// field
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	private SqlSession sqlSession;
	private EmailAuthCommand emailAuthCommand;
	private JoinCommand joinCommand;
	private LoginCommand loginCommand;
	
	// constructor
	@Autowired
	public HomeController(SqlSession sqlSession,
						  EmailAuthCommand emailAuthCommand,
						  JoinCommand joinCommand,
						  LoginCommand loginCommand) {
		super();
		this.sqlSession = sqlSession;
		this.emailAuthCommand = emailAuthCommand;
		this.joinCommand = joinCommand;
		this.loginCommand = loginCommand;
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
	
	@GetMapping(value="verifyNum.do",
			   	produces="application/json; charset=utf-8")
	@ResponseBody
	public Map<String, String> verifyNum(HttpServletRequest request,
			                       		 Model model) {
		model.addAttribute("request", request);
		return emailAuthCommand.execute(sqlSession, model);
	}
	
	@PostMapping(value="join.do")
	public String join(HttpServletRequest request,
			           Model model) {
		model.addAttribute("request", request);
		joinCommand.execute(sqlSession, model);
		return "redirect:/";
	}
	
	@PostMapping(value="login.do")
	public String login(HttpServletRequest request,
			 			Model model) {
		model.addAttribute("request", request);
		loginCommand.execute(sqlSession, model);
		return "redirect:/";
	}
	
	
	
	
}
