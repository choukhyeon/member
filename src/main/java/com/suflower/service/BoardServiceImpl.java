package com.suflower.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suflower.mapper.BoardMapper;
import com.suflower.domain.BoardVO;
import com.suflower.domain.Criteria;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardMapper mapper;
	
	// 게시판 등록
	@Override
	public void bwrite(BoardVO board) {
		mapper.bwrite(board);
	}
	
	//게시판 목록
	@Override
	public List<BoardVO> getList(){
		return mapper.getList();
	}
	
	// 게시판 목록(페이징)
	@Override
	public List<BoardVO> getListPaging(Criteria cri) {
		return mapper.getListPaging(cri);
	}
	
	// 게시물 총 개수
	@Override
	public int getTotal() {
		return  mapper.getTotal();
	}
	
	// 게시글  조회
	@Override
	public  BoardVO getPage(long boardNo) {
		return mapper.getPage(boardNo);
	}
	
	// 게시글 수정
	@Override
	public int modify(BoardVO board) {
		return mapper.modify(board);
	}
	
	// 게시글 삭제
	@Override
	public int delete(long boardNo) {
		return mapper.delete(boardNo);
	}
	
	//게시물 총 갯수
	@Override
	public int getTotal(Criteria cri) {
		return mapper.getTotal(cri);
	}
	
	@Override
	public void getSession() {
		mapper.getSession();
	}
}
