package com.cg.creditcard.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.creditcard.entity.Account;
import com.cg.creditcard.entity.Statement;

import com.cg.creditcard.repository.StatementRepository;
import com.cg.creditcard.service.IStatementService;


@Service
public class StatementService implements IStatementService{
	@Autowired
	StatementRepository statementRepository;
	
	public List< Statement> getAllStatements(){
		List<Statement> statemnentList= statementRepository.findAll();
		
		return statemnentList;
	}
	
	public Statement getStatement(long statementId) {
		Optional<Statement> optional = statementRepository.findById(statementId);
		if(!optional.isPresent()) {
			return null;
		}
		return optional.get();
	}
	
	public Statement addStatement(Statement statement) {
		
		return statementRepository.saveAndFlush(statement);
		
	}
	
	public void removeStatement(long statementId) {
		
		statementRepository.deleteById(statementId);
	}
	
	public Statement updateStatement(long statementId,Statement statement) {
		

		Optional<Statement> optional = statementRepository.findById(statementId);
		if(!optional.isPresent()) {
			
			return null;
		}
		statement=optional.get();
		return statementRepository.save(statement);
	}

}
