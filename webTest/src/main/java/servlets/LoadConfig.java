package servlets;

import java.io.IOException;

import java.io.InputStream;

import java.util.Properties;

import dao.EmployeeDAOImpl;

import jakarta.servlet.ServletContext;

import jakarta.servlet.ServletContextEvent;

import jakarta.servlet.ServletContextListener;

public class LoadConfig implements ServletContextListener {

	@Override

	public void contextInitialized(ServletContextEvent sce) {

		ServletContext context = sce.getServletContext();

		Properties properties = new Properties();

		try (InputStream input = LoadConfig.class.getClassLoader().getResourceAsStream("db.properties")) {

			if (input == null) {

				System.out.println("sorry not input found");

				return;

			}

			properties.load(input);

			System.out.println(" DB URL: " + properties.getProperty("jdbc_url"));

			System.out.println(" DB User: " + properties.getProperty("jdbc_user"));

			System.out.println(" DB Password: " + properties.getProperty("jdbc_password"));

			System.out.println(" DB Driver: " + properties.getProperty("jdbc_driver"));

			context.setAttribute("jdbc_url", properties.getProperty("jdbc_url"));

			context.setAttribute("jdbc_user", properties.getProperty("jdbc_user"));

			context.setAttribute("jdbc_password", properties.getProperty("jdbc_password"));

			context.setAttribute("jdbc_driver", properties.getProperty("jdbc_driver"));

			System.out.println("Database configuration loadede");

			try {

				Class.forName((String) context.getAttribute("jdbc_driver"));

				System.out.println("JDBC driver loaded");

			} catch (ClassNotFoundException e) {

				System.err.println(" Error loading JDBC driver: " + e.getMessage());

			}

			EmployeeDAOImpl dao = new EmployeeDAOImpl(context);

			context.setAttribute("employeeDAO", dao);

			System.out.println("EmployeeDAO initialized and stored in ServletContext!");

		} catch (IOException e) {

			e.printStackTrace();

		}

//		EmployeeDAOImpl dao = new EmployeeDAOImpl(context);

//		context.setAttribute("emp", dao);

	}

}
