package com.cg.sess.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.sess.bean.Sessionn;
@Repository
public interface SessionDao extends JpaRepository<Sessionn,Integer> {

	
	
}
