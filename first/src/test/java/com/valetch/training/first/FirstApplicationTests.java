package com.valetch.training.first;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FirstApplicationTests {

	@Autowired
	private Arithmetic arithmetic;
	
	@Autowired
	private SimpleInterest simpleInterest;

	@Test
	void contextLoads() {

		assertEquals(10, arithmetic.add(4, 6));
		assertEquals(200, simpleInterest.compute(200, 5, 20));
	}
	

}
