package gr.codehub.service;

import gr.codehub.dto.CustomerDto;
import gr.codehub.model.Customer;

import java.util.List;

public interface CustomerService {

    CustomerDto createCustomer(CustomerDto customerDto);
    List<CustomerDto> getAllCustomers();
    CustomerDto getCustomerById(int id);

    CustomerDto update(CustomerDto customerDto, int id );
    boolean deleteCustomer(int id );
}
