package com.suflower.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suflower.domain.Criteria;
import com.suflower.domain.ReplyVO;
import com.suflower.mapper.ReplyMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class ReplyServiceImpl implements ReplyService{
	
	@Setter(onMethod_=@Autowired)
	private ReplyMapper mapper;
	
	
	@Override
		public ReplyVO get(Long replyNo) {
			return mapper.read(replyNo);
	}
	
	@Override
	public List<ReplyVO> getList(Criteria cri, Long boardNo) {
		return mapper.getListWithPaging(cri, boardNo);
	}
	@Override
	public int modify(ReplyVO vo) {
		return mapper.update(vo);
	}
	
	@Override
	public int register(ReplyVO vo) {
		return mapper.insert(vo);
	}
	
	@Override
	public int remove(Long replyNo) {
		return mapper.delete(replyNo);
	}
}