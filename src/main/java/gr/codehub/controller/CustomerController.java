package gr.codehub.controller;


import gr.codehub.dto.CustomerDto;
import gr.codehub.exception.CustomerCreationException;
import gr.codehub.exception.CustomerNotFoundException;
import gr.codehub.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;



    @PostMapping("customer")
    public CustomerDto addCustomer(@RequestBody CustomerDto customerDto)
            throws CustomerCreationException {
        return customerService.createCustomer(customerDto);
    }


    @GetMapping("customer")
    public List<CustomerDto> getCustomers(){
        return customerService.getAllCustomers();
    }

    @GetMapping("customer/{id}")
    public CustomerDto getCustomer(@PathVariable int id)   throws CustomerNotFoundException {
        return customerService.getCustomerById(id);
    }

}
