package com.hatmani.commands.events;

import java.math.BigDecimal;

import com.hatmani.commands.enums.AccountStatusEnum;

public class AccountCreatedEvent extends BaseEvent<String> {
private BigDecimal initialAccount;
private String Currency;
private AccountStatusEnum status;
/**
 * @param id
 * @param initialAccount
 * @param currency
 * @param status
 */
public AccountCreatedEvent(String id, BigDecimal initialAccount, String currency, AccountStatusEnum status) {
	super(id);
	this.initialAccount = initialAccount;
	Currency = currency;
	this.status = status;
}
public BigDecimal getInitialAccount() {
	return initialAccount;
}
public void setInitialAccount(BigDecimal initialAccount) {
	this.initialAccount = initialAccount;
}
public String getCurrency() {
	return Currency;
}
public void setCurrency(String currency) {
	Currency = currency;
}
public AccountStatusEnum getStatus() {
	return status;
}
public void setStatus(AccountStatusEnum status) {
	this.status = status;
}
	
}
