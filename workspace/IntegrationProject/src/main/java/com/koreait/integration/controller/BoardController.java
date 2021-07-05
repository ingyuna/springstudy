package com.koreait.integration.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.koreait.integration.domain.Board;
import com.koreait.integration.service.BoardService;

@Controller
public class BoardController {
	
	// Sqlsession은 BoardRepository에서 아까 썼기 때문에 필요하지 않다.
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping(value = "/")
	public String index() {
		return "index";
	}
	
	@GetMapping(value = "selectAll.do", produces="application/json; charset=utf-8") // 받아주는게 json이다 하면 이렇게 produces를 추가해준다.
	@ResponseBody
	public Map<String, Object> selectAll() {		// status를 int로 받기로 했으니까 다양하게 쓸 수 있는 Object로 한다.
		List<Board> list = boardService.totalList();
		Map<String, Object> resultMap  = new HashMap<String, Object>(); // 위에 list를 받아서 반환해야 하니까 새로운 map을 만들어준다.
		if (list.size() == 0) {		// 목록이 없을 때
			resultMap.put("status", 500);
			resultMap.put("list", null);
			resultMap.put("message", "목록이 없습니다.");
		} else {
			resultMap.put("status", 200);
			resultMap.put("list", list);
			resultMap.put("message", "목록을 가져왔습니다.");
		}
		return resultMap;	
	}
	
	@GetMapping(value = "selectQuery.do", produces="application/json; charset=utf-8")
	@ResponseBody
	public Map<String, Object> selectQuery(HttpServletRequest request) {
		Map<String, String> map = new HashMap<>();
		map.put("column", request.getParameter("column"));
		map.put("query", request.getParameter("query"));
		List<Board> list = boardService.searchList(map);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		if (list.size() == 0) {
			resultMap.put("status", 500);
			resultMap.put("list", null);
			resultMap.put("message", "검색 결과가 없습니다.");
		} else {
			resultMap.put("status", 200);
			resultMap.put("list", list);
			resultMap.put("message", "검색 결과를 가져왔습니다.");
		}
		return resultMap;
	}
	
	
	
	
	
}
