package com.imooc;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class LoggerTest {
//    private static final Logger LOGGER = LoggerFactory.getLogger(LoggerTest.class);

    @Test
    public void testLoger() throws Exception{
        String name = "jack";
        String password = "123456";
        log.debug("debug...");
        log.info("name:{};password:{}",name,password);
        log.warn("warn...");
        log.error("error...");

        String str = "hello";
        byte[] bytes = str.getBytes("utf-8");
        log.info(bytes.toString());

    }
}
