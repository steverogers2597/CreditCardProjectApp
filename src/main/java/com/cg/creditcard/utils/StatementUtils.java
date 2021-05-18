package com.cg.creditcard.utils;

import java.util.ArrayList;
import java.util.List;

import com.cg.creditcard.entity.Statement;
import com.cg.creditcard.model.StatementDTO;

public class StatementUtils {
	
		public static List<StatementDTO> convertToStatementDtoList(List<Statement> list)
		{
			List<StatementDTO> dtoList=new ArrayList<StatementDTO>();
			for(Statement statement : list)
			{
				dtoList.add(convertToStatementDto(statement));
			}
			return dtoList;
		}

		public static StatementDTO convertToStatementDto(Statement statement) 
		{
			StatementDTO statementDto=new StatementDTO();
			statementDto.setStatementId(statement.getStatementId());
			statementDto.setDueAmount(statement.getDueAmount());
			statementDto.setBillingDate(statement.getBillingDate());
			statementDto.setDueDate(statement.getDueDate());
			
			return statementDto;
		}
		
		public static Statement convertToStatement(StatementDTO statementDto)
		{
			Statement statement=new Statement();
			statement.setStatementId(statementDto.getStatementId());
			statement.setDueAmount(statementDto.getDueAmount());
			statement.setBillingDate(statementDto.getBillingDate());
			statement.setDueDate(statementDto.getDueDate());
			return statement;
		}

}
