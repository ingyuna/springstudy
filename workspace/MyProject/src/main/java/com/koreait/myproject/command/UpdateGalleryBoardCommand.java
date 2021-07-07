package com.koreait.myproject.command;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.koreait.myproject.dao.HomeDAO;

public class UpdateGalleryBoardCommand implements HomeCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		
		Map<String, Object> map = model.asMap();
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest)map.get("multipartRequest");
		
		long no = Long.parseLong(multipartRequest.getParameter("no"));
		String title = multipartRequest.getParameter("title");
		String content = multipartRequest.getParameter("content");
		
		// 서버에 저장된 첨부파일명
		String filename1 = multipartRequest.getParameter("filename1");	
		// 새로운 첨부파일
		MultipartFile filename2 = multipartRequest.getFile("filename2");	
		
		String realPath = multipartRequest.getServletContext().getRealPath("resources/archive");
			
		// 서버에 저장된 파일(기존의 첨부)
		File file = new File(realPath, filename1);	
		                                       
		HomeDAO homeDAO = sqlSession.getMapper(HomeDAO.class);

		
		// 새로운 첨부가 있을 때
		if (filename2 != null && !filename2.isEmpty()) {	
			 
			if (file != null) {
				// 기존 첨부 지우기
				if (file.exists()) {	
						file.delete();			
				}	
			}	
			
			// 새 첨부 넣기
			String originalFilename = filename2.getOriginalFilename();
			String extension = originalFilename.substring( originalFilename.lastIndexOf(".") + 1 );
			String filename = originalFilename.substring( 0, originalFilename.lastIndexOf(".") );
			String uploadFilename = filename + "_" + System.currentTimeMillis() + "." + extension;
			File uploadFile = new File(realPath, uploadFilename);
			try {
				filename2.transferTo(uploadFile);				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			// DB에 넣는 파일명 인코딩 처리
			try {
				uploadFilename = URLEncoder.encode(uploadFilename, "utf-8"); 
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			
			homeDAO.updateGalleryBoard(title, content, uploadFilename, no);
			
		} else { 
			
			// 새로운 첨부가 없을 때
			
			homeDAO.updateGalleryBoard(title, content, filename1, no);
		}			
	}	

}
