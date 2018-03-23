package com.fdc.account.bl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.fdc.account.bo.AccountBO;

@Service("contanerManagedAccountBL")
public class AccountBL {

	public AccountBO getAccount(String id) {
		return new AccountBO(UUID.randomUUID().toString(), "Account details", "SAVINGS");
	}
}
