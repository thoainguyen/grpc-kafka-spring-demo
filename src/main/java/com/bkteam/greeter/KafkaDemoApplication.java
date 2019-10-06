package com.bkteam.greeter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;

@SpringBootApplication
public class KafkaDemoApplication implements DisposableBean, CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(KafkaDemoApplication.class, args);
	}

	private static final Logger LOGGER = LogManager.getLogger();

	@Override
	public void run(String... args) {
		LOGGER.info("Kafka Demo Service Is Running....");

		String pidFile = System.getProperty("pidfile");
		if (pidFile != null) {
			new File(pidFile).deleteOnExit();
		}
	}

	@Override
	public void destroy() {
	}
}
