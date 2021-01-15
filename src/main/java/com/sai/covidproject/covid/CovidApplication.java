package com.sai.covidproject.covid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import com.sai.covidproject.covid.repo.EmployeeRepository;


@SpringBootApplication
@EnableSwagger2
@EnableJpaRepositories("com.sai.covidproject.covid.repo")
//@EnableAutoConfiguration()

public class CovidApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(CovidApplication.class, args);
	}
}
