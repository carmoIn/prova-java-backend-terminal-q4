package com.company.controller;

import com.company.DAO.CustomerDAO;
import com.company.model.Customer;

import java.util.List;

public class CustomerController {
    private CustomerDAO customerDAO = new CustomerDAO();

    public List<Customer> list() {
        return customerDAO.list();
    }

    public Customer create (Customer customer) {
        if (customer != null && !this.isValidCustomerId(customer.getIdCustomer())) {
            return customerDAO.create(customer);
        }
        return null;
    }

    public boolean isValidCustomerId(Long idCustomer) {
        for (Customer customer : customerDAO.list()) {
            if (customer.getIdCustomer() == idCustomer) {
                return true;
            }
        }
        return false;
    }
}
