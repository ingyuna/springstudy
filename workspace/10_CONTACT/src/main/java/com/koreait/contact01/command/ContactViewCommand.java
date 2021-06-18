package com.koreait.contact01.command;

import java.util.Map;

import org.springframework.ui.Model;

import com.koreait.contact01.dao.ContactDAO;

public class ContactViewCommand implements ContactCommand {

	@Override
	public void execute(Model model) {
		
		Map<String, Object> map = model.asMap();
		long no = (Long)map.get("no");
		model.addAttribute("contact", ContactDAO.getInstance().selectBoardByNo(no));

	}

}
