package com.koreait.myproject.dao;



import java.util.List;

import com.koreait.myproject.dto.GalleryBoard;
import com.koreait.myproject.dto.Member;

public interface HomeDAO {

	// member
	public int join(Member member);
	public Member login(Member member);
	public Member findId(String name, String phone);
	public int changePw(Member member);
	public int leave(long no);
	
	// galleryBoard
	public int insertGalleryBoard(String id, String title, String content, String ip, String filename);
	public List<GalleryBoard> selectGalleryBoardList();
	public GalleryBoard selectBoardByNo(long no);
	public int updateGalleryBoard(String title, String content, String filename, long no);
	
}
