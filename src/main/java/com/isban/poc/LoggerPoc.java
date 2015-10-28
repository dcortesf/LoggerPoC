package com.isban.poc;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
@EnableAutoConfiguration
public class LoggerPoc {
		String[] apps={"app1","appZ","app2"};
		String[] types={"FUNCTIONAL","TECHNICAL"};
		
		int numTraces = 100;
	
	    @RequestMapping("/")
	    String emulateActivity() {
	    	
	    	StringBuffer b=new StringBuffer();
	    	Logger logger = LoggerFactory.getLogger(LoggerPoc.class);
	    	
	    	
	    	for(int i=0;i<numTraces;i++){
	    		
	    		 Random rand = new Random();
	    		 int randomNum = rand.nextInt((2 - 0) + 1) + 0;
	    		 String app = apps[randomNum];
	    		 
	    		 randomNum = rand.nextInt((1 - 0) + 1) + 0;
	    		 String type= types[randomNum];
	    		 
	    		 String msg="[app]: "+app+" [type]: "+type +" [msg]: Este es el mensaje de la aplicación";
	    		 
	    		 logger.info(msg);
	    		 b.append("<br>"+msg);
	    
	    	}
	    
	    	   	
	        return b.toString();
	    }

	    public static void main(String[] args) throws Exception {
	        SpringApplication.run(LoggerPoc.class, args);
	    }

}
