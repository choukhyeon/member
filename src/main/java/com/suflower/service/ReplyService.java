package com.suflower.service;

import java.util.List;

import com.suflower.domain.Criteria;
import com.suflower.domain.ReplyVO;

public interface ReplyService {
	
	public int register(ReplyVO vo);
	
	public ReplyVO get(Long replyNo);
	
	public int modify(ReplyVO vo);
	
	public int remove(Long replyNo);
	
	public List<ReplyVO> getList(Criteria cri,Long boardNo);
	

}
