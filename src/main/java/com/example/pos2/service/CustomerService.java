package com.example.pos2.service;

import com.example.pos2.dto.requst.CustomerDTO;
import com.example.pos2.dto.requst.CustomerUpdateDTO;

import java.util.List;

public interface CustomerService {
    String saveCustomer(CustomerDTO customerDTO);

    String updateCustomer(CustomerUpdateDTO customerUpdateDTO);

    CustomerDTO getCustomerById(int customerId);

    List <CustomerDTO> getAllCustomers();

    String deleteCustomer(int customerId);

    List<CustomerDTO> getAllCustomersByStatus(boolean status);
}
