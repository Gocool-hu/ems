package emp.application.ems.mapper;

import emp.application.ems.dto.EmployeeDto;
import emp.application.ems.entity.Employee;

public class EmployeeMapper {
 public static EmployeeDto mapToEmployeeDto(Employee employee) {
     return new EmployeeDto(
         employee.getId(),
         employee.getFirstName(),
         employee.getLastName(),
         employee.getEmail()
     );
 }
 
 public static Employee mapToEmployee(EmployeeDto employeeDto) {
	 return new Employee(
			 employeeDto.getFirstName(),
			 employeeDto.getLastName(),
			 employeeDto.getEmail()
			 );
 }
}

