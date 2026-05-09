package com.etm.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etm.dao.TaskDao;
import com.etm.entity.Status;
import com.etm.entity.Task;

@WebServlet("/createTask")
public class CreateTask extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String taskname= req.getParameter("task-name");
		String duration= req.getParameter("task-days");
		
		int durationInt= Integer.parseInt(duration);
		
		Task task= new Task();
		task.setTaskName(taskname);
		task.setDays(durationInt);
		task.setStatus(Status.CEREATED);
		
		TaskDao dao= new TaskDao();
		dao.saveTask(task);
		
		PrintWriter pw= resp.getWriter();
		pw.print("<h1>TASK CREATED</h1>");
	}

}
