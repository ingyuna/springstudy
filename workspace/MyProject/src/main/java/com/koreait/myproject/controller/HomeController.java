package com.koreait.myproject.controller;

import java.util.Map;

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
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.koreait.myproject.command.EmailAuthCommand;
import com.koreait.myproject.command.FindIdCommand;
import com.koreait.myproject.command.FindPwCommand;
import com.koreait.myproject.command.InsertGalleryBoardCommand;
import com.koreait.myproject.command.JoinCommand;
import com.koreait.myproject.command.LeaveCommand;
import com.koreait.myproject.command.LoginCommand;
import com.koreait.myproject.command.LogoutCommand;
import com.koreait.myproject.command.SelectBoardViewCommand;
import com.koreait.myproject.command.SelectGalleryBoardListCommand;
import com.koreait.myproject.command.UpdateGalleryBoardCommand;

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
	private InsertGalleryBoardCommand insertGalleryBoardCommand;
	private SelectGalleryBoardListCommand selectGalleryBoardListCommand;
	private SelectBoardViewCommand selectBoardViewCommand;
	private UpdateGalleryBoardCommand updateGalleryBoardCommand;
	
	// constructor
	@Autowired
	public HomeController(SqlSession sqlSession,
						  EmailAuthCommand emailAuthCommand,
						  JoinCommand joinCommand,
						  LoginCommand loginCommand,
						  LogoutCommand logoutCommand,
						  FindIdCommand findIdCommand,
						  FindPwCommand findPwCommand,
						  LeaveCommand leaveCommand,
						  InsertGalleryBoardCommand insertGalleryBoardCommand,
						  SelectGalleryBoardListCommand selectGalleryBoardListCommand,
						  SelectBoardViewCommand selectBoardViewCommand,
						  UpdateGalleryBoardCommand updateGalleryBoardCommand) {
		super();
		this.sqlSession = sqlSession;
		this.emailAuthCommand = emailAuthCommand;
		this.joinCommand = joinCommand;
		this.loginCommand = loginCommand;
		this.logoutCommand = logoutCommand;
		this.findIdCommand = findIdCommand;
		this.findPwCommand = findPwCommand;
		this.leaveCommand = leaveCommand;
		this.insertGalleryBoardCommand = insertGalleryBoardCommand;
		this.selectGalleryBoardListCommand = selectGalleryBoardListCommand;
		this.selectBoardViewCommand = selectBoardViewCommand;
		this.updateGalleryBoardCommand = updateGalleryBoardCommand;
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
	
	@GetMapping(value="galleryBoardPage.do")
	public String galleryBoardPage() {
		return "home/galleryBoard";
	}
	
	@GetMapping(value="insertGalleryBoardPage.do")
	public String insertGalleryBoardPage() {
		return "home/insertGalleryBoard";
	}
	
	@PostMapping(value="insertGalleryBoard.do")
	public String insertGalleryBoard(MultipartHttpServletRequest multipartRequest,
									 Model model) {
		model.addAttribute("multipartRequest", multipartRequest);
		insertGalleryBoardCommand.execute(sqlSession, model);
		return "redirect:galleryBoardPage.do";
		
	}
	
	
	
	@GetMapping(value="selectGalleryBoardList.do")
	public String selectGalleryBoardList(Model model) {
		selectGalleryBoardListCommand.execute(sqlSession, model);
		return "home/galleryBoard";
	}
	
	
	
	
		
	@GetMapping(value="selectBoardByNo.do")
	public String selectBoardByNo(HttpServletRequest request,
								  Model model) {
		model.addAttribute("request", request);
		selectBoardViewCommand.execute(sqlSession, model);
		return "home/viewBoard";
	}
	
	@PostMapping(value="updateBoard.do")
	public String updateBoard(MultipartHttpServletRequest multipartRequest,
							  Model model) {
		model.addAttribute("multipartRequest", multipartRequest);
		updateGalleryBoardCommand.execute(sqlSession, model);
		return "redirect:selectBoardByNo.do?no=" + multipartRequest.getParameter("no");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
