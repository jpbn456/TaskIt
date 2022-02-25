package com.TaskIt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Task {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id", updatable = false, nullable = false)
	private Integer task_id;
	
	
	@ManyToOne
	@JoinColumn(name = "folder_id")
	@JsonBackReference
    private Folder folder;
	
	
	@Column(nullable = false)
	private String description;
	
	@Column(columnDefinition = "boolean default false")
	private boolean done;

	
	public Integer getTaskId() {
		return task_id;
	}

	public void setTaskId(Integer taskId) {
		this.task_id = taskId;
	}

	public Folder getFolder() {
		return folder;
	}

	public void setFolder(Folder folder) {
		this.folder = folder;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}
	
	

	
}
