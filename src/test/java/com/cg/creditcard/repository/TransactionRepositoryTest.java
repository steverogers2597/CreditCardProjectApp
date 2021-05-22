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
import com.cg.creditcard.entity.Statement;
import com.cg.creditcard.entity.Transaction;


@RunWith(SpringRunner.class)
@DataJpaTest
class TransactionRepositoryTest {
	@Autowired
	private TransactionRepository transactionRepository;
	
	@Autowired
    private TestEntityManager testEntityManager;

	@Test
	public void getAllTransactions() throws Exception{
		Transaction transaction1 =new Transaction();
		//transaction1.setTranId(1234l);
		transaction1.setCardNumber("abc123");
		transaction1.setStatus("active");
		transaction1.setAmount(10000);
		transaction1.setPaymentMethod("online");
		transaction1.setDescription("My Description");
		
		Transaction transaction2 =new Transaction();
		//transaction2.setTranId(1234l);
		transaction2.setCardNumber("abc123");
		transaction2.setStatus("active");
		transaction2.setAmount(10000);
		transaction2.setPaymentMethod("online");
		transaction1.setDescription("My Description");
		
		testEntityManager.persist(transaction1);
		testEntityManager.persist(transaction2);
		
		List<Transaction> customerList= (List<Transaction>) transactionRepository.findAll();
		
	}
	
	 @Test
	 public Transaction getTransaction() {
		 Transaction transaction1 = new Transaction();
		 //transaction1.setTranId(1234l);
			transaction1.setCardNumber("abc123");
			transaction1.setStatus("active");
			transaction1.setAmount(10000);
			transaction1.setPaymentMethod("online");
			transaction1.setDescription("My Description");
		 return transaction1;
	 }	 
	 @Test
	 public void testNewTransaction() {
		 Transaction transaction=getTransaction();
		 Transaction saveInDb = testEntityManager.persist(transaction);
		 Optional<Transaction> getInDb = transactionRepository.findById(saveInDb.getTranId());
		 Assert.assertEquals(getInDb, saveInDb);
	 }
	
	 @Test
	 public void DeleteTransactionById() throws Exception{
			Transaction transaction1 =new Transaction();
			//transaction1.setTranId(1234l);
			transaction1.setCardNumber("abc123");
			transaction1.setStatus("active");
			transaction1.setAmount(10000);
			transaction1.setPaymentMethod("online");
			transaction1.setDescription("My Description");

			Transaction transaction2 =new Transaction();
			//transaction2.setTranId(1234l);
			transaction2.setCardNumber("abc123");
			transaction2.setStatus("active");
			transaction2.setAmount(10000);
			transaction2.setPaymentMethod("online");
			transaction2.setDescription("My Description");
			

			Transaction transaction = testEntityManager.persist(transaction1);
	        testEntityManager.persist(transaction2);

	        //delete one ticket DB
	        testEntityManager.remove(transaction);

	        List<Transaction> transactions = (List<Transaction>) transactionRepository.findAll();
	        Assert.assertEquals(transactions.size(), 1);

	    }
	 
	 @Test
	    public void testUpdateTransaction() throws Exception{

			Transaction transaction2 =new Transaction();
			//transaction2.setTranId(123456l);
			transaction2.setCardNumber("xyz123");
			transaction2.setStatus("in-active");
			transaction2.setAmount(10000);
			transaction2.setPaymentMethod("offline");
			transaction2.setDescription("My Description");

			Transaction saveInDb=testEntityManager.persist(transaction2);

	        Transaction getFromDb = transactionRepository.findById(saveInDb.getTranId()).get();
	       
	        getFromDb.setTranId(123456);
	        testEntityManager.persist(getFromDb);

	        Assert.assertEquals(getFromDb.getTranId(), 123456);
	    }
	 
	 @Test
	public void testGettransactionById() throws Exception{
			Transaction transaction1 =new Transaction();
			//transaction1.setTranId(1234l);
			transaction1.setCardNumber("abc123");
			transaction1.setStatus("active");
			transaction1.setAmount(10000);
			transaction1.setPaymentMethod("online");
			transaction1.setDescription("My Description");
			Transaction saveInDb = testEntityManager.persist(transaction1);
		Optional<Transaction> getInDb = transactionRepository.findById(saveInDb.getTranId());
		Assert.assertEquals(getInDb, saveInDb);
			
		}

}

