package emp.application.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import emp.application.ems.dto.EmployeeDto;
import emp.application.ems.service.EmployeeService;
import lombok.AllArgsConstructor;
@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	private EmployeeService employeeService;
	
	 @Autowired
	    public EmployeeController(EmployeeService employeeService) {
	        this.employeeService = employeeService;
	    }
	
	//Build ADD Employee Rest API
	@PostMapping
	public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
		EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
		return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
	}
	
	//Build get Employee Rest API
	@GetMapping("{id}")
	public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId){
		EmployeeDto employeeDto = employeeService.getEmployeeById(employeeId);
		return ResponseEntity.ok(employeeDto);
	}
	
	//Build Get All Employees Rest API
	@GetMapping
	public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
		List<EmployeeDto> employees = employeeService.getAllEmployees();
		return ResponseEntity.ok(employees);
	}
	
	//Build Update Employee Rest API
	@PutMapping("{id}")
	public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long employeeId,
			@RequestBody EmployeeDto updatedEmployee){
		EmployeeDto employeeDto=employeeService.updateEmployee(employeeId, updatedEmployee);
		return ResponseEntity.ok(employeeDto);
	}
	
	//Build Delete Employee Rest API
	 @DeleteMapping("{id}")
		public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId){
			employeeService.deleteEmployee(employeeId);
			return ResponseEntity.ok("Employee deleted Sucessfully!.");
		}
}
