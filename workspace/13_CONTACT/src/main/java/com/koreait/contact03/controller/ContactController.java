package com.koreait.contact03.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.koreait.contact03.command.SelectContactListCommand;
import com.koreait.contact03.command.SelectContactViewCommand;

@Controller
public class ContactController {

	// field
	private SqlSession sqlSession;
	private SelectContactListCommand selectContactListCommand;
	private SelectContactViewCommand selectContactViewCommand;

	// constructor
	public ContactController(SqlSession sqlSession, 
			                 SelectContactListCommand selectContactListCommand,
			                 SelectContactViewCommand selectContactViewCommand) {
		super();
		this.sqlSession = sqlSession;
		this.selectContactListCommand = selectContactListCommand;
		this.selectContactViewCommand = selectContactViewCommand;
	}
	
	@GetMapping(value= {"/", "selectContactList.do"})
	public String selectContactList(Model model) {
		selectContactListCommand.execute(sqlSession, model);
		return "contact/list";
	}
	
	@GetMapping(value="selectContactView.do")
	public String selectContactView(HttpServletRequest request,
			                        Model model) {
		model.addAttribute("request", request);
		selectContactViewCommand.execute(sqlSession, model);
		return "contact/view";
		
	}
	
	
}
