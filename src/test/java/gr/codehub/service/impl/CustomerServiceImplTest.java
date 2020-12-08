package gr.codehub.service.impl;

import gr.codehub.dto.CustomerDto;
import gr.codehub.model.Customer;
import gr.codehub.repository.CustomerRepository;
import gr.codehub.service.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;



class CustomerServiceImplTest {


    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks // auto inject helloRepository
    private CustomerService customerService = new CustomerServiceImpl();

    private Customer customer = new Customer();
    private CustomerDto customerDto = new CustomerDto();

    @BeforeEach
    void setMockOutput() {
        when(customerService.createCustomer(any())).thenReturn(customerDto);
    }


    @DisplayName("Test Mock helloService + helloRepository")
    @Test
    void testGet() {
        assertEquals(  customerDto, customerService.createCustomer(customerDto));
    }


}