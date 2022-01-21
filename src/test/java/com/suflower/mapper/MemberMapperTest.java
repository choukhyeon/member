package com.suflower.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.suflower.domain.MemberVO;

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
    @Test
    public void memberLogin() throws Exception{
        
        MemberVO member = new MemberVO();    // MemberVO 변수 선언 및 초기화
        
        /* 올바른 아이디 비번 입력경우 */
        member.setMemberId("test");
        member.setMemberPassword("12345");
        
        /* 올바른 않은 아이디 비번 입력경우 */
        //member.setMemberId("test1123");
        //member.setMemberPw("test1321321");
        
        mapper.memberLogin(member);
        System.out.println("결과 값 : " + mapper.memberLogin(member));
        
    }
}
