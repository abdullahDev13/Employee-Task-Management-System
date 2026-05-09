package com.etm.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.etm.dao.EmployeeDao;
import com.etm.entity.Employee;

@WebServlet("/loginEmployee")
public class LoginEmployee extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String email= req.getParameter("employee-email");
		String password= req.getParameter("employee-password");
		
		EmployeeDao dao= new EmployeeDao();
		Employee dbEmployee= dao.findEmployeebyEmailAndPassword(email, password);
		
		PrintWriter pw= resp.getWriter();
		
		if(dbEmployee != null)
		{
			pw.print("<h1>LOGIN SUCCESS</h1>");
			String role= dbEmployee.getRole();
			
			if(role.equals("Manager"))
			{
				RequestDispatcher rd= req.getRequestDispatcher("manager.html");
				rd.forward(req, resp);
			}
			else if(role.equals("Developer"))
			{
				int employeeId= dbEmployee.getEmployeeId();
				
				HttpSession session= req.getSession();
				session.setAttribute("employeeId", employeeId);
				
				RequestDispatcher rd= req.getRequestDispatcher("developer.html");
				rd.forward(req, resp);
			}
		}
		else
		{
			pw.print("<h1>LOGIN FAILED</h1>");
		}
	}
	
	

}
