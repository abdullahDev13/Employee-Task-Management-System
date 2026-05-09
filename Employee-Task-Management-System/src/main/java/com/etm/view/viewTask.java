package com.etm.view;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.etm.dao.EmployeeDao;
import com.etm.entity.Employee;

@WebServlet("/viewTask")
public class viewTask extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		HttpSession session= req.getSession();
		int employeeId= (Integer)session.getAttribute("employeeId");
		
		EmployeeDao employeeDao= new EmployeeDao();
		Employee dbEmployee= employeeDao.findEmployeeById(employeeId);
		
		if(dbEmployee != null)
		{
			req.setAttribute("dbEmployee", dbEmployee);
			RequestDispatcher rd= req.getRequestDispatcher("viewTask.jsp");
			rd.forward(req, resp);
		}
	}

}
