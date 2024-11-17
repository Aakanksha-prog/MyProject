package com.todo.myrestapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@ComponentScan("com.todo.*")
@EntityScan("com.todo.myrestapi.entity")
@EnableJpaRepositories("com.todo.myrestapi.repository")
public class MyRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyRestApiApplication.class, args);
	}

}
