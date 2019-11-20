package com.example.demo.controller;

import java.util.Optional;

import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.*;

import antlr.collections.List;

@Controller
@RequestMapping("/portfolio")
public class MainController {
	private String user="John";
	
	@Autowired
	private CompanyPostRepository companyPostRepository;
	
	@Autowired
	private EduPostRepository eduPostRepository;
	
	////MAIN
	@RequestMapping("/main")
	   public String mainPage(Model model) {
		   Iterable<CompanyPost> companyPosts = companyPostRepository.findAll();
		   Iterable<EduPost> eduPosts = eduPostRepository.findAll();
//		   Iterable<CompanyPost> myCompanyPost = companyPostRepository.findByUserId(user);
		   model.addAttribute("companyPostList",companyPosts);
		   model.addAttribute("eduPostList",eduPosts);
		   return "main";
	   }


}
