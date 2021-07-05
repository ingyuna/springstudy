package com.koreait.myproject.dao;

import com.koreait.myproject.dto.Member;

public interface HomeDAO {

	public int join(Member member);
	public Member login(Member member);
}
