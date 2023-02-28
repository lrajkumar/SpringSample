package com.sample;

import com.sample.repository.BaseRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.sample.repository", repositoryBaseClass = BaseRepository.class)
@EntityScan(basePackages = "com.sample.entity")
public class SpringSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSampleApplication.class, args);
	}

}
