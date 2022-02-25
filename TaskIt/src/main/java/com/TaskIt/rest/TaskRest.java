package com.TaskIt.rest;

import java.util.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.TaskIt.dao.TaskDAO;
import com.TaskIt.dao.FolderDAO;
import com.TaskIt.model.Folder;
import com.TaskIt.model.Task;


@RestController
@RequestMapping("task")
public class TaskRest {
	
	@Autowired 
	private TaskDAO TaskDAO;
	
	@Autowired
	private FolderDAO FolderDAO;
	
	@GetMapping("/selectTask/{id}")
	public Task selectTask(@PathVariable("id") Integer id) {
		return TaskDAO.getReferenceById(id);
	}
	
	@GetMapping("/allTasks")
	public List<Task> allTasks(){
		return TaskDAO.findAll();
	}
	
	@PostMapping("/createTask/{folder_id}")
	public void create( @PathVariable("folder_id") Integer folderId, @RequestBody Task task) {
		Folder folder = FolderDAO.getReferenceById(folderId);
		task.setFolder(folder);
		folder.getTasks().add(task);

		TaskDAO.save(task);
		FolderDAO.save(folder);
	}
	
	@PutMapping("/editTask")
	public void editDescription(@RequestBody Task task){
		
		Task task2 = TaskDAO.getReferenceById(task.getTaskId());
		
		if(task2.getDescription() != null)
			task2.setDescription(task.getDescription());
		
		if(task.isDone() != false) 
			task2.setDone(true);
		
		TaskDAO.save(task2);
	}
	
	@PutMapping("/changeFolder/{id}")
	public void changeFolder(@PathVariable("id") Integer task_id, @RequestBody Integer folder_id) {
		
		Task task = TaskDAO.getReferenceById(task_id);
		Folder oldFolder = FolderDAO.getReferenceById(task.getFolder().getFolderId());
		
		oldFolder.getTasks().remove(task);
		task.setFolder(FolderDAO.getReferenceById(folder_id));
		
		TaskDAO.save(task);
		FolderDAO.save(oldFolder);
	}
	
	@DeleteMapping("/deleteTask/{id}")
	public void deleteTask(@PathVariable("id") Integer id) {
		
		TaskDAO.deleteById(id);
		
	}
}
