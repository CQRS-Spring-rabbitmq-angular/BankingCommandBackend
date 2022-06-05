package com.hatmani.commands;

import java.math.BigDecimal;

import com.hatmani.bankingEvent.StatusAcount;


public class CreateAccountCommand extends BaseCommand<String> {
	private BigDecimal initialbalance;
	private String currency;
	private StatusAcount Status;
	private String proprietaire;



	public StatusAcount getStatus() {
		return Status;
	}


	public void setStatus(StatusAcount status) {
		Status = status;
	}


	public BigDecimal getInitialbalance() {
		return initialbalance;
	}


	/**
	 * @param id
	 * @param initialbalance
	 * @param currency
	 * @param status
	 */
	public CreateAccountCommand(String id, BigDecimal initialbalance, String currency, StatusAcount status,String proprietaire) {
		super(id);
		this.initialbalance = initialbalance;
		this.currency = currency;
		Status = status;
		this.proprietaire=proprietaire;
	}


	public void setInitialbalance(BigDecimal initialbalance) {
		this.initialbalance = initialbalance;
	}


	public String getCurrency() {
		return currency;
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
