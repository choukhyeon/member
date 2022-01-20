package com.suflower.domain;

import lombok.Data;

@Data
public class Criteria {
	
	//현재 페이지
	private int pageNum;
	
	// 한페이지에 보여질 게시물 갯수
	private int amount;
	
	//검색 키워드
	private String keyword;
	
	// 기본 생성자 -> 기본세팅 : pagenum 1 amount 10
	public Criteria(){
		this(1,10);
	}
	// 생성자 => 원하는 pageNum , 원하는 amount,
	public Criteria(int pageNum,int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
}
