package emp.application.ems.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import emp.application.ems.dto.EmployeeDto;
import emp.application.ems.entity.Employee;
import emp.application.ems.exception.ResourceNotFoundException;
import emp.application.ems.mapper.EmployeeMapper;
import emp.application.ems.repository.EmployeeRepository;
import emp.application.ems.service.EmployeeService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{

	private EmployeeRepository employeeRepository;
	

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {
		// TODO Auto-generated method stub
		
		Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
		Employee savedEmployee = employeeRepository.save(employee);
		return EmployeeMapper.mapToEmployeeDto(savedEmployee);
	}
	@Override
	public EmployeeDto getEmployeeById(Long employeeId) {
		// TODO Auto-generated method stub
	Employee employee =	employeeRepository.findById(employeeId)
		.orElseThrow( () -> new ResourceNotFoundException("Employee is not exists with given id : " + employeeId) );
		return EmployeeMapper.mapToEmployeeDto(employee);
	}
	@Override
	public List<EmployeeDto> getAllEmployees() {
		// TODO Auto-generated method stub
		List<Employee> employees = employeeRepository.findAll();
		return employees.stream().map((employee)-> EmployeeMapper.mapToEmployeeDto(employee))
				.collect(Collectors.toList());
		
				
	}
	@Override
	public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {
		// TODO Auto-generated method stub
		Employee employee= employeeRepository.findById(employeeId).orElseThrow(
			() -> new ResourceNotFoundException("Employee is not exists with given id: "+ employeeId)
				);
		
		employee.setFirstName(updatedEmployee.getFirstName());
		employee.setLastName(updatedEmployee.getLastName());
		employee.setEmail(updatedEmployee.getEmail());

		Employee updatedEmployeeObj = employeeRepository.save(employee);
		
		return EmployeeMapper.mapToEmployeeDto(updatedEmployeeObj);
	}
	@Override
	public void deleteEmployee(Long employeeId) {
		// TODO Auto-generated method stub
		Employee employee= employeeRepository.findById(employeeId).orElseThrow(
				() -> new ResourceNotFoundException("Employee is not exists with given id: "+ employeeId)
					);
		
		employeeRepository.deleteById(employeeId);
	}

}
