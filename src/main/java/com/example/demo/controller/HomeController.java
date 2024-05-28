package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HomeController {

	@Autowired
	com.example.demo.service.HomeService homeService;
	
	@GetMapping("/hai")
	public ResponseEntity<String> getHello(){
		
		return new ResponseEntity<>(homeService.getHello(),HttpStatus.OK);
	}
}
