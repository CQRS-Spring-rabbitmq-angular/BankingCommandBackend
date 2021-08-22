package com.hatmani;

import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.amqp.core.*;

@SpringBootApplication
public class BankingCqrsCmd2Application {

	public static void main(String[] args) {
		SpringApplication.run(BankingCqrsCmd2Application.class, args);
	}

	@Bean
	public Exchange exchange()
	{
		return ExchangeBuilder.fanoutExchange("AccountEvent2").build();
	}
	@Bean
	public Queue queue()
	{
		return QueueBuilder.durable("AccountEvent2").build();
	}
	@Bean
	public Binding binding()
	{
		return BindingBuilder.bind(queue()).to(exchange()).with("*").noargs();
	}
	
	@Autowired
	public void configure(AmqpAdmin admin)
	{
		admin.declareExchange(exchange());
		admin.declareQueue(queue());
		admin.declareBinding(binding());

	}
}
