package com.suflower.reply;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.suflower.mapper.ReplyMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringRunner.class)
// Java file로 설정시 
@ContextConfiguration(classes= {com.suflower.config.RootConfig.class})
@Log4j
public class ReplyMapperTests {
	@Setter(onMethod_=@Autowired)
	private ReplyMapper mapper;
	
	@Test
	public void testCreate() {
		log.info(mapper);
	}

}
