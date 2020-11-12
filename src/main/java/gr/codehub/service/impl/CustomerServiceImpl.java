package gr.codehub.service.impl;

import gr.codehub.dto.CustomerDto;
import gr.codehub.model.Customer;
import gr.codehub.repository.CustomerRepository;
import gr.codehub.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public CustomerDto createCustomer(CustomerDto customerDto) {
        Customer customer = CustomerDto.getCustomer(customerDto);
        customerRepository.save(customer);
        CustomerDto customerDtoReturn = CustomerDto.getCustomerDto(customer);

        return customerDtoReturn;
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        List<CustomerDto> customerDtoList = new ArrayList<>();
        customers.forEach(customer -> customerDtoList.add(CustomerDto.getCustomerDto(customer)));
        return customerDtoList;
    }

    @Override
    public CustomerDto getCustomerById(int id) {
        Optional<Customer> customerOptional = customerRepository.findById(id);

        return customerOptional.map(CustomerDto::getCustomerDto).orElse(null);
    }

    @Override
    public CustomerDto update(CustomerDto customerDto, int id) {
        return null;
    }

    @Override
    public boolean deleteCustomer(int id) {
        return false;
    }
}
