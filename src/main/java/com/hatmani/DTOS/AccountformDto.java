package com.hatmani.DTOS;

import java.io.Serializable;
import java.math.BigDecimal;

public class AccountformDto  implements Serializable{
private BigDecimal	initialbalance;
private String currency;
/**
 * 
 */
public AccountformDto() {
	super();
	// TODO Auto-generated constructor stub
}
/**
 * @param initialbalance
 * @param currency
 */
public AccountformDto(BigDecimal initialbalance, String currency) {
	super();
	this.initialbalance = initialbalance;
	this.currency = currency;
}
public BigDecimal getInitialbalance() {
	return initialbalance;
}
public void setInitialbalance(BigDecimal initialbalance) {
	this.initialbalance = initialbalance;
}
public String getCurrency() {
	return currency;
}

@Override
public String toString() {
	return "AccountformDto [initialbalance=" + initialbalance + ", currency=" + currency + "]";
}
public void setCurrency(String currency) {
	this.currency = currency;
}

}
