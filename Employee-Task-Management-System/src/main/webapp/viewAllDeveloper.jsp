<%@page import="java.io.PrintWriter"%>
<%@page import="com.etm.entity.Task"%>
<%@page import="com.etm.entity.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%

List<Employee> employeeList= (List<Employee>)request.getAttribute("data");

for(Employee emp: employeeList)
{
	String role= emp.getRole();
	if(role.equals("Developer"))
	{	
      out.print(emp.getEmployeeId()+" "+emp.getEmployeeName()+" "+emp.getEmail()+" "+emp.getPassword()+" "+emp.getPhonenumber()+" "+emp.getRole()+" "+emp.getSalary()+"<br>");
	}
	
	List<Task> task =emp.getTaskList();
	if(task != null)
	{
		for(Task t : task)
		{
			out.print(t.getTaskName()+"<br>");
		}
	}
	else
	{
		out.print("TASK NOT ASSIGNED"+"<br>");
	}
}

%>

</body>
</html>