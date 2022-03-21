package com.example.project.service;

import com.example.project.dto.ApiResponse;
import com.example.project.entity.Customer;
import com.example.project.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {
    final CustomerRepository customerRepository;

    public ApiResponse add(Customer customer) {
        if (customerRepository.existsByNameIgnoreCase(customer.getName())) return new ApiResponse("NOT", false);
        customerRepository.save(customer);
        return new ApiResponse("Save", true);
    }

    public ApiResponse edit(Integer id, Customer customer) {
        if (customerRepository.existsByNameIgnoreCase(customer.getName()))
            return new ApiResponse("Bunday nom bor", false);
        Customer byId = customerRepository.getById(id);
        byId.setName(customer.getName());
        customerRepository.save(byId);
        return new ApiResponse("Edit!", true);
    }

    public ApiResponse delete(Integer id) {
        //realda o'chirmayman
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        Customer customer = optionalCustomer.get();
        customer.setActive(false);
        customerRepository.save(customer);
        return new ApiResponse("Delete", true);
        //xoxlasang botqoqqa bot o'chirib
    }

}
