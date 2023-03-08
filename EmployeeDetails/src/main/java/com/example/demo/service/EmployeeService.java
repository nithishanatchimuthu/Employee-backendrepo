package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.EmployeeModel;
import com.example.demo.repository.EmployeeRepository;

import jakarta.transaction.Transactional;

@Service

public class EmployeeService {

	@Autowired
	EmployeeRepository rep;
	public List<EmployeeModel>getByNameStartingWith(String prefix){
		return rep.findBynameStartingWith(prefix);
	}
	public List<EmployeeModel>getNameByAnd(long id,String dept){
		return rep.findNameByIdOrDept(id,dept);
	}
	public List<EmployeeModel>findAllEmployeesByDept(String dept){
		return rep.findAllEmployeesByDept(dept);
	}
//	public List<EmployeeModel>updateEmployeeSalary(double salary,long id){
//		return rep.updateEmployeeSalary(salary,id);
//	}
	@Transactional
	public int updateEmployeeSalary(double salary,long id) {
		int result=rep.updateEmployeeSalary(salary,id);
		return result;
		
	}
}
