package com.yagodamalinka.soap;

import org.oorsprong.websamples.CountryNameResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.beans.Expression;
import java.util.Scanner;

@SpringBootApplication
public class SoapApplication {

	public static void main(String[] args) {
		SpringApplication.run(SoapApplication.class, args);
	}

	@Bean
	CommandLineRunner lookup(ContinentRepository continentRepository) {
		return args -> {
			while (true){
				System.out.println("Необходимо ввести ISO код страны, например - RU");
				Scanner s = new Scanner(System.in);
				String ISOCode = s.nextLine();

				if (args.length > 0) {
					ISOCode = args[0];
				}

				CountryNameResponse response = continentRepository.getCountryByISOCode(ISOCode);
				System.out.println("SLOVNO HUY DROCHENIY V ZHOPU PIDORA");
				System.err.println(response.getCountryNameResult());
			}
		};
	}


}
