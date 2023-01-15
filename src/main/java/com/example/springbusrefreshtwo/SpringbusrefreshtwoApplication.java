package com.example.springbusrefreshtwo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.context.environment.EnvironmentChangeEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@RefreshScope
public class SpringbusrefreshtwoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbusrefreshtwoApplication.class, args);
	}

	@EventListener({EnvironmentChangeEvent.class})
	public void onRefresh() {
		System.out.println("environment Changed..");
	}
}
