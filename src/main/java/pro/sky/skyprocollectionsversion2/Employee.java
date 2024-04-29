package pro.sky.skyprocollectionsversion2;

import java.util.Objects;

public class Employee {
    private String name; // Имя
    private String familName; // Фамилия

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
    public String getFullName(String familName, String name){
        return  familName + name;

    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name) && Objects.equals(familName, employee.familName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, familName);
    }

    @Override
    public String toString() {
        return "Фамилия: %s\nИмя: %s".formatted(familName, name);
    }


}

