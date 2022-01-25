package com.suflower.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.suflower.domain.MemberDTO;

public interface MemberMapper {

	//회원가입
	public void memberJoin(MemberDTO member);
	
	//아이디 중복 검사
	public int idCheck(String memberId);
	
	/* 로그인 */
	public MemberDTO memberLogin(MemberDTO member);

	@Select("select * from tbl_member ")
	public List<MemberDTO> memberList();
	
	// 내정보 확인
	public MemberDTO memberInfo(MemberDTO member);
	
	// 내정보 수정
	public int memberUpdate(MemberDTO member);

}
