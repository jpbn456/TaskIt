package com.TaskIt.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TaskIt.model.Folder;

public interface FolderDAO extends JpaRepository<Folder, Integer> {

}
