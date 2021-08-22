package com.hatmani.commands;

import java.math.BigDecimal;

import com.hatmani.bankingEvent.StatusAcount;


public class CreateAccountCommand extends BaseCommand<String> {
	private BigDecimal initialbalance;
	private String currency;
	private StatusAcount Status;
	



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
	public CreateAccountCommand(String id, BigDecimal initialbalance, String currency, StatusAcount status) {
		super(id);
		this.initialbalance = initialbalance;
		this.currency = currency;
		Status = status;
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

	

}
