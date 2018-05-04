package com.spring.rest.spring_rest;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name=Task.FIND_ALL_TASKS,query="select t from Task t")
public class Task {

	protected static final String FIND_ALL_TASKS="find_all_tasks";
	
	@Id
	private String taskId;
	private String taskName;
	private String taskData;
	private int taskStatus;
	private Date taskAdded;
	private Date taskDeadline;
	private int taskPriority;
	
	public Task(){}
	
	public Task(String taskId, String taskName, String taskData, int taskStatus, Date taskAdded, Date taskDeadline,
			int taskPriority) {
		super();
		this.taskId = taskId;
		this.taskName = taskName;
		this.taskData = taskData;
		this.taskStatus = taskStatus;
		this.taskAdded = taskAdded;
		this.taskDeadline = taskDeadline;
		this.taskPriority = taskPriority;
	}
	
	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getTaskId() {
		return taskId;
	}
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	public String getTaskData() {
		return taskData;
	}
	public void setTaskData(String taskData) {
		this.taskData = taskData;
	}
	public int getTaskStatus() {
		return taskStatus;
	}
	public void setTaskStatus(int taskStatus) {
		this.taskStatus = taskStatus;
	}
	public Date getTaskAdded() {
		return taskAdded;
	}
	public void setTaskAdded(Date taskAdded) {
		this.taskAdded = taskAdded;
	}
	public Date getTaskDeadline() {
		return taskDeadline;
	}
	public void setTaskDeadline(Date taskDeadline) {
		this.taskDeadline = taskDeadline;
	}
	public int getTaskPriority() {
		return taskPriority;
	}
	public void setTaskPriority(int taskPriority) {
		this.taskPriority = taskPriority;
	}
}
