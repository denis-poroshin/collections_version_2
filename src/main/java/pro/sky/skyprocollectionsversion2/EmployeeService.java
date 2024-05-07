package pro.sky.skyprocollectionsversion2;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService {

    private final Map<String, Employee> employeeMap;
    private final int maxEmplyee = 5;


    public EmployeeService() {
        employeeMap = new HashMap<>();
    }

    public Employee addEmployee(String familName, String name, int salary, int department){

        if (employeeMap.containsKey(keyGeneration(familName, name))){
            throw new EmployeeAlreadyAddedException("Сотрудник уже работает в компании");
        } else if (employeeMap.size() > maxEmplyee) {
            throw new EmployeeStorageIsFullException("Мест для новых сотрудников нет");
        }
        Employee newEmployee = new Employee(familName, name, salary, department);
        String key = keyGeneration(familName, name);
        employeeMap.put(key, newEmployee);
        return employeeMap.get(key);

    }
    public Employee dismissalEmployee(String familName, String name){
        String key = keyGeneration(familName, name);
        if(employeeMap.containsKey(key)){
            employeeMap.remove(key);
            return employeeMap.get(key);
        }
        throw new EmployeeNotFoundException("Сотрудник отсутствует в базе данных, увольнение невозможно");
    }
    public Employee searchEmployee(String familName, String name){
        String key = keyGeneration(familName, name);
        if (employeeMap.containsKey(key)){
            return employeeMap.get(key);
        }
        throw new EmployeeNotFoundException("Сотрудник отсутствует в базе данных");
    }
//    public Map<String, Employee> getEmployeeMap(){
//        return new HashMap<>(employeeMap);
//    }

    private String keyGeneration(String familName, String name){
        return familName + name;
    }
    public Collection<Employee> printAllEmployee(){
        //return Collections.unmodifiableCollection(employeeMap.values()); // создаст неизменяемую копию мапы
        return employeeMap.values();

    }



}