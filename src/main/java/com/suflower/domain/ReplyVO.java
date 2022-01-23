package com.suflower.domain;

import java.util.Date;

import lombok.Data;

@Data
public class ReplyVO {
	
	private long replyNo;
	private long boardNo;
	
	private String replyContent;
	private String replyWriter;
	private Date replyDate;
	private Date replyUpdateDate;
	
	

}
