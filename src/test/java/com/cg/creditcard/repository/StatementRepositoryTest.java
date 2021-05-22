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

import com.cg.creditcard.entity.Statement;


@RunWith(SpringRunner.class)
@DataJpaTest
class StatementRepositoryTest {
	@Autowired
	private StatementRepository statementRepository;
	
	@Autowired
    private TestEntityManager testEntityManager;

	@Test
	public void testgetAllStatements(){
		Statement statement1 =new Statement();
		//statement1.setStatementId(1234l);
		statement1.setDueAmount(1000d);
		statement1.setBillingDate("2021-05-19");
		statement1.setDueDate("2021-05-19");
		
		Statement statement2 =new Statement();
		//statement2.setStatementId(12345l);
		statement2.setDueAmount(2000d);
		statement2.setBillingDate("2021-05-19");
		statement2.setDueDate("2021-05-19");
		
		testEntityManager.persist(statement1);
		testEntityManager.persist(statement2);
		
		List<Statement> statementList= (List<Statement>) statementRepository.findAll();
		
	}
	
	 
	 public Statement getStatement() {
		 Statement statement = new Statement();
		// statement.setStatementId(1234l);
		 statement.setDueAmount(1000d);
		 statement.setBillingDate("2021-05-19");
		 statement.setDueDate("2021-05-19");
	
		 return statement;
	 }	 
	 @Test
	 public void testaddStatement() {
		 Statement statement=getStatement();
		 Statement saveInDb = testEntityManager.persist(statement);
		 Optional<Statement> getInDb = statementRepository.findById(saveInDb.getStatementId());
		 Assert.assertEquals(getInDb, saveInDb);
	 }
	
	 @Test
	 public void testDeleteStatementById(){
		 Statement statement1 =new Statement();
			//statement1.setStatementId(1234l);
			statement1.setDueAmount(1000d);
			statement1.setBillingDate("2021-05-19");
			statement1.setDueDate("2021-05-19");

		 Statement statement2 =new Statement();
			//statement2.setStatementId(12345l);
			statement2.setDueAmount(2000d);
			statement2.setBillingDate("2021-05-19");
			statement2.setDueDate("2021-05-19");

		 Statement statement = testEntityManager.persist(statement1);
	     testEntityManager.persist(statement2);

	        //delete one ticket DB
	        testEntityManager.remove(statement);

	        List<Statement> statements = (List<Statement>) statementRepository.findAll();
	        Assert.assertEquals(statements.size(), 1);

	    }
	 
	 @Test
	    public void testUpdateStatement(){

		 Statement statement1 = new Statement();
		 //statement1.setStatementId(1234l);
		 statement1.setDueAmount(1000d);
		 statement1.setBillingDate("2021-05-19");
		 statement1.setDueDate("2021-05-19");

	       Statement saveInDb=testEntityManager.persist(statement1);

	        Statement getFromDb = statementRepository.findById(saveInDb.getStatementId()).get();
	       
	        getFromDb.setStatementId(1234l);
	        testEntityManager.persist(getFromDb);

	        Assert.assertEquals(getFromDb.getStatementId(), 1234l);
	    }
	@Test 
	public void testGetStatementById() {
		 Statement statement1 = new Statement();
		 //statement1.setStatementId(1234l);
		 statement1.setDueAmount(1000d);
		 statement1.setBillingDate("2021-05-19");
		 statement1.setDueDate("2021-05-19");
		 Statement saveInDb = testEntityManager.persist(statement1);
		Optional<Statement> getInDb = statementRepository.findById(saveInDb.getStatementId());
		Assert.assertEquals(getInDb, saveInDb);
			
		}

}
