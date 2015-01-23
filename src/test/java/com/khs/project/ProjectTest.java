package com.khs.project;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import com.khs.config.AppTestConfig;
import com.khs.model.Project;
import com.khs.service.ProjectService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppTestConfig.class, loader = AnnotationConfigContextLoader.class)
public class ProjectTest {

	@Autowired
	ProjectService projectService;
	
	
	@Test
	public void createProject() {
		projectService.create("SPA-JavaScript");
		TestCase.assertNotNull(projectService.findByName("SPA-JavaScript"));

	}
	
	@Test
	public void totalManhours() {
		
		Project proj = projectService.create("Data Wharehouse");
		proj.setHours(1000.00f);
		projectService.save(proj);
		
		proj = projectService.create("Big Data");
		proj.setHours(2000.00f);
		projectService.save(proj);
		
		TestCase.assertTrue(projectService.totalManhours() == 3000.00f);		
		
	}
	
	
	
	
	

}
