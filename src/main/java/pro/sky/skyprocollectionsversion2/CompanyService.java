package pro.sky.skyprocollectionsversion2;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CompanyService {
    private final EmployeeService employeeService;


    public CompanyService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }



    public Employee employeeWithMinimumSalary(int department){
        return employeeService.printAllEmployee().
                stream()
                .filter(emp -> emp.getDepartment() == department)
                .min(Comparator.comparingInt(empl -> empl.getSalary())).orElseThrow(() -> new EmployeeNotFoundException("Сотрудник отсутствует в базе данных"));
//        Map<String,Employee> listEmployee = employeeService.getEmployeeMap();
//        Optional<Employee> employee = listEmployee.entrySet()
//                .stream().
//                map(entry -> entry.getValue())
//                .filter(emp -> emp.getDepartment() == department)
//                .min(Comparator.comparingInt(empl -> empl.getSalary()));
        //return employee.orElseThrow(() -> new EmployeeNotFoundException("Сотрудник отсутствует в базе данных"));


    }
    public Employee employeeWithMaximumSalary(int department){
        return employeeService.printAllEmployee().
                stream()
                .filter(emp -> emp.getDepartment() == department)
                .max(Comparator.comparingInt(empl -> empl.getSalary())).orElseThrow(() -> new EmployeeNotFoundException("Сотрудник отсутствует в базе данных"));
//        Map<String,Employee> listEmployee = employeeService.getEmployeeMap();
//        Optional<Employee> employee = listEmployee.entrySet()
//                .stream()
//                .map(entry -> entry.getValue())
//                .filter(emp -> emp.getDepartment() == department)
//                .max(Comparator.comparingInt(empl -> empl.getSalary()));
//        return employee.orElseThrow(() -> new EmployeeNotFoundException("Сотрудник отсутствует в базе данных"));


    }
    public List<Employee> printAllEmployee(int department){

        return employeeService.printAllEmployee()
                .stream()
                .filter(emp -> emp.getDepartment() == department)
                .collect(Collectors.toList());
//        Map<String,Employee> listEmployee = employeeService.getEmployeeMap();
//        List<Employee> employees = listEmployee
//                .entrySet()
//                .stream()
//                .map(entry -> entry.getValue())
//                .filter(emp -> emp.getDepartment() == department)
//                .collect(Collectors.toList());
//        return employees;

    }
    public Map<Integer, List<Employee>> printAllEmployeeByDepartment() {
        return employeeService.printAllEmployee()
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, () -> new TreeMap<Integer, List<Employee>> (), Collectors.toList()));

    }




}
