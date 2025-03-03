package webservices;

import org.apache.cxf.frontend.ServerFactoryBean;

public class MovieServer {

	public static void main(String[] args) {
		ServerFactoryBean server=new ServerFactoryBean();
		server.setAddress("http://localhost:7777/MovieService");
		server.setServiceBean(new MovieServiceImpl());
		server.setServiceClass(MovieService.class);
		server.create();
		System.out.println("Movie service Running");

	}

}
