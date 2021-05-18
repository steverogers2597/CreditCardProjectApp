package com.cg.creditcard.service;

import java.util.List;

import com.cg.creditcard.entity.Statement;
import com.cg.creditcard.model.StatementDTO;

public interface IStatementService {
	 void addStatement(StatementDTO statementdto);
	 void removeStatement(long id);
	 void updateStatement(long id,StatementDTO statementdto);
	 StatementDTO getStatement(long id);
	 List<StatementDTO> getAllStatements();
	
	
}
