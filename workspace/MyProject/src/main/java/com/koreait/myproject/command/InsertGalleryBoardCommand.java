package com.koreait.myproject.command;

import java.io.File;
import java.net.URLEncoder;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.koreait.myproject.dao.HomeDAO;

public class InsertGalleryBoardCommand implements HomeCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		
		Map<String, Object> map = model.asMap();
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest)map.get("multipartRequest");
		
		String id = multipartRequest.getParameter("id");
		String title = multipartRequest.getParameter("title");
		String content = multipartRequest.getParameter("content");
		String ip = multipartRequest.getRemoteAddr();
		
		MultipartFile file = multipartRequest.getFile("filename");
	
		HomeDAO homeDAO = sqlSession.getMapper(HomeDAO.class);
	
			if (file != null && !file.isEmpty()) {
								
				// 올릴 때 파일명
				String originalFilename = file.getOriginalFilename();
				
				// 서버에 저장할 파일명 (파일명_올린시간.확장자)
				String extension = originalFilename.substring( originalFilename.lastIndexOf(".") + 1 );	
										
				String filename = originalFilename.substring( 0, originalFilename.lastIndexOf(".") );	
																
				String uploadFilename = filename + "_" + System.currentTimeMillis() + "." + extension;
				
				// 첨부파일을 저장할 서버 위치 (=> resources에 보관)
				String realPath = multipartRequest.getServletContext().getRealPath("resources/archive");			 												
				
				// archive 디렉터리 생성
				File archive = new File(realPath);
				if ( !archive.exists() ) {
					archive.mkdirs();
				}
				
				// 서버에 첨부파일 저장
				File attach = new File(archive, uploadFilename);		
				try {
					file.transferTo(attach); 					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				// DB에 넣는 파일명을 인코딩 처리
				try {
					uploadFilename = URLEncoder.encode(uploadFilename, "utf-8");
				} catch (Exception e) { }
				
				// DB에 데이터 저장 
				homeDAO.insertGalleryBoard(id, title, content, ip, uploadFilename);
				
			} else {	
				
				// DB에 데이터 저장
				homeDAO.insertGalleryBoard(id, title, content, ip, ""); 	// 첨부가 없을 때
				
			}
			
		}	


}
