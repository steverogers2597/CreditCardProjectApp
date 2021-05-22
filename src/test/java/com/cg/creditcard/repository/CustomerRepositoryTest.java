package com.cg.creditcard.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.creditcard.entity.Customer;


@RunWith(SpringRunner.class)
@DataJpaTest
class CustomerRepositoryTest {
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
    private TestEntityManager testEntityManager;

	@Test
	public void getAllCustomers() throws Exception{
		Customer customer1 =new Customer();
		customer1.setUserId("arnab123");
		customer1.setName("Arnab");
		customer1.setEmail("arnab@gmail.com");
		customer1.setContactNo("88888888");
		customer1.setDob("1997-10-12");
		
		Customer customer2 =new Customer();
		customer2.setUserId("ashesh123");
		customer2.setName("Ashesh");
		customer2.setEmail("ashesh@gmail.com");
		customer2.setContactNo("77777777");
		customer2.setDob("1998-11-10");
		
		testEntityManager.persist(customer1);
		testEntityManager.persist(customer2);
		
		List<Customer> customerList= (List<Customer>) customerRepository.findAll();
		
	}
	
	 
	 public Customer getCustomer() {
		 Customer customer = new Customer();
		 customer.setUserId("arindam012");
		 customer.setName("Arindam");
		 customer.setEmail("arindam07@gmail.com");
		 customer.setContactNo("55555555");
		 customer.setDob("1998-06-24");
		 return customer;
	 }	 
	 @Test
	 public void testNewCustomer() {
		 Customer customer=getCustomer();
		 Customer saveInDb = testEntityManager.persist(customer);
		 Optional<Customer> getInDb = customerRepository.findById(saveInDb.getUserId());
		 Assert.assertEquals(getInDb, saveInDb);
	 }
	
	 @Test
	 public void DeleteCustomerById() throws Exception{
		 Customer customer1 = new Customer();
		 customer1.setUserId("arindam012");
		 customer1.setName("Arindam");
		 customer1.setEmail("arindam07@gmail.com");
		 customer1.setContactNo("33333333");
		 customer1.setDob("1998-06-24");

		 Customer customer2 = new Customer();
		 customer2.setUserId("ashesh012");
		 customer2.setName("Ashesh");
		 customer2.setEmail("ashesh007@gmail.com");
		 customer2.setContactNo("44444444");
		 customer2.setDob("1997-07-21");

	     Customer customer = testEntityManager.persist(customer1);
	     testEntityManager.persist(customer2);

	        //delete one ticket DB
	        testEntityManager.remove(customer);

	        List<Customer> customers = (List<Customer>) customerRepository.findAll();
	        Assert.assertEquals(customers.size(), 1);

	    }
	 
	 @Test
	    public void testUpdateCustomer() throws Exception{

		 Customer customer2 = new Customer();
		 customer2.setUserId("ashesh012");
		 customer2.setName("Ashesh");
		 customer2.setEmail("ashesh007@gmail.com");
		 customer2.setContactNo("44444444");
		 customer2.setDob("1997-07-21");

	        testEntityManager.persist(customer2);

	        Customer getFromDb = customerRepository.findById("ashesh012").get();       
	        getFromDb.setUserId("ashesh");
	        testEntityManager.persist(getFromDb);

	        Assert.assertEquals(getFromDb.getUserId(), "ashesh");
	    }
	 
	 @Test
	public void testGetCustomerById() {
		Customer customer = new Customer();
		customer.setUserId("aditya012");
		customer.setName("Aditya");
		customer.setEmail("aditya07@gmail.com");
		customer.setContactNo("66666666");
		customer.setDob("1997-12-12");
		Customer saveInDb = testEntityManager.persist(customer);
		Customer getInDb = customerRepository.findById(saveInDb.getUserId()).get();
		Assert.assertEquals(getInDb, saveInDb);
			
		}

}
