package com.fdc.jdbc;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fdc.jdbc.dao.Account;
import com.fdc.jdbc.repository.AccountRepository;

@RestController
@RequestMapping("/")
public class PoCController {

	@Autowired
	@Qualifier("springManagedServerRepository")
	private AccountRepository acccRepo;

	@Transactional
	@RequestMapping(value = "/account", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<Account> getAllAccounts() {
		if (acccRepo.findAll().size() == 0) {
			Account acccount = new Account();
			acccount.setAccountId(UUID.randomUUID().toString());
			acccount.setAccountHolderName("Harry Potter");
			acccount.setAccountDescription("Hogwarts Daily Bank");
			acccRepo.saveAndFlush(acccount);

		}

		return acccRepo.findAll();
	}

}
