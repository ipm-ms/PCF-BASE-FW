package com.fdc.account.bo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ACCOUNT INFORMATION")
@XmlRootElement(name = "ACCOUNT-INFORMATION")
public class AccountBO {
	
	@ApiModelProperty(required = true, name = "ACCOUNT-ID")
	@JsonProperty("ACCOUNT-ID")
	private String accountId;
	
	@ApiModelProperty(required = true, name = "ACCOUNT-DETAILS")
	@JsonProperty("ACCOUNT-DETAILS")
	private String accountDetails;
	
	@ApiModelProperty(required = true, name = "ACCOUNT-TYPE")
	@JsonProperty("ACCOUNT-TYPE")
	private String accountType;
	
	
	
	public AccountBO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AccountBO(String accountId, String accountDetails, String accountType) {
		super();
		this.accountId = accountId;
		this.accountDetails = accountDetails;
		this.accountType = accountType;
	}
	@XmlElement(name = "ACCOUNT-ID")
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	@XmlElement(name = "ACCOUNT-DETAILS")
	public String getAccountDetails() {
		return accountDetails;
	}
	public void setAccountDetails(String accountDetails) {
		this.accountDetails = accountDetails;
	}
	@XmlElement(name = "ACCOUNT-TYPE")
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
	

}
