package com.hatmani.DTOS;

import java.math.BigDecimal;

public class OperationDto {
private BigDecimal Amount;
private String Currency;
/**
 * 
 */
public OperationDto() {
	
}
/**
 * @param amount
 * @param currency
 */
public OperationDto(BigDecimal amount, String currency) {
	super();
	Amount = amount;
	Currency = currency;
}
@Override
public String toString() {
	return "OperationDto [Amount=" + Amount + ", Currency=" + Currency + "]";
}
public BigDecimal getAmount() {
	return Amount;
}
public void setAmount(BigDecimal amount) {
	Amount = amount;
}
public String getCurrency() {
	return Currency;
}
public void setCurrency(String currency) {
	Currency = currency;
}


}
