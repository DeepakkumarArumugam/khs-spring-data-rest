package com.khs.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.khs.model.Project;
import com.khs.repository.ProjectRepository;

@Service
public class ProjectService {

	@Resource
	private ProjectRepository repository;

	public List<Project> findAll() {
		return repository.findAll();
	}
	
	public Project findById(Long id) {
		return repository.findOne(id);
	}
	
	public Project findByName(String name) {

		return repository.findByName(name);
	}
	
	public Project insert(Project project) {
		return repository.save(project);
	}
	
		
	public Project create(String name) {

		Project project = new Project();
		project.setName(name);
		repository.save(project);

		return project;
	}

	public void delete(long id) {
		Project project = this.findById(id);
		repository.delete(project);
	}

	public Project save(Project project) {

		return repository.save(project);

	}

	public double totalManhours() {

		List<Project> projects = repository.findAll();
		double total = 0.0;

		for (Project p : projects) {
			total += p.getHours();
		}

		return total;
	}

}
