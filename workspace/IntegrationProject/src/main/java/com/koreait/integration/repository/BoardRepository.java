package com.koreait.integration.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.koreait.integration.domain.Board;

@Repository		// => 저장소에 왔다갔다하는애 (안해도 됨)
public class BoardRepository {

	@Autowired
	private SqlSession sqlSession;
	
	public List<Board> selectAll() {
		return sqlSession.selectList("com.koreait.integration.repository.board.selectAll");		// ("") 괄호 안에는 내가 실행해야할 sql문의 id가 들어가야한다.
	}
	
	public List<Board> selectQuery(Map<String, String> map) {
		return sqlSession.selectList("com.koreait.integration.repository.board.selectQuery", map);	// 뒤에 map 추가 = 받아온거 전달해주기 
	}
	
	
	
	
	
}
