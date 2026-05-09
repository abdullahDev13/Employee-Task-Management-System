package com.etm.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.etm.dao.EmployeeDao;
import com.etm.entity.Employee;

@WebServlet("/update")
public class UpdateDeveloper extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{		
		HttpSession session= req.getSession();
		int employeeId= (int)session.getAttribute("employeeId");
		
		HttpSession session2= req.getSession();
		String option = (String)session2.getAttribute("option");
		
		EmployeeDao employeeDao= new EmployeeDao();
		Employee dbEmployee= employeeDao.findEmployeeById(employeeId);
		
		PrintWriter pw= resp.getWriter();
		
		if(option.equals("NAME"))
		{
		  String name= req.getParameter("developer-name");
		  dbEmployee.setEmployeeName(name);
		  Employee employee= employeeDao.updateEmployee(dbEmployee);
		  pw.print("<h1>DEVELOPER NAME UPDATED</h1>");
		}
		else if(option.equals("EMAIL"))
		{
		      String email= req.getParameter("developer-email");
			  dbEmployee.setEmail(email);
			  Employee employee= employeeDao.updateEmployee(dbEmployee);
			  pw.print("<h1>DEVELOPER EMAIL UPDATED</h1>");
		}
		else if(option.equals("PHONENUMBER"))
		{
			  long phonenumber= Long.parseLong(req.getParameter("developer-phonenumber"));
			  dbEmployee.setPhonenumber(phonenumber);
			  Employee employee= employeeDao.updateEmployee(dbEmployee);
			  pw.print("<h1>DEVELOPER PHONENUMBER UPDATED</h1>");
		}
		
	}

}
