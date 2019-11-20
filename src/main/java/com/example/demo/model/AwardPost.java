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
public class AwardPost {
	@Id
	private int id_ap;
	
	@Column(name="user_id")
	private String user_id;
	
	@Column(name = "award_intuition")
	private String award_intuition;
	
	@Column(name = "award_host")
	private String award_host;
	
	@Column(name = "start_date_ap")
	private Date start_date_ap;
	
	@Column(name = "end_date_ap")
	private Date end_date_ap;
	
	@Column(name = "title_ap")
	private String title_ap;
	
	@Column(name = "content_ap")
	private String content_ap;
	
	@Column(name = "hide_ap")
	private boolean hide_ap;
}
