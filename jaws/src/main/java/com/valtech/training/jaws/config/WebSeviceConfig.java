package com.valtech.training.jaws.config;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.valtech.training.jaws.HelloWorldImpl;
import com.valtech.training.jaws.services.MovieService;
import com.valtech.training.jaws.webservices.MovieServiceWSImpl;

@Configuration
public class WebSeviceConfig {
		@Autowired
		private Bus bus; //bus is communication channel
		@Bean
		public Endpoint movieServiceWS(MovieService movieService) {
				EndpointImpl endpoint=new EndpointImpl(bus,new MovieServiceWSImpl(movieService));
				endpoint.setAddress("/movieService");
				endpoint.publish();
				return endpoint;
		}
		@Bean
		public Endpoint helloWorldWebService() { //endpoint where are webservices
			EndpointImpl endpoint=new EndpointImpl(bus,new HelloWorldImpl());
			endpoint.setAddress("/helloWorld");
			endpoint.publish();
			return endpoint;
		}
}
