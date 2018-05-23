package spring.controller;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import spring.model.Customer;
import spring.service.CustomerService;

public class Test {
	public static void main(String[] args) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		CustomerService orderService = (CustomerService) context.getBean("customerService");
		orderService.sendOrderConfirmation(getDummyOrder());
     	((AbstractApplicationContext) context).close();
	}
	
	public static Customer getDummyOrder(){
		
		
		Customer customerInfo = new Customer();
		customerInfo.setName("Cuong Nguyen");
		
		customerInfo.setEmail("xuancuong1811@gmail.com");
		customerInfo.setOderId("1112");
		
		return customerInfo;
	}
}
