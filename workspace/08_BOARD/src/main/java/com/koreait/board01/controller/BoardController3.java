package com.koreait.board01.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.koreait.board01.command.BoardViewCommand;
import com.koreait.board01.command.DeleteBoardCommand;
import com.koreait.board01.command.BoardCommand;
import com.koreait.board01.command.BoardListCommand;
import com.koreait.board01.command.InsertBoardCommand;
import com.koreait.board01.command.UpdateBoardCommand;
import com.koreait.board01.config.BeanConfiguration;
import com.koreait.board01.dto.Board;

@Controller
public class BoardController3 {

	// field
	private static final Logger logger = LoggerFactory.getLogger(BoardController3.class);
	
	// BeanConfiguration.java 이용한 bean 생성
	private AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(BeanConfiguration.class);
	
	// method
	@GetMapping(value="/")		// @RequestMapping(value="/", method=RequestMethod.GET)
	public String index() {
		logger.info("index() 호출");		// System.out 보다 훨씬 좋다. 
		return "index";
	}
	
	@GetMapping(value="selectBoardList.do")
	public String selectBoardList(Model model) {
		logger.info("selectBoardList() 호출");
		BoardListCommand command = ctx.getBean("boardlistCommand", BoardListCommand.class);
		command.execute(model);
		return "board/list";	// board/list.jsp로 이동 
	}
	
	@GetMapping(value="insertBoardPage.do")
	public String insertBoardPage() {
		logger.info("insertBoardPage() 호출");
		return "board/insert";		// board/insert.jsp로 이동
	}
	
	@GetMapping(value="insertBoard.do")
	public String insertBoard(HttpServletRequest request,	// <form> 태그 요소가 파라미터로 전달된다.
							  Model model) {		
										// insertBoard()로 파라미터가 3개 온다(작성자, 제목, 내용)
										// 파라미터 저장하는 3가지 방법 : request / requestParam / DTO -> 여기서 골라서 쓴다.
		logger.info("insertBoard() 호출");
		model.addAttribute("request", request);
		InsertBoardCommand command = ctx.getBean("insertBoardCommand", InsertBoardCommand.class);
		command.execute(model);	
		// 삽입 후에는 반드시 redirect
		return "redirect:selectBoardList.do";		// 삽입 후 목록 보기로 이동 (redirect:맵핑)
	}	
	
	
	
	@GetMapping(value="selectBoardByNo.do")
	public String selectBoardByNo(@RequestParam("no") long no,
								  Model model) {
		logger.info("selectBoardByNo() 호출");
		model.addAttribute("no", no);
		BoardViewCommand command = ctx.getBean("boardViewCommand", BoardViewCommand.class);
		command.execute(model);
		return "board/view";
	}
	
	
	@PostMapping(value="updateBoardPage.do")
	public String updatePage(@ModelAttribute Board board) {
		logger.info("updateBoardPage() 호출");
		return "board/update";
	}
	
	@PostMapping(value="updateBoard.do")
	public String updateBoard(Board board, Model model) {
		logger.info("updateBoard() 호출");
		model.addAttribute("board", board);
		UpdateBoardCommand command = ctx.getBean("updateBoardCommand", UpdateBoardCommand.class);
		command.execute(model);
		return "redirect:selectBoardByNo.do?no=" + board.getNo();
	}
	
	@GetMapping(value="deleteBoard.do")
	public String deleteBoard(@RequestParam("no") long no,
							  Model model) {
		logger.info("deleteBoard() 호출");
		model.addAttribute("no", no);
		DeleteBoardCommand command = ctx.getBean("deleteBoardCommand", DeleteBoardCommand.class);
		command.execute(model);
		return "redirect:selectBoardList.do";
	}
	
	
	
}

