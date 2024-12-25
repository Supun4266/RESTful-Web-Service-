package com.learn.SpringBootCrud.controller;

import com.learn.SpringBootCrud.model.Customer;
import com.learn.SpringBootCrud.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class HomeController {

    private final CustomerService customerService;

    public HomeController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/")
     public String Home(@RequestParam(value = "name",defaultValue= "")String name, Model model){

        List<Customer> customerList =customerService.getAllCustomers();
        model.addAttribute("customerList",customerList);

        return "Home";

     }
     @GetMapping("/create")
    public String create(Model model){
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "create";
     }

     @PostMapping("/save")
    public String save(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult,
                       RedirectAttributes redirectAttributes, Model model){
        if (bindingResult.hasErrors()) {
            return "/create";
        }
       customerService.Save(customer);
        redirectAttributes.addFlashAttribute(
                "message",
                "Customer created successfully"

        );

       return "redirect:/";
     }

     @GetMapping("customer/{id}")
     public String show(@PathVariable long id, Model model){
         customerService.findById(id)
                .ifPresent(customer -> model.addAttribute("customer",customer));
         return "show";
     }

     @GetMapping("customer/{id}/edit")
    public String edit(@PathVariable long id, Model model){
        Customer customer= customerService.findById(id).orElse(null);
        model.addAttribute("customer",customer);
        return "create";
     }

     @GetMapping("customer/{id}/delete")
     public String delete(@PathVariable long id, RedirectAttributes redirectAttributes){
        customerService.deleteById(id);
        redirectAttributes.addFlashAttribute("message","Customer deleted successfully");
        return "redirect:/";
     }



}
