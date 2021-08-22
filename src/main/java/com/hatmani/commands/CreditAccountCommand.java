package com.hatmani.commands;

import java.math.BigDecimal;

public class CreditAccountCommand extends BaseCommand<String>{

private BigDecimal amount;
private String currency;
/**
 * @param id
 * @param amount
 * @param currency
 */
public CreditAccountCommand(String id, BigDecimal amount, String currency) {
	super(id);
	this.amount = amount;
	this.currency = currency;
}
public BigDecimal getAmount() {
	return amount;
}
public void setAmount(BigDecimal amount) {
	this.amount = amount;
}
public String getCurrency() {
	return currency;
}
public void setCurrency(String currency) {
	this.currency = currency;
}

	
	
}
