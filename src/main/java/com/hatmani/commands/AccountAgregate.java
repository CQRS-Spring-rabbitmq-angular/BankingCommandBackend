package com.hatmani.commands;

import java.math.BigDecimal;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.stereotype.Service;



import com.hatmani.commands.exception.SoldeInsuffisantException;
import com.hatmani.bankingEvent.*;
@Aggregate

public class AccountAgregate {
	@AggregateIdentifier
private String AccountId;
private BigDecimal Balance;
private StatusAcount Status;
private String Currency;


@CommandHandler
public AccountAgregate(CreateAccountCommand command)
{
	AggregateLifecycle.apply(new AccountCreatedEvent(command.getId(),command.getInitialbalance(),command.getCurrency(),command.getStatus()));

}
@EventSourcingHandler
public void on(AccountCreatedEvent event)
{
	this.AccountId=event.getId();
	this.Balance =event.getInitialAccount();
	this.Currency =event.getCurrency();
	this.Status=event.getStatus();
	AggregateLifecycle.apply(new AccountActivetedEvent(this.AccountId,StatusAcount.ACTIVE));
}
@EventSourcingHandler
public void on(AccountActivetedEvent event)
{
	this.Status=event.getStatus();
}

@CommandHandler
public void handle(CreditAccountCommand command)
{
	AggregateLifecycle.apply(new AccountCreditedEvent(command.getId(),command.getAmount()
			,command.getCurrency()));
}

@EventSourcingHandler
public void on(AccountCreditedEvent event)
{
      this.Balance =this.Balance.add(event.getAmount());


}
@CommandHandler
public void handle(DebitAccountCommand event)
{
	if(this.Balance.subtract(event.getAmount()).doubleValue()<0) 
		throw new SoldeInsuffisantException("Solde Insufisant pour debiter");
AggregateLifecycle.apply(new AccountDebitedEvent(event.getId(),event.getAmount(),event.getCurrency()));
}

@EventSourcingHandler
public void on(AccountDebitedEvent event)
{System.out.println("Debited event received");
	this.Balance=this.Balance.subtract(event.getAmount());
}
/**
 * 
 */
public AccountAgregate() {
	super();
	// TODO Auto-generated constructor stub
}
public String getAccountId() {
	return AccountId;
}
public void setAccountId(String accountId) {
	AccountId = accountId;
}
public BigDecimal getBalance() {
	return Balance;
}
public void setBalance(BigDecimal balance) {
	Balance = balance;
}
public StatusAcount getStatus() {
	return Status;
}
public void setStatus(StatusAcount status) {
	Status = status;
}
public String getCurrency() {
	return Currency;
}
public void setCurrency(String currency) {
	Currency = currency;
}

}
