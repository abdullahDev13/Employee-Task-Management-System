package com.etm.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etm.dao.EmployeeDao;
import com.etm.entity.Employee;

@WebServlet("/registerManager")
public class RegisterManager extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String name= req.getParameter("manager-name");
		String email= req.getParameter("manager-email");
		String password= req.getParameter("manager-password");
		String phonenumber= req.getParameter("manager-phonenumber");
		String salary= req.getParameter("manager-salary");
		
		long phonenumberLong= Long.parseLong(phonenumber);
		double salaryDouble= Double.parseDouble(salary);
		
		Employee employee= new Employee();
		
		employee.setEmployeeName(name);
		employee.setEmail(email);
		employee.setPassword(password);
		employee.setPhonenumber(phonenumberLong);
		employee.setSalary(salaryDouble);
		employee.setRole("Manager");
		
		EmployeeDao dao= new EmployeeDao();
		
		dao.saveEmployee(employee);
		
		PrintWriter pw= resp.getWriter();
		pw.print("<h1>MANAGER REGISTERED</h1>");
	}

}
