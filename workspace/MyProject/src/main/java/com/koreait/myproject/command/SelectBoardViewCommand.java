package com.koreait.myproject.command;

import java.net.URLDecoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.koreait.myproject.dao.HomeDAO;
import com.koreait.myproject.dto.GalleryBoard;

public class SelectBoardViewCommand implements HomeCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		long no = Long.parseLong(request.getParameter("no"));
		
		HomeDAO homeDAO = sqlSession.getMapper(HomeDAO.class);
		GalleryBoard galleryBoard = homeDAO.selectBoardByNo(no);
		model.addAttribute("galleryBoard", galleryBoard);
		try {
			model.addAttribute("filename", URLDecoder.decode(galleryBoard.getFilename(), "utf-8"));		
		} catch (Exception e) { }
	
		
	}

}
