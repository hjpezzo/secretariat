package br.com.harley.secretariat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SecretariatApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecretariatApplication.class, args);
	}

}
