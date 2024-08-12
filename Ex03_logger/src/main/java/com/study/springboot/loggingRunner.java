package com.study.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

@Service
public class loggingRunner implements ApplicationRunner {

	private static final Logger logger = LoggerFactory.getLogger(Ex03LoggerApplication.class);
	/*private static final은 생략가능 자동으로 붙음*/
	@Override
	public void run(ApplicationArguments args) throws Exception {
		logger.trace("Trace 레벨 로그");
		logger.debug("debug 레벨 로그");
		logger.info("info 레벨 로그");
		logger.warn("warn 레벨 로그");
		logger.error("error 레벨 로그");
		
	}

}
