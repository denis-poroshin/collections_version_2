package pro.sky.skyprocollectionsversion2;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService {

    private final Map<String, Employee> employeeMap;
    private final int MAX_EMPLIYEE = 4;
    private static int total = 0;

    public EmployeeService() {
        employeeMap = new HashMap<>();
    }

    public Employee addEmployee(String familName, String name, int salary, int department){
        Employee newEmployee = new Employee(familName, name, salary, department);
        if (employeeMap.containsKey(keyGeneration(familName, name))){
            throw new EmployeeAlreadyAddedException("Сотрудник уже работает в компании");
        } else if (total > MAX_EMPLIYEE) {
            throw new EmployeeStorageIsFullException("Мест для новых сотрудников нет");
        }
        ++total;
        employeeMap.put(keyGeneration(familName, name), newEmployee);
        return employeeMap.get(keyGeneration(familName, name));

    }
    public Employee dismissalEmployee(String familName, String name, int salary, int department){
        Employee employee = new Employee(familName, name, salary, department);
        if(employeeMap.containsKey(keyGeneration(familName, name))){
            employeeMap.remove(keyGeneration(familName, name), employee);
            return employeeMap.get(keyGeneration(familName, name));
        }
        throw new EmployeeNotFoundException("Сотрудник отсутствует в базе данных, увольнение невозможно");
    }

    public Employee searchEmployee(String familName, String name, int salary, int department){
        Employee employee = new Employee(familName, name, salary, department);
        if (employeeMap.containsKey(keyGeneration(familName, name))){
            return employeeMap.get(keyGeneration(familName, name));
        }
        throw new EmployeeNotFoundException("Сотрудник отсутствует в базе данных");
    }
    public Map<String, Employee> getEmployeeMap(){
        return new HashMap<>(employeeMap);
    }

    private String keyGeneration(String familName, String name){
        return familName + name;
    }
    public Collection<Employee> printAllEmployee(){
        return Collections.unmodifiableCollection(employeeMap.values()); // создаст неизменяемую копию мапы

    }



}