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

@WebServlet("/deleteDeveloper")
public class DeleteDeveloper extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		int developerId= Integer.parseInt(req.getParameter("developer-id"));
		
		EmployeeDao employeeDao= new EmployeeDao();
		Employee dbEmployee= employeeDao.findEmployeeById(developerId);
		
		PrintWriter pw= resp.getWriter();
		
		if(dbEmployee != null)
		{
		  employeeDao.deleteEmployee(dbEmployee);
		  pw.print("<h1>DEVELOPER DELETED</h1>");
		}
		else
		{
		  pw.print("<h1>DEVELOPER ID NOT FOUND</h1>");
		}
	}

}
