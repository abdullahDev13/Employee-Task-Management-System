package com.etm.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.etm.entity.Task;

public class TaskDao {
	
    EntityManagerFactory factory= Persistence.createEntityManagerFactory("project");
	
	EntityManager manager= factory.createEntityManager();
	
	EntityTransaction transaction= manager.getTransaction();
	
	public Task saveTask(Task task)
	{
		transaction.begin();
		manager.persist(task);
		transaction.commit();
		return task;
	}
	
	public Task updateTask(Task task)
	{
		transaction.begin();
		manager.merge(task);
		transaction.commit();
		return task;
	}
	
	public Task deleteTask(Task task)
	{
		transaction.begin();
		manager.remove(task);
		transaction.commit();
		return task;
	}
	
	public Task findTaskById(int taskId)
	{
		return manager.find(Task.class, taskId);
	}
	
	public List<Task> fetchAllTask()
	{
		Query query= manager.createQuery("select task from Task task");
		
		List<Task> taskList= query.getResultList();
		
		if(taskList.size()>0)
		{
			return taskList;
		}
		return null;
	}

}
