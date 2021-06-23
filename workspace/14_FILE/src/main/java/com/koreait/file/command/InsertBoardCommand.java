package com.koreait.file.command;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.koreait.file.dao.BoardDAO;

public class InsertBoardCommand implements BoardCommand {

	@Override
	public void exectue(SqlSession sqlSession, Model model) {
		
		// 파일첨부하는 request는 HttpservletRequest로 못받는다. 그래서 MultipartHttpServletRequest로 쓴다.
		
		Map<String, Object> map = model.asMap();
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest)map.get("multipartRequest");
																				// 맵에 저장 = map.get 
																				// = get("담아주는 이름")
		
		String writer = multipartRequest.getParameter("writer");
		String title = multipartRequest.getParameter("title");
		String content = multipartRequest.getParameter("content");
		
		/*
			<input type="file" name="filename"> : 단일 파일 첨부일 때
			MultipartFile file = multipartRequest.getFile("filename");
		*/
		
		/* 
			<input type="file" name="files" multiple> : 다중 파일 첨부일 때.
			List<MultipartFile> files = multipartRequest.getFiles("files");	   // 파일 하나당, MultipartFile을 하나 쓰는거.
		*/
		
		List<MultipartFile> files = multipartRequest.getFiles("files");
		
		BoardDAO boardDAO = sqlSession.getMapper(BoardDAO.class);
		
		for (MultipartFile file : files) {
			
			
			if (file != null && !file.isEmpty()) {
								
				// 올릴 때 파일명
				String originalFilename = file.getOriginalFilename();
				System.out.println("첨부파일명: " + file.getOriginalFilename());
				
				// 서버에 저장할 파일명
				// 파일명의 중복 방지 대책이 필요
				// 파일명_올린시간.확장자
				String extension = originalFilename.substring( originalFilename.lastIndexOf(".") + 1 );	
											// 파일 이름에 마침표(.)가 있을 수 있기 때문에 마지막 마침표를 찾는다.
											// +1은 선택인데 +1을 안하면 extension에 저장을 .txt 이런식으로 점(.)을 포함해서 저장
				String filename = originalFilename.substring( 0, originalFilename.lastIndexOf(".") );	
																// = 0부터(처음부터) 마지막 마침표 이전까지.
				String uploadFilename = filename + "_" + System.currentTimeMillis() + "." + extension;
				
				// 첨부파일을 저장할 서버 위치 (=> resources에 보관)
				String realPath = multipartRequest.getServletContext().getRealPath("resources/archive");
				 															// archive 디렉터리는 없으므로 생성이 필요
																// 미리 만들어놔도 되는데 오류가 나는 경우도 많기 때문에,
				                                                // 없으면 만들라는 자바 코드를 작성해 주는게 더 좋다.
				
				// archive 디렉터리 생성
				File archive = new File(realPath);
				if ( !archive.exists() ) {
					archive.mkdirs();
				}
				
				// 서버에 첨부파일 저장
				File attach = new File(archive, uploadFilename);		// new File(저장할 경로, 저장할 파일 이름)
				try {
					file.transferTo(attach); 	// = 저장될 파일을 attach에 보내겠다					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				// DB에 데이터 저장 
				boardDAO.insertBoard(writer, title, content, uploadFilename);
				
			} else {	
				
				// DB에 데이터 저장
				boardDAO.insertBoard(writer, title, content, "");	// 첨부가 없는 경우
				
			}
			
		}	// for

	}

}
