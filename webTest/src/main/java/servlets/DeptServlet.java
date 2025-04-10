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
