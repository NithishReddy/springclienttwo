package com.example.springbusrefreshtwo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.context.environment.EnvironmentChangeEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
@RefreshScope
public class ClientController implements ApplicationListener<EnvironmentChangeEvent>{
    @Autowired
    private Environment env;

    @Value("${db.password}")
    private  String dbPassword;

    @GetMapping("/hello")
    public ResponseEntity<String> getHello(Model model) {   
        System.out.print("-------");
        return new ResponseEntity<String>(dbPassword, HttpStatus.OK);
    }

	public void onApplicationEvent(EnvironmentChangeEvent event) {
		
        System.out.println("Second Step STEP");
			System.out.println("prop-4 is updated: " + dbPassword);
            System.out.println("prop-4 is updated value:" + env.getProperty("db.password"));
            System.out.println("Second STEP end");
	}
}
