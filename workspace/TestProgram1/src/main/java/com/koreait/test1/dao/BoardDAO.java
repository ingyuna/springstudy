package com.koreait.test1.dao;

import java.util.List;

import com.koreait.test1.dto.BoardDTO;

public interface BoardDAO {

	public List<BoardDTO> selectBoardList(); 
	public int selectBoardCount();
	public int insertBoard(String bWriter, String bTitle, String bContent);
	public BoardDTO selectByIdx(int bIdx);
	public int updateBoard(String bTitle, String bContent, int bIdx);
	public int deleteBoard(int bIdx);
	
}
