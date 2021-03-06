package com.code.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

@Entity
@Table(name="COURSE_1")
public class Course {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="COURSE_ID")
	protected int courseId;
	@Column(name="COURSE_NAME")
	protected String name;
	
//	@OneToMany(mappedBy="course")		//with mappedBy and without cascadeType 
//	@JoinColumn(name="SUBJECT_ID")		//can't be used with OneToMany('mappedBy') attribute
	
	@OneToMany(cascade=CascadeType.ALL)
//	@JoinTable(name="C_S_Table", joinColumns= {@JoinColumn(name="COURSE_ID" )}, inverseJoinColumns= {@JoinColumn(name= "SUBJECT_ID")} )
	@OrderColumn(name="C_S_INDEX")		//on-behalf of list-index (from jpa)
	protected List<Subject> subjects;
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Subject> getSubjects() {
		return subjects;
	}
	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}
}
