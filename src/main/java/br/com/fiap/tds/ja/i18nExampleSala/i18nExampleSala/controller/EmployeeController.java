package br.com.fiap.tds.ja.i18nExampleSala.i18nExampleSala.controller;

import br.com.fiap.tds.ja.i18nExampleSala.i18nExampleSala.model.Employee;
import br.com.fiap.tds.ja.i18nExampleSala.i18nExampleSala.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employees")
public class   EmployeeController {
    
    @Setter @Autowired
    private EmployeeService employeeService;
    
    @GetMapping
    public String listEmployees( Model model ){
        model.addAttribute("employees", this.employeeService.findAll());
        return "employee/list";
    }
    
    @GetMapping("/new")
    public String showForm(Employee employee){
        return "employee/form";
    }
    
    @PostMapping
    public String saveEmployee(@Valid Employee employee, BindingResult bindingResult, Model model){
        if( bindingResult.hasErrors() ){
            return "employee/form";
        }
        this.employeeService.save(employee);
        return "redirect:employees";
    }
    
    @GetMapping("/edit/{id}")
    public String showUpdateForm( @PathVariable("id") Long id, Model model){
        Employee employee  = this.employeeService.findById(id).orElseThrow(() -> 
        new IllegalArgumentException("Invalue id provided! " + id));
        model.addAttribute("employee", employee);
        return "employee/form";
    }
    
    @PostMapping("/update/{id}")
    public String updateEmployee(@PathVariable("id") Long id, @Valid Employee employee, BindingResult bindingResult, Model model){
        if( bindingResult.hasErrors()){
            employee.setId(id);
            return "employee/form";
        }
        employeeService.save(employee);
        return "redirect:/employees";
    }
    
    @GetMapping("/delete/{id}")
    public String deleteEmployee( @PathVariable("id") Long id, Model model){
        this.employeeService.deleteById(id);
        return "redirect:/employees";
    }
    
}
