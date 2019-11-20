package com.example.demo.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class EduPost {
	@Id
	private int id_ep;
	
	@Column(name="user_id")
	private String user_id;
	
	@Column(name = "edu_intuition")
	private String edu_intuition;
	
	@Column(name = "edu_host")
	private String edu_host;
	
	@Column(name = "start_date_ep")
	private Date start_date_ep;
	
	@Column(name = "end_date_ep")
	private Date end_date_ep;

	@Column(name = "location_ep")
	private String location_ep;
	
	@Column(name = "title_ep")
	private String title_ep;
	
	@Column(name = "content_ep")
	private String content_ep;
	
	@Column(name = "hide_cp")
	private boolean hide_cp;

}
