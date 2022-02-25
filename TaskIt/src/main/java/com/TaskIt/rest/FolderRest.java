package com.TaskIt.rest;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TaskIt.dao.FolderDAO;
import com.TaskIt.model.Folder;
import com.TaskIt.model.Task;

@RestController
@RequestMapping("folder")
public class FolderRest {
	
	@Autowired 
	private FolderDAO FolderDAO;
	
	
	@GetMapping("/selectFolder/{id}")
	public Folder selectFolder(@PathVariable("id") Integer id){
		
		return FolderDAO.getReferenceById(id);
	
	}
	
	@GetMapping("/allFolders")
	public List<Folder> allFolders(){
		return FolderDAO.findAll();
	
	}
	
	@GetMapping("/allTasksInFolder/{id}")
	public List<Task> allTasksInFolder(@PathVariable("id") Integer id){
		
		return FolderDAO.getReferenceById(id).getTasks();
	
	}
	
	@PostMapping("/createFolder")
	public void createFolder(@RequestBody Folder folder) {
		
		List<Task> list = null;

		folder.setTasks(list);
		
		FolderDAO.save(folder);
	
	}
	
	@PutMapping("/editFolder")
	public void editFolder(@RequestBody Folder folder) {
		Folder folder2 = FolderDAO.getReferenceById(folder.getFolderId());
		
		if(folder.getName() != null) {
			folder2.setName(folder.getName());
		}
		
		FolderDAO.save(folder2);
	}
	
	@DeleteMapping("/deleteFolder/{id}")
	public void deleteFolder(@PathVariable("id") Integer id) {
		
		FolderDAO.deleteById(id);
	
	}

}
