<%@page import="com.etm.entity.Task"%>
<%@page import="java.util.List"%>
<%@page import="com.etm.entity.Employee"%>
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

Employee dbEmployee= (Employee)request.getAttribute("dbEmployee");

List<Task> task= dbEmployee.getTaskList();

if(task != null && !task.isEmpty())
{
   for(Task t : task)
   {
	   out.print(t.getTaskId()+" "+t.getTaskName()+" "+t.getDays()+" "+t.getStatus());
   }
}
else
{
   out.print("NO TASK ASSIGNED");	
}

%>

</body>
</html>