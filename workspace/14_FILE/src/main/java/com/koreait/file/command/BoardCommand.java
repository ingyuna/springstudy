package com.koreait.file.command;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

public interface BoardCommand {
	public void exectue(SqlSession sqlSession, Model model);
	
}
