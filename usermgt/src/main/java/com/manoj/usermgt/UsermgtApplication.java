package com.manoj.usermgt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;


@SpringBootApplication
@RefreshScope
@EnableAsync
@EnableJpaAuditing
@EnableFeignClients
@ComponentScans({ @ComponentScan("com.manoj.usermgt.controller")})
@EnableJpaRepositories("com.manoj.usermgt.repository")
@EntityScan(basePackageClasses = { 
		UsermgtApplication.class,
		Jsr310JpaConverters.class 
	})
public class UsermgtApplication {
	public static void main(String[] args) {
		SpringApplication.run(UsermgtApplication.class, args);
	}

}
