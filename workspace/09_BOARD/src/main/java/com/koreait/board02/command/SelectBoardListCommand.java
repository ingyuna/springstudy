package com.koreait.board02.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.koreait.board02.dao.BoardDAO;

public class SelectBoardListCommand implements BoardCommand {

	@Autowired
	private BoardDAO BoardDAO;
	
	@Override
	public void execute(Model model) {
		
		model.addAttribute("list", BoardDAO.selectBoardList());
		

	}

}
