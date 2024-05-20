package pro.sky.skyprocollectionsversion2;

import org.apache.catalina.util.StringUtil;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class Employee {
    private String name; // Имя
    private String familName; // Фамилия
    private int salary; // зарплата
    private int department; // отдел

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public int getSalary() {
        return salary;
    }

    public int getDepartment() {
        return department;
    }

    public Employee(String familName, String name, int salary, int department) {
        this.familName = familName;
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    public Employee (String familName, String name){
        this.familName = familName; // Фамилия
        this.name = name; // Имя


    }

    public String getName() {
        return name;
    }

    public String getFamilName() {
        return familName;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return salary == employee.salary && department == employee.department && Objects.equals(name, employee.name) && Objects.equals(familName, employee.familName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, familName, salary, department);
    }

    @Override
    public String toString() {
        return "Отдел: %d\nФамилия: %s\nИмя: %s\nЗарплата: %d".formatted(department,StringUtils.capitalize(familName), StringUtils.capitalize(name), salary);

    }


}

