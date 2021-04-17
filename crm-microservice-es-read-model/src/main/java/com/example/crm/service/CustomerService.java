package com.example.crm.service;

import java.util.List;

import com.example.crm.dto.CustomerResponse;

public interface CustomerService {

	CustomerResponse findByIdentity(String identity);

	List<CustomerResponse> findAll(int page, int size);

}
