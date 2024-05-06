package pro.sky.skyprocollectionsversion2;



import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments") // нужно для того, чтобы не вводить эту надпись в каждом "@RequestMapping"
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @RequestMapping(path = "/min-salary")
    public Employee employeeWithMinimumSalary(@RequestParam("departmentId") int departmentId) {
        return companyService.employeeWithMinimumSalary(departmentId);
    }
    @RequestMapping(path = "/max-salary")
    public Employee employeeWithMaximumSalary(@RequestParam("departmentId") int departmentId) {
        return companyService.employeeWithMaximumSalary(departmentId);
    }
    @RequestMapping(path = "/all", params = "departmentId")
    public List<Employee> printAllEmployee(@RequestParam("departmentId") int departmentId) {
        return companyService.printAllEmployee(departmentId);
    }
    @RequestMapping(path = "/alll") // незнаю как обойти проблему с одиновой ссылко
    public Map<Integer, Employee> printAllEmployeeByDepartment() {
        return companyService.printAllEmployeeByDepartment();
//        @RequestMapping(path = "/remove")
//        public Employee removeEmployee(@RequestParam("lastName") String lastName, @RequestParam("firstName") String firstName){
//            return companyService.dismissalEmployee(lastName,firstName);
//        }
//        @RequestMapping(path = "/find")
//        public Employee findEmployee(@RequestParam("lastName") String lastName, @RequestParam("firstName") String firstName){
//            return companyService.searchEmployee(lastName, firstName);
//        }
//        @GetMapping
//        public Collection<Employee> printEmployee(){
//            return companyService.printAllEmployee();
//        }
    }
}


