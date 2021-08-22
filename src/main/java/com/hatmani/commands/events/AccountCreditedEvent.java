package com.hatmani.commands.events;

import java.math.BigDecimal;

public class AccountCreditedEvent extends BaseEvent<String>{
private BigDecimal amount;
private String Currency;
/**
 * @param id
 * @param amount
 * @param currency
 */
public AccountCreditedEvent(String id, BigDecimal amount, String currency) {
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
@Override
public String toString() {
	return super.toString()+ "AccountCreditedCommand [amount=" + amount + ", Currency=" + Currency + "]";
}

}
