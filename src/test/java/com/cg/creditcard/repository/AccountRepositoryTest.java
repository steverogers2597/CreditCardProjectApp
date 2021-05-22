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

import com.cg.creditcard.entity.Account;



@RunWith(SpringRunner.class)
@DataJpaTest
class AccountRepositoryTest {
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
    private TestEntityManager testEntityManager;

	@Test
	public void getAllAccount() throws Exception{
		Account account1 =new Account();
		//account1.setAccountId(125789656152L);
		account1.setAccountName("Ramesh tendulkar");
		account1.setBalance(65986.25);
		account1.setAccountType("Savings");
		
		Account account2 =new Account();
		//account2.setAccountId(2365789641L);
		account2.setAccountName("Hari Das");
		account2.setBalance(12546.36);
		account2.setAccountType("Current");
		
		
		testEntityManager.persist(account1);
		testEntityManager.persist(account2);
		
		List<Account> accountList= (List<Account>) accountRepository.findAll();
		
	}
	
	 
	 public Account getAccount() {
		 Account account = new Account();
		 //account.setAccountId(4569872825L);
		 account.setAccountName("Babol pal");
		 account.setBalance(12548.336);
		 account.setAccountType("Saving");
		 return account;
	 }	 
	 @Test
	 public void testNewAccount() {
		 Account account=getAccount();
		 Account saveInDb = testEntityManager.persist(account);
		 Optional<Account> getInDb = accountRepository.findById(saveInDb.getAccountId());
		 Assert.assertEquals(getInDb, saveInDb);
	 }
	
	 @Test
	 public void DeleteAccountById() throws Exception{
		 Account account1 = new Account();
		 //account1.setAccountId(1256987452L);
		 account1.setAccountName("piyush ganguly");
		 account1.setBalance(256315.25);
		 account1.setAccountType("Savings");

		 Account account2 = new Account();
		// account2.setAccountId(1254789636L);
		 account2.setAccountName("Adil");
		 account2.setBalance(25415);
		 account2.setAccountType("Current");

	     Account account = testEntityManager.persist(account1);
	     testEntityManager.persist(account2);

	        //delete one ticket DB
	        testEntityManager.remove(account);

	        List<Account> accounts = (List<Account>) accountRepository.findAll();
	        Assert.assertEquals(accounts.size(), 1);

	    }
	 
	 @Test
	    public void testUpdateCustomer(){

		Account account2 = new Account();
		 //account2.setAccountId(12548793L);
		 account2.setAccountName("lob");
		 account2.setBalance(252469);
		 account2.setAccountType("Saving");
		

	        Account saveInDb = testEntityManager.persist(account2);

	       Account getFromDb = accountRepository.findById(saveInDb.getAccountId()).get();
	        //Customer getFromDb=getFromDb.get();
	        getFromDb.setAccountId(12548793L);
	        testEntityManager.persist(getFromDb);

	        Assert.assertEquals(getFromDb.getAccountId(), 12548793L);
	    }
	 
	 @Test
	public void testGetAccountById(){
		Account account = new Account();
		//account.setAccountId(45879563214L);
		account.setAccountName("LOL");
		account.setBalance(125478.32);
		account.setAccountType("Saving");
		Account saveInDb = testEntityManager.persist(account);
		Account getInDb = accountRepository.findById(saveInDb.getAccountId()).get();
		Assert.assertEquals(getInDb, saveInDb);
			
		}

}
