package com.khs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.khs.model.Project;
import com.khs.service.ProjectService;

@Controller
@RequestMapping( value = "/foos" )
class ProjectController{
 
   @Autowired
   ProjectService service;
 
   
   @RequestMapping(value ="/name", method = RequestMethod.GET )
   @ResponseBody
   public Project findByName(){
       
	   Project proj = new Project();
	   proj.setName("foo");
	   proj.setHours(100.00f);
	   
	   return proj;
   }
   
   
   @RequestMapping(method = RequestMethod.GET )
   @ResponseBody
   public List<Project> findAll(){
      return service.findAll();
   }
 
   @RequestMapping( value = "/{id}", method = RequestMethod.GET )
   @ResponseBody
   public Project findOne( @PathVariable( "id" ) Long id ){
      return  service.findById( id );
   }
 
   @RequestMapping( method = RequestMethod.POST )
   @ResponseStatus( HttpStatus.CREATED )
   @ResponseBody
   public Project create( @RequestBody Project project ){
      return service.insert(project);
   }
 
   @RequestMapping( value = "/{id}", method = RequestMethod.PUT )
   @ResponseStatus( HttpStatus.OK )
   public void update( @PathVariable( "id" ) Long id, @RequestBody Project project ){
     
      service.findById( project.getId() );
      service.save(project );
   }
 
   @RequestMapping( value = "/{id}", method = RequestMethod.DELETE )
   @ResponseStatus( HttpStatus.OK )
   public void delete( @PathVariable( "id" ) Long id ){
      service.delete( id );
   }
 
}