package com.example.week5relations.Controller;

import com.example.week5relations.Api.ApiResponse;
import com.example.week5relations.Model.Customer;
import com.example.week5relations.Service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/get")
    public ResponseEntity getAll(){
        return ResponseEntity.status(200).body(customerService.getall());
    }

    @PostMapping("/add")
    public ResponseEntity addCustomer(@RequestBody @Valid Customer customer){
        customerService.addCustomer(customer);

        return ResponseEntity.status(200).body(new ApiResponse("customer added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateCustomer(@PathVariable int id, @RequestBody @Valid Customer customer){
        customerService.updateCustomer(id, customer);

        return ResponseEntity.status(200).body(new ApiResponse("customer updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCustomer(@PathVariable int id){
        customerService.deleteCustomer(id);
        return ResponseEntity.status(200).body(new ApiResponse("Customer deleted"));
    }
}
