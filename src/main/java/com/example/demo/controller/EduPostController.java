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
public class EduPostController {
	private String user="John";
	
	@Autowired
	private CompanyPostRepository companyPostRepository;
	
	@Autowired
	private EduPostRepository eduPostRepository;
	
	
    ///CREATE COMPANY POST
    @GetMapping("/create-edu-post")
    public String createompanyPost(Model model) {
        return "create-edu-post";
    }
    @PostMapping("/create-edu-post")
    public String createNewCompanyPost(@ModelAttribute("eduPost") EduPost newEduPost,BindingResult result,ModelMap model) {
    	if (result.hasErrors()) {
            return "error";
        }


    	EduPost post = new EduPost();
    	post = newEduPost;
    	post.setUser_id(user);
    	eduPostRepository.save(post);
    	
		Iterable<CompanyPost> companyPosts = companyPostRepository.findAll();
		Iterable<EduPost> eduPosts = eduPostRepository.findAll();
		model.addAttribute("companyPostList",companyPosts);
		model.addAttribute("eduPostList",eduPosts);
	 
    	return "main";	
    }
    
    /////DELETE EDU POST
    @GetMapping("/delete-edu-post")
    public String deleteCompanyPost(@RequestParam("id") Integer id_ep, ModelMap model) {
    	eduPostRepository.deleteById(id_ep);
    	//assertThat(companyPostRepository.count()).isEqualTo(1);
		Iterable<CompanyPost> companyPosts = companyPostRepository.findAll();
		Iterable<EduPost> eduPosts = eduPostRepository.findAll();
		model.addAttribute("companyPostList",companyPosts);
		model.addAttribute("eduPostList",eduPosts);
        return "main";
    }
    
    //////EDIT EDU POST    
    @GetMapping("/edit-edu-post")
    public String editCompanyPost(@RequestParam("id") Integer id_ep, ModelMap model) {
    	System.out.println(id_ep);
    	EduPost selected_post = eduPostRepository.findById(id_ep).get();
    	model.addAttribute("selectedPost",selected_post);
        return "edit-edu-post";
    } 
    
    @PostMapping("/edit-edu-post")
    public String editNewCompanyPost(@ModelAttribute("eduPost") EduPost editEduPost,BindingResult result,ModelMap model) {
    	if (result.hasErrors()) {
            return "error";
        }
    	
    	
    	EduPost post = eduPostRepository.findById(editEduPost.getId_ep()).get();
    	post.setEdu_intuition(editEduPost.getEdu_intuition().replaceAll(System.getProperty("line.separator"), ""));
    	post.setEdu_host(editEduPost.getEdu_host().replaceAll(System.getProperty("line.separator"), ""));
    	post.setLocation_ep(editEduPost.getLocation_ep().replaceAll(System.getProperty("line.separator"), ""));
    	post.setTitle_ep(editEduPost.getTitle_ep().replaceAll(System.getProperty("line.separator"), ""));
    	post.setContent_ep(editEduPost.getContent_ep());
    	post.setStart_date_ep(editEduPost.getStart_date_ep());
    	post.setEnd_date_ep(editEduPost.getEnd_date_ep());
    	eduPostRepository.save(post);
    	
    	
		Iterable<CompanyPost> companyPosts = companyPostRepository.findAll();
		Iterable<EduPost> eduPosts = eduPostRepository.findAll();
		model.addAttribute("companyPostList",companyPosts);
		model.addAttribute("eduPostList",eduPosts);
    	
    	return "main";	
    }
    
}
