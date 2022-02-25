package com.TaskIt.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TaskIt.model.Task;

public interface TaskDAO extends JpaRepository<Task, Integer>  {

}
