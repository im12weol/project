package com.spring.example.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.beans.propertyeditors.CustomDateEditor;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.example.domain.DTO;
import com.spring.example.domain.SampleDTO;
import com.spring.example.domain.TodoDTO;

//import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample/*")
@Log4j
public class SampleController {
	@RequestMapping("")
	public void basic() {
		log.info("---------");
	}
	/*@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(dateFormat, false));
	}*/
	@RequestMapping(value="/basic",method= {RequestMethod.GET, RequestMethod.POST})
	public void basicGet() {
		log.info("only when i sleep");
	}
	@GetMapping("/basicOnlyGet")
	public void basicGet2() {
		log.info("the corrs");
	}
	@GetMapping("/exam01")
	public String ex01(DTO dto,Model model) {
		log.info(""+dto);
		model.addAttribute("dto",dto);
		return "exam01";
	}
	@GetMapping("/exam02")
	public String ex02(@RequestParam("username") String name, 
			int age) {
		log.info("name:"+name);
		log.info("age:"+age);
		
		return "exam02";
	}
	@GetMapping("/exam02List")
	public String exam02List(@RequestParam("language")ArrayList<String>language) {
		log.info("language:"+language.toString());
		for(String lang:language) {
			log.info("language values:"+lang);
		}
		return "exam02List";
	}
	@GetMapping("/exam02Array")
	public String exam02Array(@RequestParam("hobby")String[]hobby) {
		log.info("array hobby:"+Arrays.toString(hobby));
		return "exam02Array";
	}
	@GetMapping("exam02Bean")
	public String exam02Bean(SampleDTO list) {
		log.info("list dtoList:"+list);
		
		return "exam02Bean";
	}
	@GetMapping("/exam03")
	public String exam03(TodoDTO todo) {
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		log.info("todo:"+todo);
		log.info("todo:"+dateFormat.format(todo.getDueDate()));
		
		return "exam03";
	}
	@GetMapping("/exam04")
	public String exam04(SampleDTO dto,@ModelAttribute("page")int page) {
		log.info("dto:"+dto);
		log.info("page:"+page);
		
		return "sample/exam04";
	}
	@GetMapping("/exam05")
	public void exam05() {
		log.info("/exam05");
	}
	@GetMapping("/exam06")
	public @ResponseBody DTO exam06() {
		log.info("/exam06");
		
		DTO dto=new DTO();
		dto.setAge(10);
		dto.setName("grace");
		
		return dto;
	}
	@GetMapping("/exam07")
	public ResponseEntity<String>exam07(){
		log.info("/exam07");
		String msg="{\"name\":\"홍길동\"}";
		HttpHeaders header=new HttpHeaders();
		header.add("content-Type", "application/json;charset=UTF-8");
		
		return new ResponseEntity<>(msg,header,HttpStatus.OK);
	}
		
}