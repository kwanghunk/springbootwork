package com.study.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import jakarta.persistence.EntityListeners;

@EnableJpaAuditing //@EntityListeners(AuditingEntityListener.class) 이거 관리한다고 작성해주는 것
@SpringBootApplication
public class Ex010AsscosiativeMappingApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ex010AsscosiativeMappingApplication.class, args);
	}

}
