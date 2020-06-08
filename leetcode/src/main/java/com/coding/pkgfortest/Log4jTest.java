package com.coding.pkgfortest;

import org.apache.log4j.*;

import java.util.Arrays;
import java.util.Collections;

public class Log4jTest {
    static Logger logger = Logger.getLogger(Log4jTest.class);
    public static void main(String[] args) {
        BasicConfigurator.configure();
        logger.setLevel(Level.DEBUG);
        logger.trace("跟踪信息");
        logger.debug("调试信息");
        logger.info("输出信息");
        logger.warn("警告信息");
        logger.error("错误信息");
        logger.fatal("致命信息");
    }


 /*   public String reverseWords(String s) {
        String[] words = s.trim().split(" +");
        Collections.reverse(Arrays.asList(words));
        String join;
        join = String.join(" ", words);
        return join;
    }*/
}
