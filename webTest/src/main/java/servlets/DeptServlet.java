package servlets;

import java.io.IOException;

import java.util.List;

import dao.Employee;

import dao.EmployeeDAO;

import dao.EmployeeDAOImpl;

import jakarta.servlet.ServletConfig;

import jakarta.servlet.ServletContext;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;

import jakarta.servlet.http.Cookie;

import jakarta.servlet.http.HttpServlet;

import jakarta.servlet.http.HttpServletRequest;

import jakarta.servlet.http.HttpServletResponse;

import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/depts")

public class DeptServlet extends HttpServlet {

	private DeptDAO deptDAO;

	private EmployeeDAO dao;

	@Override

	public void init(ServletConfig config) throws ServletException {

	    super.init(config);

	    ServletContext context = config.getServletContext();

	    deptDAO = new DeptDAOImpl(context);  

	    dao = (EmployeeDAO) context.getAttribute("employeeDAO");

	    if (dao == null) {

	        throw new IllegalStateException("Error: EmployeeDAO was not initialized properly!");

	    }

	    context.setAttribute("deptDAO", deptDAO);

	}

	@Override

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {




		String operation = req.getParameter("operation");

	    HttpSession session = req.getSession();

	    Dept currentDept = (Dept) session.getAttribute("currentDept");

	    if (currentDept == null) {

	        currentDept = deptDAO.first();

	    }
 
	    if ("First".equals(operation)) {

	        currentDept = deptDAO.first();

	    } else if ("Last".equals(operation)) {

	        currentDept = deptDAO.last();  

	    } else if ("Previous".equals(operation)) {

	        currentDept = deptDAO.previous(currentDept.getId());

	    } else if ("Next".equals(operation)) {

	        currentDept = deptDAO.next(currentDept.getId());

	    }
 
	    if (currentDept == null) {

	        throw new RuntimeException("Error: No department found for the selected operation!");

	    }
 
	    List<Employee> employees = deptDAO.getEmployeesByDeptId(currentDept.getId());
 
	  

	    session.setAttribute("currentDept", currentDept);

	    req.setAttribute("dept", currentDept);

	    req.setAttribute("employees", employees);
 
	    req.getRequestDispatcher("depts.jsp").forward(req, resp);

	}
 
	

	@Override

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



		HttpSession session = req.getSession();

	    Dept currentDept = (Dept) session.getAttribute("currentDept");

	    if (currentDept == null) {

	        currentDept = deptDAO.first(); 

	        if (currentDept == null) {

	            throw new RuntimeException(" Error: No departments found in the database!");

	        }

	    }
 
	    List<Employee> employees = deptDAO.getEmployeesByDeptId(currentDept.getId());

	    session.setAttribute("currentDept", currentDept);

	    req.setAttribute("dept", currentDept);

	    req.setAttribute("employees", employees);
 
	    req.getRequestDispatcher("depts.jsp").forward(req, resp);

	}
 
}

 































//package servlets;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Set;
//
//import dao.Employee;
//import dao.EmployeeDAO;
//import dao.EmployeeDAOImpl;
//import jakarta.servlet.ServletConfig;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.Cookie;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
//
//@WebServlet(urlPatterns = "/depts")
//public class DeptServlet extends HttpServlet {
//	
//	private DeptDAO deptDAO;
//	private EmployeeDAO dao;
//	
//	@Override
//	public void init(ServletConfig config) throws ServletException {
//		deptDAO = new DeptDAOImpl();
//		dao = new EmployeeDAOImpl();
//		deptDAO.save(new Dept(1,"HR","Blr"));
//		deptDAO.save(new Dept(2,"HR","Ahm"));
//		deptDAO.save(new Dept(3,"Dev","Blr"));
//		deptDAO.save(new Dept(4,"Dev","Ahm"));
//		
//		
//	}
//	
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String operation = req.getParameter("operation");
//		HttpSession session = req.getSession();
//		Dept current = (Dept) session.getAttribute("current");
//		
//		if(current == null) {
//			current = deptDAO.first();
//		
//		} else {
//			if("First".equals(operation)) {
//				current = deptDAO.first();
//			} else if("Last".equals(operation)) {
//				current = deptDAO.first();
//			
//			}else {
//				current = deptDAO.next(current.getId());
//		    }
//		}
//		session.setAttribute("current", current);
//		//Expressions in JSP can work with objects in session also...
//		req.setAttribute("dept", current);
//		
//		
//		Cookie [] cookies = req.getCookies();
//		for(int i =0;i<cookies.length;i++) {
//				System.out.println(cookies[i].getName()+" "+cookies[i].getValue());
//		}
//		resp.addCookie(new Cookie("operation",operation));
//		req.getRequestDispatcher("depts.jsp").forward(req, resp);
//
//	}
//	
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//	
//		String operation = req.getParameter("operation");
//		
//		if("sort".equals(operation)) {
//			HttpSession session = req.getSession();
//			String column = req.getParameter("column");
//			String currentOrder = (String) session.getAttribute("sortOrder");
//			String currentColumn = (String) session.getAttribute("currentColumn");
//			
//			String order = "ASC" ;
//			if(column.equals(currentColumn)) {
//				order = "DESC".equals(currentOrder) ? "ASC" : "DESC" ;
//			}
//			session.setAttribute("currentColumn", column);
//			session.setAttribute("currentOrder", order);
//			
//			List<Employee> emps = dao.sortEmployees(column, order); 
//			req.setAttribute("emps", emps);
//			
//		} else {
//			List<Employee> emps = dao.getAll();
//	        req.setAttribute("emps", emps);
//				
//		}
//			HttpSession session = req.getSession();
//			Dept currentDept = deptDAO.first();
//			req.setAttribute("dept", deptDAO.first());
//			session.setAttribute("current", deptDAO.first());
//			
//			req.getRequestDispatcher("depts.jsp").forward(req, resp);
//		
//	
//	}
//}
//
//
