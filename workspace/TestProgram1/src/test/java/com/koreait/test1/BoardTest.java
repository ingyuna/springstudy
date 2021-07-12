package com.koreait.test1;

import static org.junit.Assert.assertEquals;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.koreait.test1.config.BeanConfiguration;
import com.koreait.test1.dao.BoardDAO;
import com.koreait.test1.dto.BoardDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {BeanConfiguration.class})

public class BoardTest {

	@Autowired
	private SqlSession SqlSession;
	
	@Test
	public void insertTest() {
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setBWriter("작성자");
		boardDTO.setBTitle("테스트제목");
		boardDTO.setBContent("테스트내용");
		

		BoardDAO boardDAO = SqlSession.getMapper(BoardDAO.class);
		int count = boardDAO.insertBoard(bWriter, bTitle, bContent);
		
		assertEquals("작성실패", 1, count);
		
	}
	
	@Test
	public void selectTest() {
		
		BoardDAO boardDAO = SqlSession.getMapper(BoardDAO.class);
		assertNotNull(BoardDAO.selectByIdx("654321"), "9999 글 번호는 없습니다.");
	}
	
	
	@Test
	public void updateTest() {
		
	}
	
	@Test
	public void deleteTest() {
		
	}
	

}
