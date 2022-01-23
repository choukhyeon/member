package com.suflower.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.suflower.domain.Criteria;
import com.suflower.domain.ReplyVO;

public interface ReplyMapper {
	
	// 댓글 입력
	public int insert(ReplyVO vo);

	// 특정한 댓글 읽기
	public ReplyVO read(Long replyNo);

	public int delete (Long replyNo);
	
	public  int update(ReplyVO reply);
	
	public List<ReplyVO> getListWithPaging(
			@Param("cri") Criteria cri,
			@Param("boardNo") Long boardNo);
	
	

}
