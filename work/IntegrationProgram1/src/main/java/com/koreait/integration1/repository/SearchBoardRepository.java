package com.koreait.integration1.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.koreait.integration1.domain.Movie;

@Repository
public class SearchBoardRepository {

	@Autowired
	private SqlSession sqlSession;
	
	public List<Movie> selectAll() {
		return sqlSession.selectList("com.koreait.integration1.repository.board.selectAll");	
	}
	
	public List<Movie> selectQuery(Map<String, String> map) {
		return sqlSession.selectList("com.koreait.integration1.repository.board.selectQuery", map);	
	}
	
	
	
}
