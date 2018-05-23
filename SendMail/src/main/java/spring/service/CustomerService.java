package spring.service;

import spring.model.Customer;

public interface CustomerService {
	public void sendOrderConfirmation(Customer customer);
}
