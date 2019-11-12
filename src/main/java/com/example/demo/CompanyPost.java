package com.example.demo;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CompanyPost {
	@Id
	private int id_cp;
	
	@Column(name="user_id")
	private String user_id;
	
	@Column(name = "company")
	private String company;
	
	@Column(name = "department")
	private String department;
	
	@Column(name = "part")
	private String part;
	
	@Column(name = "start_date_cp")
	private Date start_date_cp;
	
	@Column(name = "end_date_cp")
	private Date end_date_cp;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "content")
	private String content;
	
	@Column(name = "hide_cp")
	private boolean hide_cp;
	

}