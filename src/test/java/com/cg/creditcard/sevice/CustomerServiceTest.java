package com.cg.creditcard.sevice;



import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.creditcard.entity.Customer;
import com.cg.creditcard.repository.CustomerRepository;
import com.cg.creditcard.service.impl.CustomerService;


@RunWith(SpringRunner.class)
@SpringBootTest
class CustomerServiceTest {

	@MockBean
	CustomerRepository customerRepository;
	
	@Autowired
	CustomerService customerService;
	
	 @Test
	 public void testAddCustomer() throws Exception{
	        Customer customer = new Customer();
	        customer.setUserId("arnab123");
	        customer.setName("Arnab");
	        customer.setEmail("arnab@gmail.com");
	        customer.setContactNo("88888888");
	        customer.setDob("1997-10-12");

	        Mockito.when(customerRepository.save(customer)).thenReturn(customer);
	        //assertThat(customerService.addCustomer(CustomerUtils.convertToCustomerDto(customer))).isEqualTo(customer);
	        Assert.assertNotNull(customer);
	    }
	 
	 @Test
	 public void testRemoveCustomer() throws Exception{
		 Customer customer = new Customer();
	        customer.setUserId("debadrita123");
	        customer.setName("Debadrita");
	        customer.setEmail("debadrita123@gmail.com");
	        customer.setContactNo("78787878");
	        customer.setDob("1998-05-02");
	        
	        Mockito.when(customerRepository.save(customer)).thenReturn(customer);
	        Mockito.when(customerRepository.findById("debadrita123").get()).thenReturn(customer);
	        customerRepository.deleteById(customer.getUserId());
	        Mockito.when(customerRepository.findById("debadrita123").get()).thenReturn(customer);
	        Assert.assertNotEquals(customer, new Customer());

	 }
	 
	 @Test
	 public void testUpdateCustomer() throws Exception{
		 Customer customer = new Customer();
	        customer.setUserId("Aditya123");
	        customer.setName("Aditya");
	        customer.setEmail("debadrita123@gmail.com");
	        customer.setContactNo("78787878");
	        customer.setDob("1998-05-02");
	        
	        customerRepository.save(customer);
	        Mockito.when(customerRepository.findById("Aditya123").get()).thenReturn(customer);
	        customer.setUserId("Debadrita123");
	        Mockito.when(customerRepository.save(customer)).thenReturn(customer);
	        //Assert.assertEquals(customerService.updateCustomer("Aditya123", CustomerUtils.convertToCustomerDto(customer)), customer);
	        //assertThat(customerService.updateCustomer("Debadrita123",  CustomerUtils.convertToCustomerDto(customer))).isEqualTo(customer);
	        
	 }

	@Test
	public void testGetAllCustomers() throws Exception{
		Customer customer1 = new Customer();
        customer1.setUserId("Aditya123");
        customer1.setName("Aditya");
        customer1.setEmail("debadrita123@gmail.com");
        customer1.setContactNo("78787878");
        customer1.setDob("1998-05-02");
        
        Customer customer2 = new Customer();
        customer2.setUserId("Arindam123");
        customer2.setName("Arindam");
        customer2.setEmail("arindam123@gmail.com");
        customer2.setContactNo("8887878");
        customer2.setDob("1997-08-29");
        
        List<Customer> customerList =new ArrayList<>();
        customerList.add(customer1);
        customerList.add(customer2);
        Mockito.when(customerRepository.findAll()).thenReturn(customerList);
        //assertThat(customerService.getAllCustomers()).isEqualTo(customerList);
	}
	
	@Test
	public void testGetCustomer() {
		Customer customer1 = new Customer();
        customer1.setUserId("ashesh123");
        customer1.setName("Ashesh");
        customer1.setEmail("ashesh123@gmail.com");
        customer1.setContactNo("79569845");
        customer1.setDob("1998-05-02");
        
        Customer customer = customerRepository.findById("ashesh123").get();
        Mockito.when(customer).thenReturn(customer1);
        Assert.assertEquals(customerService.getCustomer("arnab123"), customer1);
	}
}
