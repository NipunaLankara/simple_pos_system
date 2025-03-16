package com.example.pos2.service.impl;

import com.example.pos2.dto.requst.CustomerDTO;
import com.example.pos2.dto.requst.CustomerUpdateDTO;
import com.example.pos2.entity.Customer;
import com.example.pos2.repo.CustomerRepo;
import com.example.pos2.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceIMPL implements CustomerService {
    @Autowired
    private CustomerRepo customerRepo;
    @Override
    public String saveCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer(
                customerDTO.getCustomerId(),
                customerDTO.getCustomerName(),
                customerDTO.getCustomerAddress(),
                customerDTO.getContactNumber(),
                customerDTO.getNic(),
                customerDTO.isStatus()
        );
        customerRepo.save(customer);
        return "true";
    }

    @Override
    public String updateCustomer(CustomerUpdateDTO customerUpdateDTO) {
        int customerId = customerUpdateDTO.getCustomerId();

        if (customerRepo.existsById(customerId)) {
            Customer updateCustomer = customerRepo.getReferenceById(customerId);
            updateCustomer.setCustomerName(customerUpdateDTO.getCustomerName());
            updateCustomer.setCustomerAddress(customerUpdateDTO.getCustomerAddress());
            updateCustomer.setContactNumber(customerUpdateDTO.getContactNumber());

            customerRepo.save(updateCustomer);
            return customerUpdateDTO.getCustomerName()+" Updated Succesful";

        } else {
            throw new RuntimeException("Data Not Found");
        }

    }

    @Override
    public CustomerDTO getCustomerById(int customerId) {
        if (customerRepo.existsById(customerId)) {
            Customer customer = customerRepo.getReferenceById(customerId);
            CustomerDTO customerDTO = new CustomerDTO(customer.getCustomerId(),
                    customer.getCustomerName(),
                    customer.getCustomerAddress(),
                    customer.getContactNumber(),
                    customer.getNic(),
                    customer.isStatus()
                    );

            return customerDTO;

        }  else {
            throw new RuntimeException("Data Not Found");
        }


    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> customerList = customerRepo.findAll();

        List<CustomerDTO> customerDTOList = new ArrayList<CustomerDTO>();

        for (Customer customer : customerList) {
            CustomerDTO customerDTO = new CustomerDTO(
                    customer.getCustomerId(),
                    customer.getCustomerName(),
                    customer.getCustomerAddress(),
                    customer.getContactNumber(),
                    customer.getNic(),
                    customer.isStatus()
            );
            customerDTOList.add(customerDTO);
        }
        return customerDTOList;

    }

    @Override
    public String deleteCustomer(int customerId) {
        if (customerRepo.existsById(customerId)) {
            customerRepo.deleteById(customerId);

            return "Delete Successfully "+customerId;

        } else {
            throw new RuntimeException("Data Not Found");
        }
    }

    @Override
    public List<CustomerDTO> getAllCustomersByStatus(boolean status) {
        List<Customer> customerList = customerRepo.findAllByStatusEquals(status);

        List<CustomerDTO> customerDTOList = new ArrayList<CustomerDTO>();

        for (Customer customer : customerList) {
            CustomerDTO customerDTO = new CustomerDTO(
                    customer.getCustomerId(),
                    customer.getCustomerName(),
                    customer.getCustomerAddress(),
                    customer.getContactNumber(),
                    customer.getNic(),
                    customer.isStatus()
            );
            customerDTOList.add(customerDTO);
        }
        return customerDTOList;

    }

}
