package com.koreait.myproject.controller;

import java.util.Map;

import javax.print.attribute.standard.JobImpressionsCompleted;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.koreait.myproject.command.EmailAuthCommand;
import com.koreait.myproject.command.FindIdCommand;
import com.koreait.myproject.command.FindPwCommand;
import com.koreait.myproject.command.JoinCommand;
import com.koreait.myproject.command.LeaveCommand;
import com.koreait.myproject.command.LoginCommand;
import com.koreait.myproject.command.LogoutCommand;

@Controller
public class HomeController {

	// field
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	private SqlSession sqlSession;
	private EmailAuthCommand emailAuthCommand;
	private JoinCommand joinCommand;
	private LoginCommand loginCommand;
	private LogoutCommand logoutCommand;
	private FindIdCommand findIdCommand;
	private FindPwCommand findPwCommand;
	private LeaveCommand leaveCommand;
	
	// constructor
	@Autowired
	public HomeController(SqlSession sqlSession,
						  EmailAuthCommand emailAuthCommand,
						  JoinCommand joinCommand,
						  LoginCommand loginCommand,
						  LogoutCommand logoutCommand,
						  FindIdCommand findIdCommand,
						  FindPwCommand findPwCommand,
						  LeaveCommand leaveCommand) {
		super();
		this.sqlSession = sqlSession;
		this.emailAuthCommand = emailAuthCommand;
		this.joinCommand = joinCommand;
		this.loginCommand = loginCommand;
		this.logoutCommand = logoutCommand;
		this.findIdCommand = findIdCommand;
		this.findPwCommand = findPwCommand;
		this.leaveCommand = leaveCommand;
	}
	
	@GetMapping(value= {"/", "index.do"})
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
	
	@GetMapping(value="logout.do")
	public String logout(HttpSession session,
						 Model model) {
		model.addAttribute("session", session);
		logoutCommand.execute(sqlSession, model);
		return "redirect:/";		
	}
	
	@GetMapping(value="findIdPage.do")
	public String findIdPage() {
		return "home/findId";
	}
	
	@PostMapping(value="findId.do")
	public String findId(HttpServletRequest request,
			 			 Model model) {
		model.addAttribute("request", request);
		findIdCommand.execute(sqlSession, model);
		return "home/findIdResult";
	}
	
	@GetMapping(value="findPwPage.do")
	public String findPwPage() {
		return "home/findPw";
	}
	
	@GetMapping(value="changePwPage.do")
	public String changePwPage(@ModelAttribute("id") String id,
								@ModelAttribute("email") String email) {
		return "home/changePw";
	}
	
	@PostMapping(value="changePw.do")
	public String changePw(HttpServletRequest request,
						 Model model) {
		model.addAttribute("request", request);
		findPwCommand.execute(sqlSession, model);
		return index();
	}
	
	@GetMapping(value="leave.do")
	public String leave(HttpSession session,
						Model model) {
		model.addAttribute("session", session);
		leaveCommand.execute(sqlSession, model);
		return "redirect:/";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
