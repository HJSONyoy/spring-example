package com.example.demo.model;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import antlr.collections.List;

public interface EduPostRepository extends CrudRepository<EduPost,Integer>{

}
