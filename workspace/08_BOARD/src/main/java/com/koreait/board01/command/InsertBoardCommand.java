package com.koreait.board01.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.koreait.board01.dao.BoardDAO;
import com.koreait.board01.dto.Board;

public class InsertBoardCommand implements BoardCommand {

	@Override
	public void execute(Model model) {		// 지금 여기 model에는 request가 들어있다.
				
		// model을 Map으로 변경하기 (-> model과 Map의 형태는 같다)
		Map<String, Object> map = model.asMap(); 	// 여러가지 데이터가 들어갈 수 있으니까 value는 Object로 해준다.
		
		// model에서 request 빼기
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		Board board = new Board();
		board.setWriter(request.getParameter("writer"));
		board.setTitle(request.getParameter("title"));
		board.setContent(request.getParameter("content"));
		
		BoardDAO.getInstance().insertBoard(board);
		
		
		
		
	}

}
