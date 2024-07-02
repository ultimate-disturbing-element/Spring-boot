package com.smartcontactmanager.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.smartcontactmanager.dao.UserRepository;
import com.smartcontactmanager.entities.Contact;
import com.smartcontactmanager.entities.User;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
//	Method for adding Common Data to response
	@ModelAttribute
	public void addCommonData(Model m, Principal principal) {
		String userName = principal.getName();
		
		User user = this.userRepository.getuserByUsername(userName);
		
		System.out.println("Username"+userName);
		
		System.out.println("user"+user);
		
		m.addAttribute("user",user);
	}
	
//	DashBoard
	@RequestMapping("/index")
	public String dashboard(Model model,Principal principal) {
		model.addAttribute("title","User DashBoard");
		return "normal/user_dashboard";
	}
	
	@GetMapping("/add-contact")
	public String openAddContactForm(Model model) {
		model.addAttribute("title","Add Contact");
		model.addAttribute("contact",new Contact());
		return "normal/add_contact_form";
	}
	 
	@PostMapping("/process-contact")
	public String proccessContact(
			@ModelAttribute Contact contact,
			@RequestParam("profileImage") MultipartFile file, 
			Principal principal) {
		try {
		String name = principal.getName();
		User user = this.userRepository.getuserByUsername(name);
		
		if(file.isEmpty()) {
			System.out.println("File is Empty");
		}
		else {
			contact.setImage(file.getOriginalFilename());
			
			File saveFile = new ClassPathResource("static/img").getFile();
			
			Path path = Paths.get(saveFile.getAbsolutePath()+File.separator+file.getOriginalFilename());
			Files.copy(file.getInputStream(),path, StandardCopyOption.REPLACE_EXISTING);
		
			
		}
		
		contact.setUser(user);
		user.getContacts().add(contact);
		
		this.userRepository.save(user);
		
		System.out.println(contact) ;
		
		} 
		catch(Exception e) {
			System.out.println("Error"+e.getMessage());
			e.printStackTrace();
		}
		return "normal/add_contact_form";
	}
}
