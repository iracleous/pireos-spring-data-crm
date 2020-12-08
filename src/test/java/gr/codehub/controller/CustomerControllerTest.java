package gr.codehub.controller;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import gr.codehub.dto.CustomerDto;
import gr.codehub.model.Customer;
import gr.codehub.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


@SpringBootTest
public class CustomerControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @MockBean
    private CustomerService customerServiceMock;

    @BeforeEach
    public void setUp() {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void should_CreateAccount_When_ValidRequest() throws Exception {

        CustomerDto customerDto = new CustomerDto();

        when(customerServiceMock.createCustomer(any(CustomerDto.class))).thenReturn(customerDto);

        mockMvc.perform(post("/api/account")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"accountType\": \"SAVINGS\", \"balance\": 5000.0 }")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(header().string("Location", "/api/account/12345"))
                .andExpect(jsonPath("$.accountId").value("12345"))
                .andExpect(jsonPath("$.accountType").value("SAVINGS"))
                .andExpect(jsonPath("$.balance").value(5000));
    }

    @Test
    public void should_GetAccount_When_ValidRequest() throws Exception {

        /* setup mock */
        CustomerDto customerDto = new CustomerDto();
        when(customerServiceMock.createCustomer(customerDto)).thenReturn(customerDto);

        mockMvc.perform(get("/api/account/12345")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.accountId").value(12345))
                .andExpect(jsonPath("$.accountType").value("SAVINGS"))
                .andExpect(jsonPath("$.balance").value(5000.0));
    }

    @Test
    public void should_Return404_When_AccountNotFound() throws Exception {

        /* setup mock */

        CustomerDto customerDto = new CustomerDto();
        when(customerServiceMock.createCustomer(customerDto)).thenReturn(null);

        mockMvc.perform(get("/api/account/12345")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

}