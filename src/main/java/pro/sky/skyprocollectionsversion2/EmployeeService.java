package pro.sky.skyprocollectionsversion2;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService {
    private final Map<String, Employee> employeeMap = new HashMap<>();
    private final int MAX_EMPLIYEE = 5;
    private static int total = 1;
//    public EmployeeService(Map<String, Employee> employeeKey employeeKe) {
//        this.employeelist = employeelist;
//    }

    public Employee addEmployee(String familName, String name){
        Employee newEmployee = new Employee(familName, name);
        if (employeeMap.containsKey(newEmployee.getFamilName())){
            throw new EmployeeAlreadyAddedException("Сотрудник уже работает в компании");
        } else if (total > MAX_EMPLIYEE) {
            throw new EmployeeStorageIsFullException("Мест для новых сотрудников нет");
        }
        ++total;
        employeeMap.put(familName + name, newEmployee);
//        if (employeelist.contains(newEmployee)){
//            throw new EmployeeAlreadyAddedException("Сотрудник уже работает в компании");
//        } else if (employeelist.size() >= MAX_EMPLIYEE) {
//            throw new EmployeeStorageIsFullException("Мест для новых сотрудников нет");
//        }
//        employeelist.add(newEmployee);
        return employeeMap.get(familName + name);

    }
    public Employee dismissalEmployee(String familName, String name){
        Employee employee = new Employee(familName, name);
        if(employeeMap.containsKey(employee.getFamilName())){
            employeeMap.remove(familName + name, employee);
            return employeeMap.get(familName + name);
        }
//        if(employeelist.contains(employee)){
//            employeelist.remove(employee);
//            return employee;
//        }
        throw new EmployeeNotFoundException("Сотрудник отсутствует в базе данных, увольнение невозможно");
    }

    public Employee searchEmployee(String familName, String name){
        Employee employee = new Employee(familName, name);
        if (employeeMap.containsKey(employee.getFamilName())){
            return employeeMap.get(familName + name);
        }
//        if(employeelist.contains(employee)){
//            return employee;
//        }
        throw new EmployeeNotFoundException("Сотрудник отсутствует в базе данных");
    }
    public Collection<Employee> printAllEmployee(){
        return Collections.unmodifiableCollection(employeeMap.values()); // создаст неизменяемую копию листа

    }



}