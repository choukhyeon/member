package com.suflower.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.suflower.domain.MemberDTO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {com.suflower.config.RootConfig.class})
@Log4j
public class MemberMapperTest {

	@Setter(onMethod_ = @Autowired)
	private MemberMapper mapper;
	
	//@Test
	public void memberList() {
		mapper.memberList().forEach(product -> log.info(product));
	}
	
	/* 로그인 쿼리 mapper 메서드 테스트 */
    //@Test
    public void memberLogin() throws Exception{
        
        MemberDTO member = new MemberDTO();    // MemberDTO 변수 선언 및 초기화
        
        /* 올바른 아이디 비번 입력경우 */
        member.setMemberId("test");
        member.setMemberPassword("12345");
        
        /* 올바른 않은 아이디 비번 입력경우 */
        //member.setMemberId("test1123");
        //member.setMemberPw("test1321321");
        
        mapper.memberLogin(member);
        System.out.println("결과 값 : " + mapper.memberLogin(member));
        
    }
    
    /* 업데이트 쿼리 mapper 메서드 테스트 */
    @Test
    public void memberUpdate() throws Exception{
    	
    	MemberDTO member = new MemberDTO();  
    	//실행전 존재하는 name인지 학인
    	member.setMemberId("test");
    	member.setMemberPassword("12345");
    	member.setMemberName("수정된 이름");
    	member.setMemberAddr1("test 우편번호");
    	member.setMemberAddr2("test 주소");
    	member.setMemberAddr3("test 주소 상세");
    	member.setMemberMail("수정된 이메일");
    	member.setMemberPhoneNum("010-1234-5678");
    	
    	int count = mapper.memberUpdate(member);
    	log.info("UPDATE COUNT: " + count);
    	
    }
}
