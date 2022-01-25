package com.suflower.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suflower.mapper.MemberMapper;
import com.suflower.domain.MemberDTO;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberMapper membermapper;
	
	/* 회원가입 */
	@Override
	public void memberJoin(MemberDTO member) throws Exception{
		membermapper.memberJoin(member);
	}
	
	/* 아이디 중복 검사 */
	@Override
	public int idCheck(String memberId) throws Exception {
		
		return membermapper.idCheck(memberId);
	}
	
	/* 로그인 */
	@Override
	public MemberDTO memberLogin(MemberDTO member) throws Exception{
		return membermapper.memberLogin(member);
	}
	
	/* 내정보 */
	@Override
	public MemberDTO readMember(MemberDTO member) {
		return membermapper.memberInfo(member);
	}
	
	/* 내정보 수정 */
	@Override
	public int updateMember(MemberDTO member) {
		return membermapper.memberUpdate(member);
	}
	
	@Override
	public void deleteMember(MemberDTO vo) {
		
	}
}
