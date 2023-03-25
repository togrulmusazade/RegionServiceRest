package com.company.regionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@EnableJpaRepositories("com.company.*")
//@ComponentScan(basePackages = { "com.company.*" })
//@EntityScan("com.company.*")
@SpringBootApplication
public class RegionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegionServiceApplication.class, args);
	}



}
