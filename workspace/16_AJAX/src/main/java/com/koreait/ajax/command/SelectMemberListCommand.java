package com.koreait.ajax.command;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.koreait.ajax.dao.MemberDAO;
import com.koreait.ajax.dto.Member;
import com.koreait.ajax.dto.Page;
import com.koreait.ajax.util.PagingUtils;

public class SelectMemberListCommand implements MemberCommand {

	@Override
	public Map<String, Object> execute(SqlSession sqlSession, Model model) {
		
		Map<String, Object> map = model.asMap();
		int page = (int)map.get("page");
		
		MemberDAO memberDAO = sqlSession.getMapper(MemberDAO.class);
		
		int totalRecord = memberDAO.getTotalMemberCount();
		
		/*
		// manageMember.jsp로 전달할 Map (모르겠으면 일단 다 전달한다. 전달하고 안써도 됨)
		Map<String, Integer> paging = new HashMap<>();
		paging.put("totalRecord", totalRecord);
		paging.put("page", page);
		paging.put("total", totalPage);
		paging.put("pagePerBlock", pagePerBlock);
		paging.put("beginPage", beginPage);
		paging.put("endPage", endPage);
		
		
		Map<String, Integer> pagingMap = new HashMap<String, Integer>();
		pagingMap.put("beginRecord", beginRecord);
		pagingMap.put("endRecord", endRecord);
		*/
		
		Page paging = PagingUtils.getPage(totalRecord, page);
		
		
		List<Member> list = memberDAO.selectMemberList(paging);
		// System.out.println("회원 수: " + list.size());
		
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("list", list);
		resultMap.put("exists", list.size() > 0);		// -> returnType은 true 또는 false
		resultMap.put("paging", paging);
		return resultMap;
	}

}
