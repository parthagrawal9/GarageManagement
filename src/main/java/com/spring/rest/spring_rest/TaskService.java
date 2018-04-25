package com.spring.rest.spring_rest;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class TaskService {

	@PersistenceContext
	EntityManager em;
	
	public List<Task> getallTasks() {
		TypedQuery<Task> query = em.createNamedQuery(Task.FIND_ALL_TASKS, Task.class);
		List<Task> results = query.getResultList();
		return results;
	}

	public Task getTask(String id) {
		return em.find(Task.class, id);
	}

	@Transactional
	public void deleteTask(String id) {
		em.remove(em.find(Task.class, id));
	}

	@Transactional
	public void addTask(Task t) {
		em.persist(t);
	}

	@Transactional
	public void updateTask(Task t) {
		em.merge(t);
	}
}
