package com.cg.sess.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.sess.bean.Sessionn;
import com.cg.sess.service.SessionService;

@RestController
public class SessionController {

	@Autowired
	SessionService sessionService;
	@RequestMapping("/sessions")
	public List<Sessionn> getAllSessions()
	{
		return sessionService.getAllSessions();
	}
	
	@RequestMapping("/sessions/{id}")
	public Sessionn getSessionById(@PathVariable int id)
	{
		return sessionService.getSessionById(id);
	}
	
	@RequestMapping(value="/addsession",method=RequestMethod.POST)
	public ResponseEntity<String> addSession(@RequestBody Sessionn sess)
	{
		sessionService.addSession(sess);
		return new ResponseEntity<String>("Data added",HttpStatus.OK);
	}
	
	@RequestMapping(value="/deletesession/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<String> deleteSession(@PathVariable int id)
	{
		sessionService.deleteSession(id);
		return new ResponseEntity<String>("data with id "+id+" deleted",HttpStatus.OK);
	}
	
	@RequestMapping(value="/updatesession/{id}", method=RequestMethod.PUT)
	public List<Sessionn> updateSession(@PathVariable int id,Sessionn sess)
	{
		return sessionService.updateSession(id, sess);
		 
		//return new ResponseEntity<String>("Data updated",HttpStatus.OK);
	}
	
	
	
}
