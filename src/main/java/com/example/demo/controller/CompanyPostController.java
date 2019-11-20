package com.example.demo.controller;

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

import com.example.demo.model.CompanyPost;
import com.example.demo.model.CompanyPostRepository;
import com.example.demo.model.EduPost;
import com.example.demo.model.EduPostRepository;

@Controller
@RequestMapping("/portfolio")
public class CompanyPostController {
	private String user="John";
	
	@Autowired
	private CompanyPostRepository companyPostRepository;
	
	@Autowired
	private EduPostRepository eduPostRepository;
	
	
	
	
    /////DELETE COMPANY POST
    @GetMapping("/delete-company-post")
    public String deleteCompanyPost(@RequestParam("id") Integer id_cp, ModelMap model) {
    	companyPostRepository.deleteById(id_cp);
    	//assertThat(companyPostRepository.count()).isEqualTo(1);
		Iterable<CompanyPost> companyPosts = companyPostRepository.findAll();
		Iterable<EduPost> eduPosts = eduPostRepository.findAll();
		model.addAttribute("companyPostList",companyPosts);
		model.addAttribute("eduPostList",eduPosts);
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
		Iterable<EduPost> eduPosts = eduPostRepository.findAll();
		model.addAttribute("companyPostList",companyPosts);
		model.addAttribute("eduPostList",eduPosts);
    	
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
		Iterable<EduPost> eduPosts = eduPostRepository.findAll();
		model.addAttribute("companyPostList",companyPosts);
		model.addAttribute("eduPostList",eduPosts);
		   
    	
    	return "main";	
    }

}
