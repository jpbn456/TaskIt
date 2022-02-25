package com.TaskIt.model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;



@Entity 
public class Folder {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "folder_id", updatable = false, nullable = false)
	private Integer folder_id;

	@Column(nullable = false)
	private String name;
	
	@OneToMany(mappedBy="folder",cascade = CascadeType.ALL,orphanRemoval = true, fetch = FetchType.LAZY)
	@JsonManagedReference
	private List<Task> tasks = new ArrayList<>();


	public Integer getFolderId() {
		return folder_id;
	}

	public void setFolderId(Integer folderId) {
		this.folder_id = folderId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
	
	
	
	
}
