package pro.sky.skyprocollectionsversion2;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CompanyService {
    private EmployeeService employeeService;


    public CompanyService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }



    public Employee employeeWithMinimumSalary(int department){
        Map<String,Employee> listEmployee = employeeService.getEmployeeMap();
        Optional<Employee> employee = listEmployee.entrySet()
                .stream().
                map(entry -> entry.getValue())
                .filter(emp -> emp.getDepartment() == department)
                .min(Comparator.comparingInt(empl -> empl.getSalary()));
        return employee.orElseThrow(() -> new EmployeeNotFoundException("Сотрудник отсутствует в базе данных"));


    }
    public Employee employeeWithMaximumSalary(int department){
        Map<String,Employee> listEmployee = employeeService.getEmployeeMap();
        Optional<Employee> employee = listEmployee.entrySet()
                .stream()
                .map(entry -> entry.getValue())
                .filter(emp -> emp.getDepartment() == department)
                .max(Comparator.comparingInt(empl -> empl.getSalary()));
        return employee.orElseThrow(() -> new EmployeeNotFoundException("Сотрудник отсутствует в базе данных"));


    }
    public List<Employee> printAllEmployee(int department){
        Map<String,Employee> listEmployee = employeeService.getEmployeeMap();
        List<Employee> employees = listEmployee
                .entrySet()
                .stream()
                .map(entry -> entry.getValue())
                .filter(emp -> emp.getDepartment() == department)
                .collect(Collectors.toList());
        return employees; // почему нет возможности выбросить ошибку как в методах мин и макс?

    }
    public Map<Integer, Employee> printAllEmployeeByDepartment(){
        Map<String,Employee> listEmployee = employeeService.getEmployeeMap();
        Map<Integer,Employee> employee = listEmployee
                .entrySet()
                .stream()
                .map(entry -> entry.getValue())
                .collect(Collectors.toMap(employee1 -> employee1.getDepartment(), employee1 -> employee1));
        return employee; // почему нет возможности выбросить ошибку как в методах мин и макс?


    }
}
