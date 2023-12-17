package com.Task.Controller;

import com.Task.Entity.Employee;
import com.Task.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/registration")
    public String showRegistrationForm(Model model) {
        model.addAttribute("employee", new Employee ());
        return "registration";
    }

    @PostMapping("/registration")
    public String processRegistration(@ModelAttribute("employee") Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:/employee/login";
    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "login";
    }

    @PostMapping("/login")
    public String processLogin(@ModelAttribute("employee") Employee employee, Model model) {
        Employee existingEmployee = employeeService.findByLoginId(employee.getLoginId());
        if (existingEmployee != null && existingEmployee.getPassword().equals(employee.getPassword())) {
            model.addAttribute("name", existingEmployee.getName());
            return "welcome";
        } else {
            return "login";
        }
    }

    @GetMapping("/welcome")
    public String showWelcomePage() {
        return "welcome";
    }
}
