package com.example.demo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import antlr.collections.List;


public interface CompanyPostRepository  extends CrudRepository<CompanyPost,Integer>{
	
//	  @Query("select * from company_post cp where cp.user_id = ?1")
//	  Iterable<CompanyPost> findByUserId(String user_id);

}
