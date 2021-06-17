package com.koreait.board02.command;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.koreait.board02.dao.BoardDAO;

public class SelectBoardViewCommand implements BoardCommand {

	@Autowired
	private BoardDAO boardDAO;
	
	@Override
	public void execute(Model model) {
		
		Map<String, Object> map = model.asMap(); 		// -> 모델을 맵으로 바꿔줘.
		long no = (Long)map.get("no");					// Object이기 때문에 클래스 타입으로 변환하기 위해서 (Long)을 붙여준다.
		model.addAttribute("board", boardDAO.selectBoardByNo(no));			
						// -> 리턴 결과는 board 하나. 얘를 model에 다시 담자 -> 앞에 model.addAttribute를 붙여줌.
		
		
	}

}
