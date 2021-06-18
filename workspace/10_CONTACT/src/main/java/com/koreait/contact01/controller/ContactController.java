package com.koreait.contact01.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.koreait.contact01.command.ContactListCommand;
import com.koreait.contact01.command.ContactViewCommand;
import com.koreait.contact01.command.DeleteContactCommand;
import com.koreait.contact01.command.InsertContactCommand;
import com.koreait.contact01.command.UpdateContactCommand;
import com.koreait.contact01.dto.Contact;

@Controller
public class ContactController {

	// field
	private static final Logger logger = LoggerFactory.getLogger(ContactController.class);
	
	// root-context.xml에 정의된 bean을 주입
	private ContactListCommand contactListCommand;
	private ContactViewCommand contactViewCommand;
	private InsertContactCommand insertContactCommand;
	private UpdateContactCommand updateContactCommand;
	private DeleteContactCommand deleteContactCommand;
	
	@Autowired
	public void setCommand(ContactListCommand contactListCommand,
						   ContactViewCommand contactViewCommand,
						   InsertContactCommand insertContactCommand,
						   UpdateContactCommand updateContactCommand,
						   DeleteContactCommand deleteContactCommand) {
		this.contactListCommand = contactListCommand;
		this.contactViewCommand = contactViewCommand;
		this.insertContactCommand = insertContactCommand;
		this.updateContactCommand = updateContactCommand;
		this.deleteContactCommand = deleteContactCommand;
	}
	
	// method
	@GetMapping(value="/")
	public String list() {
		logger.info("list() 호출");
		return "contact/list";
	}
	
	@GetMapping(value="selectContactList.do")
	public String selectContactList(Model model) {
		logger.info("selectContactList() 호출");
		contactListCommand.execute(model);
		return "contact/list";
	}
	
	
	
	@GetMapping(value="insertContactPage.do")
	public String insertContactPage() {
		logger.info("insertContactPage() 호출");
		return "contact/insert";
	}
		
	@GetMapping(value="insertContact.do")
	public String insertContact(HttpServletRequest request, 
							    Model model) {
		logger.info("insertContact() 호출");
		model.addAttribute("request", request);
		insertContactCommand.execute(model);
		return "redirect:selectContactList.do";
	}	
	
	@GetMapping(value="selectContactByNo.do")
	public String selectContactByNo(@RequestParam("no") long no,
									Model model) {
		logger.info("selectContactByNo() 호출");
		model.addAttribute("no", no);
		contactViewCommand.execute(model);
		return "contact/view";
	}
	
	@PostMapping(value="updateContact.do")
	public String updateContact(Contact contact, 
							    Model model) {
		logger.info("updateContact() 호출");
		model.addAttribute("contact", contact);
		updateContactCommand.execute(model);
		return "redirect:selectContactByNo.do?no=" + contact.getNo();
	}
	
	@GetMapping(value="deleteContact.do")
	public String deleteContact(@RequestParam("no") long no,
								Model model) {
		logger.info("delteBoard() 호출");
		model.addAttribute("no", no);
		deleteContactCommand.execute(model);
		return "redirect:selectContactList.do";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
