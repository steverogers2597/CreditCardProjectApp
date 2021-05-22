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
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.creditcard.entity.Address;
import com.cg.creditcard.entity.Customer;

@RunWith(SpringRunner.class)
@DataJpaTest
class AddressRepositoryTest {
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
    private TestEntityManager testEntityManager;


	@Test
	public void getAllAddress() throws Exception{
		Address address1 =new Address();
		address1.setDoorNo("b/26 bakultala");
		address1.setStreet("kabi subhas road");
		address1.setArea("paskura area");
		address1.setCity("birbhum");
		address1.setState("west bengal");
		address1.setPincode(888888);
		
		Address address2 =new Address();
		address2.setDoorNo("c/2");
		address2.setStreet("kaji najrul");
		address2.setArea("suri");
		address2.setCity("birbhum");
		address2.setState("west bengal");
		address2.setPincode(123658);
		

		testEntityManager.persist(address1);
		testEntityManager.persist(address2);

		List<Address> addressList= (List<Address>) addressRepository.findAll();
		
	}
	 public Address getAddress() {
		 Address address = new Address();
		 address.setDoorNo("33");
		 address.setStreet("lal nagar");
		 address.setArea("gopalpur");
		 address.setCity("suri");
		 address.setState("bengal");
		 address.setPincode(789654);
		  
		 return address;
		 
	 }	 
	 @Test
	 public void testNewAddress() {
		 Address address=getAddress();
		 Address saveInDb = testEntityManager.persist(address);
		 Optional<Address> getInDb = addressRepository.findById(saveInDb.getAddressId());
		 Assert.assertEquals(getInDb, saveInDb);
	 }
	
	 @Test
	 public void DeleteAddressById() throws Exception{
		 Address address1 = new Address();
		 address1.setDoorNo("v-4");
		 address1.setStreet("sushantsinghroad");
		 address1.setArea("bolpur");
		 address1.setCity("rampurhat");
		 address1.setState("West bengal");
		 address1.setPincode(456987);

		 Address address2 = new Address();
		 address2.setDoorNo("92/e");
		 address2.setStreet("Birolata road");
		 address2.setArea("sahapur");
		 address2.setCity("Birbhum");
		 address2.setState("bengal");
		 address2.setPincode(125896);

		 Address address = testEntityManager.persist(address1);
	     testEntityManager.persist(address2);

	        //delete one ticket DB
	        testEntityManager.remove(address);

	        List<Address> addresss = (List<Address>) addressRepository.findAll();
	        Assert.assertEquals(addresss.size(), 1);

	    }

	 @Test
	    public void testUpdateAddress(){

		 Address address2 = new Address();
		 address2.setDoorNo("78/11");
		 address2.setStreet("sahapur");
		 address2.setArea("kalyan para");
		 address2.setCity("suri");
		 address2.setState("bengal");
		 address2.setPincode(326589);

	       Address saveInDb = testEntityManager.persist(address2);

	       Address getFromDb = addressRepository.findById(saveInDb.getAddressId()).get();
	        //Customer getFromDb=getFromDb.get();
	        getFromDb.setAddressId(326598);
	        testEntityManager.persist(getFromDb);

	        Assert.assertEquals(getFromDb.getPincode(), 326589);
	    }
	 
	 @Test
	public void testGetAddressById(){
		Address address = new Address();
		address.setDoorNo("65");
		address.setStreet("nonshanka");
		address.setArea("das para");
		address.setCity("daspur");
		address.setState("kolkata");
		address.setPincode(369589);
		Address saveInDb = testEntityManager.persist(address);
		Address getInDb = addressRepository.findById(saveInDb.getAddressId()).get();
		Assert.assertEquals(getInDb, saveInDb);
			
		}

}