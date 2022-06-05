package com.hatmani.DTOS;

import java.io.Serializable;
import java.math.BigDecimal;

public class AccountformDto  implements Serializable{
private BigDecimal	initialbalance;
private String currency;
private String proprietaire;
/**
 * 
 */
public AccountformDto() {
	super();
	// TODO Auto-generated constructor stub
}

public AccountformDto(BigDecimal initialbalance, String currency, String proprietaire) {
	super();
	this.initialbalance = initialbalance;
	this.currency = currency;
	this.proprietaire = proprietaire;
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
public String getProprietaire() {
	return proprietaire;
}
public void setProprietaire(String proprietaire) {
	this.proprietaire = proprietaire;
}

}
