package com.suflower.mapper;

import com.suflower.domain.ReplyVO;

public interface ReplyMapper {
	
	// 댓글 입력
	public int insert(ReplyVO vo);

	// 특정한 댓글 읽기
	public ReplyVO read(Long replyNo);

	public int delete (int replyNo);
	

}
