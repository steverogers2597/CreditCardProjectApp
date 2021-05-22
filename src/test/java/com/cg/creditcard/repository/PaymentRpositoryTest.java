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

import com.cg.creditcard.entity.Payment;

@RunWith(SpringRunner.class)
@DataJpaTest
class PaymentRpositoryTest {
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	@Autowired
	private TestEntityManager testEntityManager;
	
	@Test
	public void getPaymentById() {
		
		Payment payment=new Payment();
		//payment.setPaymentId(10l);
		payment.setMethod("card");
		payment.setAmountDue(4000.00);
		
		Payment saveInDb=testEntityManager.persist(payment);
		Payment getInDb=paymentRepository.findById(saveInDb.getPaymentId()).get();
		Assert.assertEquals(getInDb,saveInDb);
	}
	
	@Test
	public void addPayment() {
		
		Payment payment=new Payment();
		//payment.setPaymentId(10L);
		payment.setMethod("card");
		payment.setAmountDue(4000.00);
		Payment saveInDb=testEntityManager.persist(payment);
		Optional<Payment> getInDb = paymentRepository.findById(saveInDb.getPaymentId());
		 Assert.assertEquals(getInDb, saveInDb);
		
	}
	
	@Test
	public void removePaymentById() throws Exception{
		
		Payment payment1=new Payment();
		//payment1.setPaymentId(10L);
		payment1.setMethod("card");
		payment1.setAmountDue(4000.00);
		
		Payment payment2=new Payment();
		//payment2.setPaymentId(11L);
		payment2.setMethod("card");
		payment2.setAmountDue(40001.00);
		
		 Payment payment = testEntityManager.persist(payment1);
	     testEntityManager.persist(payment2);
	     
	     //delete one ticket DB
	        testEntityManager.remove(payment);

	        List<Payment> payments = (List<Payment>) paymentRepository.findAll();
	        Assert.assertEquals(payments.size(), 1);

	}
	
	@Test
	public void updatePayment() throws Exception {
		
		Payment payment2=new Payment();
		//payment2.setPaymentId(11L);
		payment2.setMethod("card");
		payment2.setAmountDue(40001.00);
		 Payment saveInDb=testEntityManager.persist(payment2);

	        Payment getFromDb = paymentRepository.findById(saveInDb.getPaymentId()).get();
	        
	       // Customer getFromDb1=getFromDb.get();
	        
	        getFromDb.setPaymentId(11);
	        testEntityManager.persist(getFromDb);

	        Assert.assertEquals(getFromDb.getPaymentId(),11 );
	}


	
}
