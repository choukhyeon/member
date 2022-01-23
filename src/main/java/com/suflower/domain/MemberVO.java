package com.suflower.domain;

import lombok.Data;

@Data
public class MemberVO {
	private String memberId;
	private String memberPassword;
	private String memberName;
	private String memberMail;
	private String memberAddr1;
	private String memberAddr2;
	private String memberAddr3;
	
	private String memberPhoneNum; // > 이터럴방식

	String a = new String("memberID"); // new String 방식
	
	String b = new String("memberID"); // new String 방식
	
	private int adminCheck;
	private int	memberRegDate;
	private int memberMoney;
	private int memberPoint;

}
