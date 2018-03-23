package com.fdc.account.controller;




import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fdc.account.bl.AccountBL;
import com.fdc.account.bo.AccountBO;
import com.fdc.account.bo.ExceptionBO;
import com.fdc.account.bo.ValidationBO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/search")
@Api(value = "Search", description = "Operations pertaining to search")
public class AccountController {
	private static final Logger logger = LoggerFactory.getLogger(AccountController.class);
	//private static final Logger logger = Logger.getLogger(AccountController.class);
	
	@Autowired
	@Qualifier("contanerManagedAccountBL")
	private AccountBL accountBL;
	
	@CrossOrigin
	@ApiOperation(value = "Get Account Details", response = AccountBO.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Account details", response = AccountBO.class),
			@ApiResponse(code = 500, message = "Error Fetching", response = ExceptionBO.class),
			@ApiResponse(code = 400, message = "Validation Failed", response = ValidationBO.class) })
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<?> getAccountInformation(@ApiParam(value = "Account Id", required = true) @PathVariable("id") String id) {
		logger.debug("The account id is -->"+id);
		return new ResponseEntity<AccountBO>(accountBL.getAccount(id),HttpStatus.OK);
	}

}
