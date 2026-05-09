package com.etm.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.etm.dao.EmployeeDao;
import com.etm.dao.TaskDao;
import com.etm.entity.Employee;
import com.etm.entity.Status;
import com.etm.entity.Task;

@WebServlet("/changeTaskStatus")
public class ChangeTaskStatus extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
	    HttpSession session= req.getSession();
	    int employeeId= (int)session.getAttribute("employeeId");
	    
	    EmployeeDao employeeDao= new EmployeeDao();
	    Employee dbEmployee= employeeDao.findEmployeeById(employeeId);
	    
	    List<Task> taskList= dbEmployee.getTaskList();
	    
	    Task task= taskList.get(0);
	    
	    int taskId= task.getTaskId();
	    
	    TaskDao taskDao= new TaskDao();
		Task dbTask= taskDao.findTaskById(taskId);
		
		PrintWriter pw= resp.getWriter();
		
		if(dbTask != null)
		{
		  dbTask.setStatus(Status.COMPLETED);
		  taskDao.updateTask(dbTask);
		  pw.print("<h1>TASK COMPLETED</h1>");
		}
		else
		{
			pw.print("<h1>INAVALID TASKID</h1>");
		}
		
	}

}
