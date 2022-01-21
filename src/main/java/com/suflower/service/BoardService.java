package com.suflower.service;

import java.util.List;

import com.suflower.domain.BoardVO;
import com.suflower.domain.Criteria;

public interface BoardService {
	
	// 게시판 등록
	public void bwrite(BoardVO board);
	
	//게시판 목록
	public List<BoardVO> getList();

	//게시판 목록(페이징)
	public List<BoardVO> getListPaging(Criteria cri);
	
	// 게시물 총 개수
	public int getTotal();
	
	// 게시글 조회
	public BoardVO getPage(long boardNo);
	
	// 게시글 수정
	public int modify(BoardVO board);
	
	// 게시글 삭제
	public int delete(long boardNo);
	
	// 게시판 총 갯수
	public int getTotal(Criteria cri);
	
	// 세션 확인
	public void getSession();
	
}
