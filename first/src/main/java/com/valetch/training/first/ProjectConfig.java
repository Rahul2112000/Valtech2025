package com.valetch.training.first;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//configration annotation then used to define beans ,dependencies
@Configuration
public class ProjectConfig {
	
	
//	@Bean
	public SimpleInterest simpleInterest(Arithmetic arithmetic) {
		
		
		return new SimpleInterestImpl(arithmetic);
		
	}
//	@Bean
	public Arithmetic arithmetic() {
		return new ArithmeticImpl();
	}
}
