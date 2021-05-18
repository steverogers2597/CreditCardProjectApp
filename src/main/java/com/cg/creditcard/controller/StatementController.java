package com.cg.creditcard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.creditcard.model.AccountDTO;
import com.cg.creditcard.model.StatementDTO;
import com.cg.creditcard.service.IStatementService;

@RestController
public class StatementController {
	@Autowired
	IStatementService statementService;
	
	@PostMapping("/addStatement")
	public ResponseEntity addStatement(@RequestBody StatementDTO statementdto) {
		statementService.addStatement(statementdto);
		return new ResponseEntity("Statement added successfully!",HttpStatus.OK);
	}
	@DeleteMapping("/removeStatement/{id}")
	public ResponseEntity removeAccount(@RequestBody @PathVariable("id")long id) {
		statementService.removeStatement(id);
		return new ResponseEntity("Statement removed Successfully!",HttpStatus.OK);
	}
	@PutMapping("/updateStatement/{id}")
	public ResponseEntity updateStatement(@RequestBody @PathVariable("id")long id,StatementDTO statementdto) {
		statementService.updateStatement(id, statementdto);
		return new ResponseEntity("Statement updated successfully!",HttpStatus.OK);
	}
	@GetMapping("/getStatementById/{id}")
	public ResponseEntity getAccountById(@PathVariable("id")long id) {
		StatementDTO statement = statementService.getStatement(id);
		return new ResponseEntity(statement,HttpStatus.OK);
	}
	@GetMapping("/getAllStatements")
	public ResponseEntity getAllStatements(){
		List<StatementDTO> statements = statementService.getAllStatements();
		ResponseEntity response = new ResponseEntity(statements,HttpStatus.OK);
		return response;
	}
}
