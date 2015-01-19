package com.khs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.khs.model.Project;

public interface ProjectRepository extends JpaRepository<Project,Long> {

	Project findByName(String name);

	
}
