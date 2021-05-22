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

import com.cg.creditcard.entity.CreditCard;


@RunWith(SpringRunner.class)
@DataJpaTest
class CreditCardRepositoryTest {

	@Autowired
	private CreditCardRepository creditCardRepository;
	
	@Autowired
	private TestEntityManager testEntityManager;
	
	@Test
	public void getCreditCardById() {
		CreditCard creditCard=new CreditCard();
		
		creditCard.setCardName("Aditya");
		creditCard.setCardNumber("1997");
		creditCard.setCardType("Visa");
		creditCard.setExpiryDate(null);
		creditCard.setCvv(003);
		creditCard.setBankName("SBI");
		
		CreditCard saveInDb = testEntityManager.persist(creditCard);
		CreditCard getInDb = creditCardRepository.findById(saveInDb.getId()).get();
		Assert.assertEquals(getInDb, saveInDb);
	}
	
	@Test
	public void getAllCreditCards() throws Exception {
		CreditCard creditCard1=new CreditCard();
		//creditCard1.setId(10);
		creditCard1.setCardName("Aditya");
		creditCard1.setCardNumber("1997");
		creditCard1.setCardType("Visa");
		creditCard1.setExpiryDate(null);
		creditCard1.setCvv(003);
		creditCard1.setBankName("SBI");
		
		CreditCard creditCard2=new CreditCard();
		//creditCard2.setId(11);
		creditCard2.setCardName("Adi");
		creditCard2.setCardNumber("1997");
		creditCard2.setCardType("Visa");
		creditCard2.setExpiryDate(null);
		creditCard2.setCvv(003);
		creditCard2.setBankName("SBI");
		
		testEntityManager.persist(creditCard1);
		testEntityManager.persist(creditCard2);
		
		List<CreditCard> customerList= (List<CreditCard>) creditCardRepository.findAll();
	}
	
	@Test
	public void addCreditCard() {
		CreditCard creditCard=new CreditCard();
		//creditCard.setId(10);
		creditCard.setCardName("Aditya");
		creditCard.setCardNumber("1997");
		creditCard.setCardType("Visa");
		creditCard.setExpiryDate(null);
		creditCard.setCvv(003);
		creditCard.setBankName("SBI");
		
		CreditCard saveInDb = testEntityManager.persist(creditCard);
		 Optional<CreditCard> getInDb = creditCardRepository.findById(saveInDb.getId());
		 Assert.assertEquals(getInDb, saveInDb);
	}
	
	@Test
	public void removeCreditCard() throws Exception{
		CreditCard creditCard1=new CreditCard();
		//creditCard1.setId(10);
		creditCard1.setCardName("Aditya");
		creditCard1.setCardNumber("1997");
		creditCard1.setCardType("Visa");
		creditCard1.setExpiryDate(null);
		creditCard1.setCvv(003);
		creditCard1.setBankName("SBI");
		
		CreditCard creditCard2=new CreditCard();
		//creditCard2.setId(10);
		creditCard2.setCardName("Aditya");
		creditCard2.setCardNumber("1997");
		creditCard2.setCardType("Visa");
		creditCard2.setExpiryDate(null);
		creditCard2.setCvv(003);
		creditCard2.setBankName("SBI");
		
		CreditCard creditCard = testEntityManager.persist(creditCard1);
	     testEntityManager.persist(creditCard2);

	        //delete one ticket DB
	        testEntityManager.remove(creditCard);

	        List<CreditCard> creditCards = (List<CreditCard>) creditCardRepository.findAll();
	        Assert.assertEquals(creditCards.size(), 1);
	}
	
	@Test
	public void updateCreditCard() throws Exception{
		CreditCard creditCard1=new CreditCard();
		//creditCard1.setId(10);
		creditCard1.setCardName("Aditya");
		creditCard1.setCardNumber("1997");
		creditCard1.setCardType("Visa");
		creditCard1.setExpiryDate(null);
		creditCard1.setCvv(003);
		creditCard1.setBankName("SBI");
		
		CreditCard saveInDb=testEntityManager.persist(creditCard1);

        CreditCard getFromDb = creditCardRepository.findById(saveInDb.getId()).get();
       // Customer getFromDb1=getFromDb.get();
        getFromDb.setId(10);
        testEntityManager.persist(getFromDb);

        Assert.assertEquals(getFromDb.getId(), 10);
	}

}
