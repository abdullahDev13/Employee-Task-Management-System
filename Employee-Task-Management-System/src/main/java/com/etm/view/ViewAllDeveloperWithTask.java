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

import com.etm.dao.EmployeeDao;
import com.etm.entity.Employee;

@WebServlet("/viewAllDeveloper")
public class ViewAllDeveloperWithTask extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		EmployeeDao employeeDao= new EmployeeDao();
		List<Employee> employeeList= employeeDao.fetchAllEmployee();
		
		PrintWriter pw= resp.getWriter();
		
		if(employeeList != null)
		{
			req.setAttribute("data", employeeList);
			RequestDispatcher rd= req.getRequestDispatcher("viewAllDeveloper.jsp");
			rd.forward(req, resp);
		}
		else
		{
			pw.print("<h1>NO DEVELOPER FOUND</h1>");
		}
	}

}
