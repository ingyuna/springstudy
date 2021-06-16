package com.koreait.board01.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.koreait.board01.dao.BoardDAO;
import com.koreait.board01.dto.Board;

public class UpdateBoardCommand implements BoardCommand {

	@Override
	public void execute(Model model) {
		
		Map<String, Object> map = model.asMap();
		
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		Board board = new Board();
		board.setTitle(request.getParameter("title"));
		board.setContent(request.getParameter("content"));;
		
		BoardDAO.getInstance().updateBoard(board);
		
		
		

	}

}
