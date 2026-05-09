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

@WebServlet("/updatePassword")
public class UpdatePassword extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		int Id= Integer.parseInt(req.getParameter("employee-id"));
		String password= req.getParameter("employee-password");
		
		EmployeeDao employeeDao= new EmployeeDao();
		Employee employee= employeeDao.findEmployeeById(Id);
		
		PrintWriter pw= resp.getWriter();
		
		if(employee != null)
		{
		  employee.setPassword(password);
		  employeeDao.updateEmployee(employee);
	      	
		  pw.print("<h1>PASSWORD UPDATED</h1>");
		}
		else
		{
			pw.print("<h1>INVALID EMPLOYEEID</h1>");
		}
		
	}

}
