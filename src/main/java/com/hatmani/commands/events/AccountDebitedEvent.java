package com.hatmani.commands.events;

import java.math.BigDecimal;

public class AccountDebitedEvent extends BaseEvent<String>{
private BigDecimal amount;
private String Currency;
/**
 * @param id
 * @param amount
 * @param currency
 */
public AccountDebitedEvent(String id, BigDecimal amount, String currency) {
	super(id);
	this.amount = amount;
	Currency = currency;
}
public BigDecimal getAmount() {
	return amount;
}
public void setAmount(BigDecimal amount) {
	this.amount = amount;
}
public String getCurrency() {
	return Currency;
}
public void setCurrency(String currency) {
	Currency = currency;
}


}
