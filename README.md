# spring-example
spring-example1-portfolio1



TABLE CREATION:

CREATE TABLE company_post(
 user_id VARCHAR(15) NOT NULL,
 id_cp INT(11) NOT NULL AUTO_INCREMENT, 
 company VARCHAR(25) NOT NULL,
 department VARCHAR(25) DEFAULT NULL,
 part VARCHAR(25) DEFAULT NULL,
 start_date_cp DATE, 
 end_date_cp DATE,
 title VARCHAR(35) DEFAULT NULL,
 content TEXT DEFAULT NULL,
 hide_cp BOOLEAN DEFAULT 0,
 PRIMARY KEY(id_cp)
);

CREATE TABLE edu_post(
 user_id VARCHAR(15) NOT NULL,
 id_ep INT(11) NOT NULL AUTO_INCREMENT,
 edu_intuition VARCHAR(25) NOT NULL,
 edu_host VARCHAR(25) NOT NULL,
 start_date_ep DATE,
 end_date_ep DATE,
 location_ep VARCHAR(35),
 title_ep VARCHAR(35),
 content_ep TEXT,
 hide_ep BOOLEAN DEFAULT 0,
 PRIMARY KEY(id_ep)
);


CREATE TABLE award_post(
 user_id VARCHAR(15) NOT NULL,
 id_ap INT(11) NOT NULL AUTO_INCREMENT,
 award_intuition VARCHAR(25) NOT NULL,
 award_host VARCHAR(24), 
 date_ap DATE,
 title_ap VARCHAR(35),
 content_ap TEXT,
 hide_ap BOOLEAN DEFAULT 0,
 PRIMARY KEY(id_ap)
);
