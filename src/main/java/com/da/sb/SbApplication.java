package com.da.sb;

import com.da.sb.order.Order;
import com.da.sb.order.Side;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

//@SpringBootApplication(exclude =  {DataSourceAutoConfiguration.class }, scanBasePackages = {"com.da.sb"})
@SpringBootApplication()
public class SbApplication {

	private static final Logger log = LoggerFactory.getLogger(SbApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(SbApplication.class, args);
	}

	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	public CommandLineRunner test(OrderRepo repo) {
		return (args) -> {
			repo.save(new Order(65., 2000., Side.BUY));
			repo.save(new Order(64., 1000., Side.BUY));
			repo.save(new Order(63., 2000., Side.BUY));

			repo.save(new Order(69., 2000., Side.SELL));
			repo.save(new Order(68., 1000., Side.SELL));
			repo.save(new Order(67., 2000., Side.SELL));

			repo.findAll().forEach(ord -> log.info(ord.toString()));

			log.info(repo.findById(1L).toString());
			log.info(repo.findById(3L).toString());
			log.info(repo.findById(5L).toString());

			repo.findBySide(Side.SELL).forEach(ord -> log.info(ord.toString()));
		};
	}
}
