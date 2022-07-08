package com.customer.service.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.customer.model.Customer;
import com.customer.service.CustomerService;

@Repository
public class CustomerServiceImpl implements CustomerService {

	private SessionFactory sessionFactory;
	private Session session;

	@Autowired
	public CustomerServiceImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
		try {
			this.session = this.sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			this.session = this.sessionFactory.openSession();
		}
	}

	// Method to get all Customers from Table
	@Override
	public List<Customer> findAll() {
		List<Customer> customerList = this.session.createQuery("from Customer").list();
		return customerList;
	}

	// Method to find customer using customerID
	@Override
	public Customer findById(long customerId) {
		Customer customer = this.session.get(Customer.class, customerId);
		return customer;
	}

	// Method to Save or Update customer details in Table
	@Override
	@Transactional
	public void save(Customer customer) {
		Transaction tx = this.session.beginTransaction();
		this.session.saveOrUpdate(customer);
		tx.commit();

	}

	// Method to delete customer record from Table
	@Override
	@Transactional
	public void delete(long customerId) {
		Transaction tx = this.session.beginTransaction();
		Customer customer = this.session.get(Customer.class, customerId);
		this.session.delete(customer);
		tx.commit();
	}

}
