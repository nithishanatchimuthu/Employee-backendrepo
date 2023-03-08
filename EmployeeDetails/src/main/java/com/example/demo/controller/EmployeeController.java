package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.EmployeeModel;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;

import jakarta.transaction.Transactional;

@Controller
@Component
@RestController
public class EmployeeController {
	@Autowired
	EmployeeService ser;
	@Autowired
	EmployeeRepository rep;
	@GetMapping("/getNameByprefix/{prefix}")
	public List<EmployeeModel>getNameStartingWith(@PathVariable("prefix")String prefix){
		return ser.getByNameStartingWith(prefix);
	}
	@GetMapping("/s")
	public String hel() {
		return "Hello";
	}
	@GetMapping("/and/{id}/{dept}")
	public List<EmployeeModel>getNameByAnd(@PathVariable("id")long id,@PathVariable("dept")String dept){
		return ser.getNameByAnd(id,dept);
	}
	@GetMapping("/getAllByDept/{dept}")
		public List<EmployeeModel>findAllEmployeesByDept(@PathVariable String dept){
			return ser.findAllEmployeesByDept(dept);
		}
	@Transactional
	@PutMapping("/put/{salary}/{id}")
//	public List<EmployeeModel>updateEmployeeSalary(@PathVariable double salary,@PathVariable long id){
//		return ser.updateEmployeeSalary(salary, id);
//	}
	public String updateEmployeeSalary(@PathVariable double salary,@PathVariable long id) {
		String res="";
		int result= ser.updateEmployeeSalary(salary,id);
		if(result>0) {
			res="Updated"+result;
			System.err.println(res);
		}
		else {
			res="Not Updated"+result;
			System.err.println(res);
		}
		return res;
	}
	

}
