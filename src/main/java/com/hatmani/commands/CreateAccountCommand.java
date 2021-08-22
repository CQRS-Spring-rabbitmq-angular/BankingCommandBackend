package com.hatmani.commands;

import java.math.BigDecimal;

import com.hatmani.commands.enums.AccountStatusEnum;

public class CreateAccountCommand extends BaseCommand<String> {
	private BigDecimal initialbalance;
	private String currency;
	private AccountStatusEnum Status;
	



	public AccountStatusEnum getStatus() {
		return Status;
	}


	public void setStatus(AccountStatusEnum status) {
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
	public CreateAccountCommand(String id, BigDecimal initialbalance, String currency, AccountStatusEnum status) {
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
