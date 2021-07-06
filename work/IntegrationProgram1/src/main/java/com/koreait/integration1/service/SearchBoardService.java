package com.koreait.integration1.service;

import java.util.List;
import java.util.Map;

import com.koreait.integration1.domain.Movie;

public interface SearchBoardService {

	public List<Movie> totalList();
	public List<Movie> searchList(Map<String, String> map);
	
}
