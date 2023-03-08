package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.EmployeeModel;
@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeModel,Long>{
	
    public List<EmployeeModel> findBynameStartingWith(String prefix);
    public List<EmployeeModel> findBynameEndingWith(String suffix);
    public List<EmployeeModel>findBySalaryLessThan(double salary);
	public List<EmployeeModel>findBySalaryGreaterThan(double salary);
	public List<EmployeeModel>findBySalaryLessThanEqual(double salary);
	public List<EmployeeModel>findBySalaryGreaterThanEqual(double salary);
	public List<EmployeeModel>findBySalaryBetween(double minRange,double maxRange);	
	public List<EmployeeModel>findEmployeeByIdAndName(long id, String name);

  public List<EmployeeModel>findNameByIdOrDept(long id,String dept);
  
  @Query("SELECT emp FROM EmployeeModel emp WHERE emp.dept=?1 ")
  public List<EmployeeModel>findAllEmployeesByDept(String department);
  @Modifying
  @Query("UPDATE EmployeeModel emp set emp.salary=:sal where emp.id=:id")
  public int updateEmployeeSalary(@Param("sal")double salary,@Param("id")long id);
  @Modifying
  @Query("DELETE FROM EmployeeModel emp WHERE emp.id=:id")
  public int deleteEmployeeDetails(@Param("id")long id);
}
