package com.example.currencyconversionservice.controller;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.currencyconversionservice.models.CurrencyCoonversionBean;

@FeignClient(name="currency-exchange-service")
@RibbonClient(name = "currency-exchange-service")
public interface CurrencyExchangeServiceProxy {
	
	@GetMapping("/cuurency-exchange/from/{from}/to/{to}")
	public CurrencyCoonversionBean getExcValue(@PathVariable String from, @PathVariable String to);
		

}
