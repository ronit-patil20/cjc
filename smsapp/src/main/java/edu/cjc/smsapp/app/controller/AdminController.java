package edu.cjc.smsapp.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.cjc.smsapp.app.model.Student;
import edu.cjc.smsapp.app.servicei.StudentServiceI;

@Controller
public class AdminController {

	@Autowired
	StudentServiceI ssi;
	@RequestMapping("/")
	public String preLogin() {
		return "login";
	}
	
	@RequestMapping("/login")
	public String login(@RequestParam("username") String username,@RequestParam("password") String password,Model m) {
		if(username.equals("ADMIN") && password.equals("ADMIN")) {
			List<Student> list=ssi.getAllStudents();
			m.addAttribute("data", list);
			return "adminscreen";
		}
		else {
			m.addAttribute("msg","invalid creadiatial...");
			return "login";
		}		
	}
	@RequestMapping("/enroll_student")
	public String saveStudent(@ModelAttribute Student s,Model m) {
		
		ssi.saveStudent(s);
		List<Student> list=ssi.getAllStudents();
		m.addAttribute("data", list);
		return "adminscreen";
	}
	
	@RequestMapping("/search")
	public String getBatchStudent(@RequestParam("batchNumber") String batchNumber,Model m) {
		
	
		List<Student> list=ssi.searchBatch(batchNumber);
		  if(list.size()>0) {
			  m.addAttribute("data", list);
				return "adminscreen";
		  }else {
			  List<Student> list1=ssi.getAllStudents();
				m.addAttribute("data", list1);
				m.addAttribute("message","No record found for this batch  "+batchNumber);
				
			  return "adminscreen";
		  }
	
	}
	
	

	
	
	
	
}
