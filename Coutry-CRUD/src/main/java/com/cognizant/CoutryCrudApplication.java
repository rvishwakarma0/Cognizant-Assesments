package com.cognizant;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class CoutryCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoutryCrudApplication.class, args);
		log.info("Inside main");
		displayDate();
	}

	static void displayDate() {
		log.info("start");
		ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
		SimpleDateFormat simple = context.getBean("dateFormat", SimpleDateFormat.class);
		try {
			System.out.println(simple.parseObject("31/12/2018"));

		} catch (ParseException e) {
			e.printStackTrace();
		}
		log.debug("");
		log.info("End");

	}
}
