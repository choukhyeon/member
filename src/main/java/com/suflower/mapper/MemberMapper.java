package com.suflower.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.suflower.domain.MemberVO;
import com.suflower.domain.ProductVO;

public interface MemberMapper {

	//회원가입
	public void memberJoin(MemberVO member);
	
	//아이디 중복 검사
	public int idCheck(String memberId);
	
	/* 로그인 */
	public MemberVO memberLogin(MemberVO member);

	@Select("select * from tbl_member ")
	public List<MemberVO> memberList();
}
