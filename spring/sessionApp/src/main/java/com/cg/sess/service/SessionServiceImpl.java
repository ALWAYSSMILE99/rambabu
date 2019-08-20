package com.cg.sess.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.sess.bean.Sessionn;
import com.cg.sess.dao.SessionDao;

@Service
public class SessionServiceImpl implements SessionService{

	@Autowired
	SessionDao sessionDao;

	@Override
	public List<Sessionn> getAllSessions() {
		
		return sessionDao.findAll();
	}

	@Override
	public Sessionn getSessionById(int id) {
		
		return sessionDao.findById(id).get();
	}

	@Override
	public void addSession(Sessionn sess) {
		sessionDao.save(sess);
	}

	@Override
	public void deleteSession(int id) {
		sessionDao.deleteById(id);
		
	}
	@Override
	public List<Sessionn> updateSession(int id,Sessionn sess)
	{
	Optional<Sessionn> optional=sessionDao.findById(id);
		
		
		Sessionn session=optional.get();
		session.setDuration(sess.getDuration());
		session.setModel(sess.getModel());
		sessionDao.save(session);
		return getAllSessions();
		
	}
	
	
	
	

	
		
	}


