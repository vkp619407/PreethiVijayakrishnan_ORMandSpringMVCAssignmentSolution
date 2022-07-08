package com.customer.service;

import java.util.List;
import com.customer.model.Customer;

public interface CustomerService {

	public List<Customer> findAll();

	public Customer findById(long customerId);

	public void save(Customer customer);

	public void delete(long customerId);

}
