package com.koreait.file.command;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;

public class DownloadCommand {

	// DB 접근이 없는 Command이기 때문에 SqlSession을 사용하지 않는다. 
	// 따라서, BoardCommand를 구현하지 않아도 상관 없다. (구현해도 상관 없다.)
	
	public void execute(Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		HttpServletResponse response = (HttpServletResponse)map.get("response");
		
		String realPath = request.getServletContext().getRealPath("resources/archive");

		// DB와 서버에 저장된 파일명 (밑줄과 시간이 포함된)
		String filename = request.getParameter("filename");
		
		// 파일명 원상 복구 (선택)
		String extension = filename.substring( filename.lastIndexOf(".") + 1 );
		String originalFilename = filename.substring( 0, filename.lastIndexOf("_") );
		String downloadFilename = originalFilename + "." + extension;
				
		// 다운로드 할 File 생성
		File download = new File(realPath, filename);	// 서버에서 찾아야 하는 파일명을 작성
		
		// 스트림 준비
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		try {
			
			// response 다운로드 처리
			response.setHeader("Content-Type", "application/x-msdownload");
			response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(downloadFilename, "utf-8"));
			response.setHeader("Content-Length", download.length() + "");	// header 셋팅할 때는 문자열로만 하게 되어있다. 
																			// length는 int니까 뒤에 "" 문자열만 추가.
			
			// 서버에 저장된 download할 파일을 읽는 스트림
			bis = new BufferedInputStream(new FileInputStream(download));	// 보조 스트림이기 때문에 메인 스트림이 반드시 필요함.
			
			// 사용자에게 파일을 생성하는 출력 스트림
			bos = new BufferedOutputStream(response.getOutputStream());
			
			// bis로 읽은 내용을 bos로 전송(파일 복사 진행)
			FileCopyUtils.copy(bis, bos);
			
			// 혹시 남은게 있다면
			bos.flush();		// -> '혹시'이기 때문에 없어도 동작한다.
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bos != null) bos.close();
				if (bis != null) bis.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
}
