package com.springtodo.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.springtodo.demo.dao.TaskRepository;
import com.springtodo.demo.entities.Task;

@Controller
public class ToDoController {
	
	@Autowired
	private TaskRepository taskRepository;

	@GetMapping("/todo")
	public String getTask(Model model) 
	{
		model.addAttribute("taskData",new Task());
		Iterable<Task> itr = taskRepository.findAll();
	    model.addAttribute("taskdatas",itr);
		return "home";
	}
	
	@PostMapping("/process")
	public String processForm(@ModelAttribute("taskData") Task taskData)
	{
		Task task = new Task();
		task.setTask(taskData.task);
		taskRepository.save(task);
		System.out.println(taskData.task);
		return "home";
	}
	
	
}
