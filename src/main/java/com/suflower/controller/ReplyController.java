package com.suflower.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.suflower.domain.Criteria;
import com.suflower.domain.ReplyVO;
import com.suflower.service.ReplyService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@RequestMapping("/replies")
@RestController
@Log4j
@AllArgsConstructor
public class ReplyController {
	private ReplyService service;
	
	//특정 게시물의 댓글목록 확인
	@GetMapping(value ="/pages/{boardNo}/{page}", produces= {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<List<ReplyVO>> getList(@PathVariable("page") int page, @PathVariable("boardNo") Long boardNo){
		log.info("GetList");
		Criteria cri = new Criteria(page,10);
		log.info(cri);
		return new ResponseEntity<>(service.getList(cri, boardNo),HttpStatus.OK);
	}
	
	// 댓글 조회
	@GetMapping(value ="/{ReplyNo}",produces= {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<ReplyVO> get(@PathVariable("ReplyNo")Long ReplyNo){
		log.info("get : "+ReplyNo);
		return new ResponseEntity<>(service.get(ReplyNo),HttpStatus.OK);
	}
	
	//댓글 삭제
	@DeleteMapping(value = "/{ReplyNo}",produces= {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> remove(@PathVariable("ReplyNo")Long ReplyNo){
		log.info("remove : "+ReplyNo);
		return service.remove(ReplyNo)==1 ? new ResponseEntity<>("success",HttpStatus.OK) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	//댓글 수정
	@RequestMapping(method = {RequestMethod.PUT,RequestMethod.PATCH}, value="/{ReplyNo}", consumes="application/json",
			produces= {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> modify(
		@RequestBody ReplyVO vo,
		@PathVariable("ReplyNo") Long ReplyNo){
		vo.setBoardNo(ReplyNo);
		log.info("ReplyNo : "+ReplyNo);
		log.info("Modify : "+vo);
		
		return service.modify(vo)==1 ? new ResponseEntity<>("success",HttpStatus.OK) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		
			
		}
	
	
	
	@PostMapping(value = "/new", consumes="application/json",produces= {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> create(@RequestBody ReplyVO vo){
		log.info("replyVO =>"+vo);
		int insertCount=service.register(vo);
		
		log.info("reply insert Count"+insertCount);
		
		// InsertCount==1이 true이면 2가 실행, 아니면 3이실행 (2:3) 
		return insertCount==1 ? new ResponseEntity<>("success",HttpStatus.OK) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		// 삼항 연산자 처리
		
	}
	

}
