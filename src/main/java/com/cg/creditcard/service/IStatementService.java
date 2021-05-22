package com.cg.creditcard.service;

import java.util.List;

import com.cg.creditcard.entity.Statement;


public interface IStatementService {
	Statement addStatement(Statement statement);
	 void removeStatement(long id);
	 Statement updateStatement(long id,Statement statement);
	 Statement getStatement(long id);
	 List<Statement> getAllStatements();
	
	
}
