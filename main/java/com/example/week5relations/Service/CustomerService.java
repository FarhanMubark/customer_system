package com.example.week5relations.Service;

import com.example.week5relations.Api.ApiException;
import com.example.week5relations.Model.Customer;
import com.example.week5relations.Repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final DetailsService detailsService;
    public List<Customer> getall(){
        return customerRepository.findAll();
    }

    public void addCustomer(Customer customer){
        customerRepository.save(customer);
    }

    public void updateCustomer(Integer id, Customer customer){
        Customer customer1 = customerRepository.findCustomerById(id);

        if (customer1==null){
            throw new ApiException("No Customer found with this Id " +id);
        }

        customer1.setName(customer.getName());

        customerRepository.save(customer1);

    }

    public void deleteCustomer(Integer id){
        Customer customer = customerRepository.findCustomerById(id);

        if (customer==null){
            throw new ApiException("No Customer found with this Id " +id);
        }
        detailsService.deleteDetails(id);
        customerRepository.delete(customer);
    }

}
