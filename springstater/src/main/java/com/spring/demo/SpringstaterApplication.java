package com.spring.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.spring.demo.dao.UserRepository;
import com.spring.demo.entities.User;

@SpringBootApplication
public class SpringstaterApplication {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext context = SpringApplication.run(SpringstaterApplication.class, args);
		
		UserRepository userRepository = context.getBean(UserRepository.class);
		
//		User user = new User();
		
//		user.setName("Abhinav");
//		user.setCity("Mumbai");
//		user.setStatus("Fullstack Devloper");
//		
//		User user1 = new User();
//		
//		user1.setName("Abhishek");
//		user1.setCity("Chennai");
//		user1.setStatus("CrossPlatForm Devloper");
//		
//		User user2 = new User();
//		
//		user2.setName("Abhii");
//		user2.setCity("Hydrabad");
//		user2.setStatus("Devloper");	
//		
//		List<User> users = List.of(user,user1,user2);
//		
//		Iterable<User> result = userRepository.saveAll(users);
//		
//		result.forEach(e->{System.out.println(e);});
		
//		User user1 = userRepository.save(user);
		
//		System.out.println(user1);
		
//		Optional<User> optional = userRepository.findById(52);
//		
//		User user = optional.get();
//		
//		user.setName("Rehan");
//		
//		User result = userRepository.save(user);
		
		Iterable<User> itr = userRepository.findAll();
		
		itr.forEach(e->{System.out.println(e);});
		
		

	}

}
