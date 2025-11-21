package emp.application.ems.service;

import java.util.List;

import emp.application.ems.dto.EmployeeDto;

public interface EmployeeService {
       EmployeeDto createEmployee(EmployeeDto employeeDto);
       
       EmployeeDto getEmployeeById(Long employeeId);
       
       List<EmployeeDto> getAllEmployees();
       
       EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee);
       
       void deleteEmployee(Long employeeId);
}
