package com.etm.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.etm.entity.Employee;

public class EmployeeDao {
	
	EntityManagerFactory factory= Persistence.createEntityManagerFactory("project");
	
	EntityManager manager= factory.createEntityManager();
	
	EntityTransaction transaction= manager.getTransaction();
	
	public Employee saveEmployee(Employee employee)
	{
		transaction.begin();
		manager.persist(employee);
		transaction.commit();
		return employee;
	}
	
	public Employee updateEmployee(Employee employee)
	{
		transaction.begin();
		manager.merge(employee);
		transaction.commit();
		return employee;
	}
	
	public Employee deleteEmployee(Employee employee)
	{
		transaction.begin();
		manager.remove(employee);
		transaction.commit();
		return employee;
	}
	
	public Employee findEmployeeById(int employeeId)
	{
		return manager.find(Employee.class, employeeId);
	}
	
	public List<Employee> fetchAllEmployee()
	{
	    Query query= manager.createQuery("select employee from Employee employee");
	    
	    List<Employee> employeeList= query.getResultList();
	    
	    if(employeeList.size()>0)
	    {
	    	return employeeList;
	    }
	    return null;
	}
	
	public Employee findEmployeebyEmailAndPassword(String email, String password)
	{
		Query query= manager.createQuery("select employee from Employee employee where employee.email= ?1 and employee.password= ?2");
		
		query.setParameter(1, email);
		query.setParameter(2, password);
		
		List<Employee> employeeList= query.getResultList();
		
		if(employeeList.size()>0)
		{
			return employeeList.get(0);
		}
		return null;
	}

}
