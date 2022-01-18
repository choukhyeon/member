package com.suflower.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import lombok.extern.log4j.Log4j;

import com.suflower.mapper.TimeMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {com.suflower.config.RootConfig.class})
@Log4j
public class TimeMapperTests {
	
	private TimeMapper timeMapper;

	public TimeMapper getTimeMapper() {
		return timeMapper;
	}
	
	@Autowired
	public void setTimeMapper(TimeMapper timeMapper) {
		this.timeMapper = timeMapper;
	}
	
	@Test
	public void testGetTime() {
		log.info(timeMapper.getClass().getName());
		log.info(timeMapper.getTime());
	}
	
	@Test
	public void testGetTime2() {
		log.info("getTime2");
		log.info(timeMapper.getTime2());
	}
}
