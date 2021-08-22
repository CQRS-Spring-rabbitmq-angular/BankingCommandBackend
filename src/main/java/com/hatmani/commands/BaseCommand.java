package com.hatmani.commands;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public abstract class BaseCommand<T> {
	 //lid sur la quell sexecute la commande
		//il correspond a l'id de lagrega
		@TargetAggregateIdentifier
		private T id;

		public T getId() {
			return id;
		}

		public BaseCommand(T id) {
			 
			this.id = id;
		}

		

	
}
