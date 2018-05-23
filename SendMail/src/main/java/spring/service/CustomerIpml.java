package spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.model.Customer;

@Service("customerService")
public class CustomerIpml implements CustomerService{
	@Autowired
	MailServiceImpl mailService;
	
	public void sendOrderConfirmation(Customer customer) {
		mailService.sendEmail(customer);
		
	}
	
}
