package com.koreait.myproject.command;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.koreait.myproject.dao.HomeDAO;

public class SelectGalleryBoardListCommand implements HomeCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		

		HomeDAO homeDAO = sqlSession.getMapper(HomeDAO.class);
		model.addAttribute("list", homeDAO.selectGalleryBoardList());
		
		

	}

}
