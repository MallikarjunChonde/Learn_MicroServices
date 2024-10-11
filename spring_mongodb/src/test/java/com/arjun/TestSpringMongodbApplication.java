package com.arjun;

import org.springframework.boot.SpringApplication;

public class TestSpringMongodbApplication {

	public static void main(String[] args) {
		SpringApplication.from(SpringMongodbApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
