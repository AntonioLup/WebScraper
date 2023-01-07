package com.scraper.crudscraper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrudscraperApplication {

	public static void main(String[] args) {
		try{
			SpringApplication.run(CrudscraperApplication.class, args);
		}catch(Exception e){
			e.printStackTrace();
			System.out.println(" ERRO -> " + e.getMessage());
		}
	}

}
