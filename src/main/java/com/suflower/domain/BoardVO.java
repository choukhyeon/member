package com.suflower.domain;

import java.util.Date;

import lombok.Data;

@Data
public class BoardVO {
	
	 /* 게시판 번호 */
    private long boardNo;
    /* 게시판 제목 */
    private String boardTitle;
    /* 게시판 내용 */
    private String boardContent;
    /* 게시판 작가 */
    private String boardWriter;
    /* 등록 날짜 */
    private Date boardRegDate;
    /* 수정 날짜 */
    private Date boardUpdateDate;
 

}
