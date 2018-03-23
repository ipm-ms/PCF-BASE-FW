package com.fdc.jdbc.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ACCOUNT")
public class Account {

	private String accountId;

	private String accountHolderName;
	private String accountDescription;

	@Id
	@Column(name = "ACCOUNT_ID", unique = true, nullable = false, length = 50)
	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	@Column(name = "ACC_HOLDER_NAME", nullable = false, length = 100)
	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	@Column(name = "ACC_DESC", nullable = true, length = 100)
	public String getAccountDescription() {
		return accountDescription;
	}

	public void setAccountDescription(String accountDescription) {
		this.accountDescription = accountDescription;
	}

}
