package com.valtech.training.jaxws.client;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.valtech.training.jaws.HelloWorld;
import com.valtech.training.jaws.Movie;
import com.valtech.training.jaws.webservices.MovieServiceWS;

@SpringBootTest
class ApplicationTests {
	@Autowired
	private MovieServiceWS movieServicesWS;

	@Autowired
	private HelloWorld helloWorld;
	 
	@Test
	void contextLoads() {
//		System.out.println("Hello World "+helloWorld);
//		System.out.println(helloWorld.hello("Valtech"));
		movieServicesWS.createMovie(new Movie("Dil","Action","Hindi",List.of("AK")));
		//movieServicesWS.createMovie(new Movie("Hum","Action","Hindi",List.of("Ab")));
//		movieServicesWS.createMovie(new Movie("ABCD","Action","Hindi",List.of("Varun")));

		System.out.println(movieServicesWS.getAllMovies());
	}
}
