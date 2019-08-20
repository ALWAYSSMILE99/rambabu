package com.cg.sess.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

@Entity
public class Sessionn {

	@Id
	@GeneratedValue
	private int id;
	private String name;
	@Min(1)
	@Max(5)
	private int duration;
	private String faculty;
	@Pattern(regexp="(Day|Night)")
	private String model;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public String getFaculty() {
		return faculty;
	}
	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	@Override
	public String toString() {
		return "Session [id=" + id + ", name=" + name + ", duration=" + duration + ", faculty=" + faculty + ", model="
				+ model + "]";
	}
	
	
}
