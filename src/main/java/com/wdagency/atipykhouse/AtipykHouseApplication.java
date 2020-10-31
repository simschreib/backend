package com.wdagency.atipykhouse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.wdagency.atipykhouse.model.Hebergement;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class AtipykHouseApplication {

	public static void main(String[] args) {
		SpringApplication.run(AtipykHouseApplication.class, args);
	}

}
