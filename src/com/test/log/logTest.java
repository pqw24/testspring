package com.test.log;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class logTest {
      static Logger logger = Logger.getLogger(logTest.class);  
      public static void main(String argv[]) {  
        BasicConfigurator.configure();  
        logger.debug("Hello world.");  
        logger.info("What a beatiful day.");  
      }  
}
