package com.example.pos2.controller;

import com.example.pos2.dto.requst.CustomerDTO;
import com.example.pos2.dto.requst.CustomerUpdateDTO;
import com.example.pos2.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("api/v1/customer")
@CrossOrigin

public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/save-1")
    public String savedCustomer (@RequestBody CustomerDTO customerDTO) {
        customerService.saveCustomer(customerDTO);
        return "saved";

    }

    @PutMapping("/update-1")
    public String updateCustomer (@RequestBody CustomerUpdateDTO customerUpdateDTO) {
        String massege = customerService.updateCustomer(customerUpdateDTO);
        return massege;

    }

    @GetMapping(
            path = "/get-customer",
            params = "id"
    )
    public CustomerDTO  getCustomerById (@RequestParam (value = "id") int customerId) {
       CustomerDTO customerDTO = customerService.getCustomerById(customerId);
       return customerDTO;

    }

    @GetMapping(
            path = "/get-all-customers"
    )
    public List<CustomerDTO> getAllCustomers() {
       List<CustomerDTO> customerDTOS = customerService.getAllCustomers();
       return customerDTOS;

    }
    @DeleteMapping(
            path = "/delete-customer",
            params = "id"

    )
    public String deleteCustomer(@RequestParam(value = "id") int customerId) {
        String deleteMassage = customerService.deleteCustomer(customerId);
        return deleteMassage;

    }

    @GetMapping(
            path = "/get-customers-by-avtive-status",
            params = "status"
    )
    public List<CustomerDTO> getAllCustomersByStatus (@RequestParam(value = "status") boolean status) {
        List<CustomerDTO> customerDTOList = customerService. getAllCustomersByStatus(status);
        return customerDTOList;

    }
}
