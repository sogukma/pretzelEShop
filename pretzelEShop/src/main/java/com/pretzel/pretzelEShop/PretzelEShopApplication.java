package com.pretzel.pretzelEShop;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class PretzelEShopApplication {

	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private PretzelRepository pretzelRepository;
	@Autowired
	private OrdersService ordersService;


	
	public static void main(String[] args) {
		SpringApplication.run(PretzelEShopApplication.class, args);
	}
	
	@PostConstruct
	public void init()
	{
		Pretzel p = new Pretzel();
		p.setPrice(132);
		p.setName("ads");
		p.setStockAmount(3);
		p = pretzelRepository.save(p);
		
		Customer c = new Customer();
		c.setName("dsf");

		c = customerRepository.save(c);
		
		ordersService.orderPretzel(c, p, 2);


		
	}
}
