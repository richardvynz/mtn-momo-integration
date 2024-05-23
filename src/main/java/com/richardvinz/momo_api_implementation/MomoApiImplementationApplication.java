package com.richardvinz.momo_api_implementation;

import com.richardvinz.momo_api_implementation.clients.MomoApiClient;
import com.richardvinz.momo_api_implementation.clients.MomoAuthApiClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
@RequiredArgsConstructor
@Slf4j
@EnableConfigurationProperties
public class MomoApiImplementationApplication {

	private final MomoApiClient momoClient;
	@Bean
	ApplicationRunner applicationRunner(){
		return args -> {
			var response = momoClient.getAccountBalance();
			log.info("Account Balance from momo: ",response);
		};
	}


	public static void main(String[] args) {
		SpringApplication.run(MomoApiImplementationApplication.class, args);
	}

}
