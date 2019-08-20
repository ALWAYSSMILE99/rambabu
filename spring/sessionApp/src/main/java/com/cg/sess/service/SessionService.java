package com.cg.sess.service;

import java.util.List;

import com.cg.sess.bean.Sessionn;

public interface SessionService {

	public List<Sessionn> getAllSessions();
	public Sessionn getSessionById(int id);
	public void addSession(Sessionn sess);
	public void deleteSession(int id);
    List<Sessionn> updateSession(int id,Sessionn sess);
}
