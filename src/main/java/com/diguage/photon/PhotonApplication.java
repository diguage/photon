package com.diguage.photon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:spring.xml")
public class PhotonApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhotonApplication.class, args);
	}
}
