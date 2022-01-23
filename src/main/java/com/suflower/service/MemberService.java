package com.suflower.service;

import com.suflower.domain.MemberVO;

public interface MemberService {

	//회원가입
	public void memberJoin(MemberVO member) throws Exception;
	
	// 아이디 중복 검사
	public int idCheck(String memberId) throws Exception;

	/* 로그인 */
	public MemberVO memberLogin(MemberVO member) throws Exception;
	

	//회원정보 보기
	public MemberVO readMember(MemberVO member);
	
	//회원정보 수정
	public void updateMember(MemberVO vo);
	
	//회원정보 삭제
	public void deleteMember(MemberVO vo);
}
