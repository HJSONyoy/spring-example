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

import com.example.demo.CompanyPost;
import com.example.demo.CompanyPostRepository;

import antlr.collections.List;

@Controller
@RequestMapping("/portfolio")
public class MainController {
	private String user="John";
	
	@Autowired
	private CompanyPostRepository companyPostRepository;
	

	
	////MAIN
	@RequestMapping("/main")
	   public String mainPage(Model model) {
		   Iterable<CompanyPost> companyPosts = companyPostRepository.findAll();
//		   Iterable<CompanyPost> myCompanyPost = companyPostRepository.findByUserId(user);
		   model.addAttribute("companyPostList",companyPosts);
		   return "main";
	   }
	   
	
	
	
	    /////DELETE COMPANY POST
	    @GetMapping("/delete-company-post")
	    public String deleteCompanyPost(@RequestParam("id") Integer id_cp, ModelMap model) {
	    	companyPostRepository.deleteById(id_cp);
	    	//assertThat(companyPostRepository.count()).isEqualTo(1);
	    	Iterable<CompanyPost> companyPosts = companyPostRepository.findAll();
	    	model.addAttribute("companyPostList",companyPosts);
	        return "main";
	    }
	    
	    
	    ///EDIT COMPANY POST
	    @GetMapping("/edit-company-post")
	    public String editCompanyPost(@RequestParam("id") Integer id_cp, ModelMap model) {
	    	System.out.println(id_cp);
	    	CompanyPost selected_post = companyPostRepository.findById(id_cp).get();
	    	model.addAttribute("selectedPost",selected_post);
	    	//assertThat(companyPostRepository.count()).isEqualTo(1);
	    	//Iterable<CompanyPost> companyPosts = companyPostRepository.findAll();
	    	//model.addAttribute("companyPostList",companyPosts);
	        return "edit-company-post";
	    } 
	    
	    @PostMapping("/edit-company-post")
	    public String editNewCompanyPost(@ModelAttribute("companyPost") CompanyPost editCompanyPost,BindingResult result,ModelMap model) {
	    	if (result.hasErrors()) {
	            return "error";
	        }
	    	
	    	
	    	CompanyPost post = companyPostRepository.findById(editCompanyPost.getId_cp()).get();
	    	post.setCompany(editCompanyPost.getCompany());
	    	post.setDepartment(editCompanyPost.getDepartment());
	    	post.setPart(editCompanyPost.getPart());
	    	post.setTitle(editCompanyPost.getTitle());
	    	post.setContent(editCompanyPost.getContent());
	    	post.setStart_date_cp(editCompanyPost.getStart_date_cp());
	    	post.setEnd_date_cp(editCompanyPost.getEnd_date_cp());
	    	companyPostRepository.save(post);
	    	
	    	
	    	Iterable<CompanyPost> companyPosts = companyPostRepository.findAll();
	    	model.addAttribute("companyPostList",companyPosts);
	    	
	    	return "main";	
	    }

	   
	    
	    ///CREATE COMPANY POST
	    @GetMapping("/create-company-post")
	    public String createompanyPost(Model model) {
	        return "create-company-post";
	    }
	    
	    @PostMapping("/create-company-post")
	    public String createNewCompanyPost(@ModelAttribute("companyPost") CompanyPost newCompanyPost,BindingResult result,ModelMap model) {
	    	if (result.hasErrors()) {
	            return "error";
	        }


	    	CompanyPost post = new CompanyPost();
	    	post = newCompanyPost;
	    	post.setUser_id(user);
	    	companyPostRepository.save(post);
	    	
	    	
	    	Iterable<CompanyPost> companyPosts = companyPostRepository.findAll();
	    	model.addAttribute("companyPostList",companyPosts);
	    	
	    	return "main";	
	    }



}
