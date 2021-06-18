package com.koreait.contact01.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.koreait.contact01.dao.ContactDAO;
import com.koreait.contact01.dto.Contact;

public class UpdateContactCommand implements ContactCommand {

	@Override
	public void execute(Model model) {
		
		Map<String, Object> map = model.asMap();
		
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		Contact contact = new Contact();
		contact.setName(request.getParameter("name"));
		contact.setTel(request.getParameter("tel"));
		contact.setAddr(request.getParameter("addr"));
		contact.setEmail(request.getParameter("email"));
		contact.setNote(request.getParameter("note"));
		
		ContactDAO.getInstance().updateContact(contact);

	}

}
