package com.koreait.myproject.command;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

public interface HomeCommand {

	public void execute(SqlSession sqlSession, Model model);
}
