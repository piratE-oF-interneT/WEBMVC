package com.kp.springwebmvc.springwebmvc.controller;

import org.springframework.http.MediaType;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kp.springwebmvc.springwebmvc.advices.*;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
public class HomeController {
	
	@RequestMapping("/home")
	public String getIndexPage(Model model) {
		
		System.out.println("hello home...");
		model.addAttribute("name","kartik pandey");
		
		
		return new String("index");
	}
	
	@RequestMapping("/about")
	public String getAboutPage() {
		return new String("about");
	}
	
	@PostMapping(value = "/login", produces = MediaType.APPLICATION_XML_VALUE)	
	@ResponseBody
	public ResponseTransfer responseTransferXMLContent(@RequestBody LoginForm form) {
		//TODO: process POST request
		
		System.out.println(form.getUsername());
		System.out.println(form.getPassword());
		
		return new ResponseTransfer("xml added");
	}
	
	@PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)	
	@ResponseBody
	public ResponseTransfer responseTransferJSONContent(@RequestBody LoginForm form) {
		//TODO: process POST request
		
		System.out.println(form.getUsername());
		System.out.println(form.getPassword());
		
		return new ResponseTransfer("json added");
	}
	
	

}
