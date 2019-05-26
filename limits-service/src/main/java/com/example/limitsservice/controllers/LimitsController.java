package com.example.limitsservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.limitsservice.ConfigProperties;
import com.example.limitsservice.bean.LimitsConfigurationBean;

@RestController
@RequestMapping("limits")
public class LimitsController {
	
	@Autowired
	ConfigProperties config;
	
	@GetMapping
	public LimitsConfigurationBean getConfig() {
		return new LimitsConfigurationBean(config.getMin(), config.getMax());
	}

}
