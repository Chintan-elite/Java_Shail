package com;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="teacher")
public class Teacher {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="tid")
	int tid;
	@Column(name="name")
	String name;
	
	@ManyToMany
	@JoinTable(
			
			name="teacher_student",
			joinColumns = @JoinColumn(name="tid"),
			inverseJoinColumns = @JoinColumn(name="sid")
			)
	List<Subject> subjects;

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
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
	
	public void addSubject(Subject sub)
	{
		if(subjects==null)
		{
			subjects = new ArrayList<Subject>();
		}
		subjects.add(sub);
	}
}
