package com.coding.log4j;

import org.apache.log4j.*;
import org.junit.Test;

import java.io.IOException;

public class TestForLog4j {

    @Test
    public void startLog4j() throws IOException {
        Logger logger = Logger.getLogger(TestForLog4j.class);
        logger.addAppender(new FileAppender(new PatternLayout(PatternLayout.TTCC_CONVERSION_PATTERN), "mylog.txt", true));
        logger.addAppender(new ConsoleAppender(new PatternLayout(PatternLayout.TTCC_CONVERSION_PATTERN)));
        logger.info("hello");
    }
}
