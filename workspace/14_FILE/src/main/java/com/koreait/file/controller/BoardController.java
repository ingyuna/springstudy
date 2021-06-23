package com.koreait.file.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.koreait.file.command.DownloadCommand;
import com.koreait.file.command.InsertBoardCommand;
import com.koreait.file.command.SelectBoardListCommand;
import com.koreait.file.command.SelectBoardViewCommand;

@Controller
public class BoardController {
	
	private SqlSession sqlSession; 		// 모든 커멘드가 SqlSession을 필요로하므로, 여기에 만들어놓고 사용하는것.
	private SelectBoardListCommand selectBoardListCommand;
	private InsertBoardCommand insertBoardCommand;
	private DownloadCommand downloadCommand;
	private SelectBoardViewCommand selectBoardViewCommand;
	
	@Autowired
	public BoardController(SqlSession sqlSession,
						   SelectBoardListCommand selectBoardListCommand,
						   InsertBoardCommand insertBoardCommand,
						   DownloadCommand downloadCommand,
						   SelectBoardViewCommand selectBoardViewCommand) {
		super();
		this.sqlSession = sqlSession;
		this.selectBoardListCommand = selectBoardListCommand;
		this.insertBoardCommand = insertBoardCommand;
		this.downloadCommand = downloadCommand;
		this.selectBoardListCommand = selectBoardListCommand;
	}

	@GetMapping(value="/")		// contetxPath 슬래시(/)로 넘어오면,
	public String index() {		
		return "index";				// -> index로 넘겨주자.
	}
	
	@GetMapping(value="selectBoardList.do")
	public String selectBoardList(Model model) {
		selectBoardListCommand.exectue(sqlSession, model);
		return "board/listBoard";
	}
	
	@GetMapping(value="insertBoardPage.do")
	public String insertBoardPage() {
		return "board/insertBoard";
	}
	
	@PostMapping(value="insertBoard.do")
	public String insertBoard(MultipartHttpServletRequest multipartRequest,
							  Model model) {
		model.addAttribute("multipartRequest", multipartRequest);	// 여기에 담는 이유는 insertBoardCommand에 전달하기 위해서.
																	// 그래서 커멘드는 전달 받자마자 바로 뺀다.
		insertBoardCommand.exectue(sqlSession, model);	
		return "redirect:selectBoardList.do";
	}
	
	@GetMapping(value="download.do")
	public void download(HttpServletRequest request,	// 다운로드 눌렀다고 어디로 가지 않기 때문에 void 처리 (-> DB로 가지 않는다)
	                     HttpServletResponse response,		// response가 없으면 다운받은 경로를 알지 못한다.
	                     Model model) {
		model.addAttribute("request", request);
		model.addAttribute("response", response);
		downloadCommand.execute(model);
		
	}
	
	@GetMapping(value="selectBoardByNo.do")
	public String selectBoardByNo(HttpServletRequest request,
								  Model model) {
		model.addAttribute("request", request);
		selectBoardListCommand.exectue(sqlSession, model);
		return "board/viewBoard";
	}
	
	
	
	
	
	
	
	
	
	
	
}
