package com.hatmani.API;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventhandling.DomainEventMessage;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.axonframework.messaging.interceptors.ExceptionHandler;
//import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hatmani.DTOS.AccountformDto;
import com.hatmani.DTOS.OperationDto;
import com.hatmani.commands.CreateAccountCommand;
import com.hatmani.commands.CreditAccountCommand;
import com.hatmani.commands.DebitAccountCommand;
import com.hatmani.commands.enums.AccountStatusEnum;

@RestController
@RequestMapping("/commands/account")

public class CommandRestController {
	
	@Autowired
	CommandGateway commandgatway;
	@Autowired
	EventStore eventstore;
	@Autowired
	Exchange exchange;
	@Autowired
	RabbitTemplate rabittemplate;
	@PostMapping("/create")
	public CompletableFuture<String> create(@RequestBody AccountformDto account)
	{
		System.out.println("Create Command recived : "+account.toString());
		//rabittemplate.convertAndSend(exchange.getName(),"Account.Created",account);
		
return		commandgatway.send(new CreateAccountCommand(
		UUID.randomUUID().toString(),account.getInitialbalance(), account.getCurrency()
		,AccountStatusEnum.INACTIVE));
	}
	@PostMapping("/credit/{AccountId}")
	public CompletableFuture<String> credit(@PathVariable String AccountId,@RequestBody OperationDto operation)
	//public CompletableFuture<String> credit(@PathVariable String AccountId, @RequestBody OperationDto operation)
	{//String AccountId="74be1ebd-e25b-4b1a-9fba-fff72ea7c4bc";
		System.out.println("Command recived : "+AccountId+operation.toString());
		return commandgatway.send(new CreditAccountCommand(AccountId, operation.getAmount(),operation.getCurrency()));
	}
	
	@PostMapping("/debit/{AccountId}")
	public CompletableFuture<String> debit(@PathVariable String AccountId,@RequestBody OperationDto operation)
	{
		System.out.println("Debit cmd received"+operation.toString());
		return commandgatway.send(new DebitAccountCommand(AccountId, operation.getAmount(),operation.getCurrency()));
	}
	@GetMapping("/events/{AccountId}")
	public Stream events(@PathVariable String AccountId)
	{
		return eventstore.readEvents(AccountId).asStream();
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
	public ResponseEntity<String> senderrors(Exception exp)
	{
		return new ResponseEntity<String>(exp.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}

	
	
	
}
