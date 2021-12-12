package br.edu.infnet.appbiblioteca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AppbibliotecaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppbibliotecaApplication.class, args);
	}

}
