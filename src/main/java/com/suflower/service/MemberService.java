package com.suflower.service;

import com.suflower.domain.MemberDTO;

public interface MemberService {

	//회원가입
	public void memberJoin(MemberDTO member) throws Exception;
	
	// 아이디 중복 검사
	public int idCheck(String memberId) throws Exception;

	/* 로그인 */
	public MemberDTO memberLogin(MemberDTO member) throws Exception;
	

	//회원정보 보기
	public MemberDTO readMember(MemberDTO member);
	
	//회원정보 수정
	public int updateMember(MemberDTO vo);
	
	//회원정보 삭제
	public void deleteMember(MemberDTO vo);
}
