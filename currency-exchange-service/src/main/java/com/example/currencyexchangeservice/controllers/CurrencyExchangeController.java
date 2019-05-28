package com.example.currencyexchangeservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("currency-exchange")
public class CurrencyExchangeController {
	
	@Autowired
	private ExchangeValueJpaRepository repo;
	
	@Autowired
	private Environment env;
	
	@GetMapping("/from/{from}/to/{to}")
	public ExchangeValue getExcValue(@PathVariable String from, @PathVariable String to) {
		ExchangeValue value = null;
		try {
		 value = repo.findByFromAndTo(from, to);
		value.setPort(Integer.parseInt(env.getProperty("local.server.port")));
		}catch(Exception e) {
			System.out.println(e.getClass());
		}
		return value;
	}

	@GetMapping("/test")
	public String test() {
		return "JUJU";
	}
}
