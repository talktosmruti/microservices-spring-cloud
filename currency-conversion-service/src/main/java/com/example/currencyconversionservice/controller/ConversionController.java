package com.example.currencyconversionservice.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/currency-converter")
public class ConversionController {

	
	@Autowired
	CurrencyExchangeServiceProxy proxy;
	
	@GetMapping("/from/{from}/to/{to}/quantity/{quantity}")
	public ExchangeValue convert(@PathVariable String from,
			@PathVariable String to,
			@PathVariable String quantity) {
		Map<String,String> uriVariables = new HashMap<>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		//CurrencyCoonversionBean result = this.rest.getForEntity("http://localhost:9000/currency-exchange/from/EUR/to/INR", CurrencyCoonversionBean.class, uriVariables).getBody();
		ExchangeValue result = this.proxy.getExcValue(from, to);
		//result.setQuantity(result.getConversionMultiple().multiply(new BigDecimal(quantity)));
		return result;
	}

}
