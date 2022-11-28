package org.iiitb.splitwise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
public class SplitwiseApplication {
	private static final Logger log = LogManager.getLogger(SplitwiseApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SplitwiseApplication.class, args);
		log.info("Application Started");
	}
}
