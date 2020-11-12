package gr.codehub.dto;


import gr.codehub.model.Customer;
import lombok.Data;

@Data
public class CustomerDto {
    private String userName;
    private String email;
    private int code;


    public static Customer getCustomer(CustomerDto customerDto) {
        Customer customer = new Customer();
        customer.setName(customerDto.getUserName());
        customer.setAddress(customerDto.getEmail());
        return customer;
    }

    public static CustomerDto getCustomerDto(Customer customer) {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setUserName(customer.getName());
        customerDto.setEmail(customer.getAddress());
        customerDto.setCode(customer.getId());
        return customerDto;
    }

}
