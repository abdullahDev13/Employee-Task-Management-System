package com.etm.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etm.dao.EmployeeDao;
import com.etm.dao.TaskDao;
import com.etm.entity.Employee;
import com.etm.entity.Status;
import com.etm.entity.Task;

@WebServlet("/assignTask")
public class AssignTask extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		int developerId= Integer.parseInt(req.getParameter("developer-id")) ;
		int taskId= Integer.parseInt(req.getParameter("task-id")) ;
		
		EmployeeDao employeedao= new EmployeeDao();
		Employee dbEmployee= employeedao.findEmployeeById(developerId);
		
		TaskDao taskDao= new TaskDao();
		Task dbTask= taskDao.findTaskById(taskId);
		
		List<Task> taskList= dbEmployee.getTaskList();
		
		if(taskList==null)
		{
			taskList= new ArrayList<Task>();
		}
		dbTask.setStatus(Status.ASSIGNED);
		taskDao.updateTask(dbTask);
		
		taskList.add(dbTask);
		dbEmployee.setTaskList(taskList);
		employeedao.updateEmployee(dbEmployee);
		
		PrintWriter pw= resp.getWriter();
		pw.print("<h1>TASK ASSIGNED</h1>");
		
	}

}
