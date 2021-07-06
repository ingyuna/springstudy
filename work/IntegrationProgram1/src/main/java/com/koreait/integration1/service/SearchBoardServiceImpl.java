package com.koreait.integration1.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.koreait.integration1.domain.Movie;
import com.koreait.integration1.repository.SearchBoardRepository;

public class SearchBoardServiceImpl implements SearchBoardService {

	@Autowired
	private SearchBoardRepository repository;
	
	@Override
	public List<Movie> totalList() {		
		return repository.selectAll();
	}

	@Override
	public List<Movie> searchList(Map<String, String> map) {	
		return repository.selectQuery(map);
	}

}
