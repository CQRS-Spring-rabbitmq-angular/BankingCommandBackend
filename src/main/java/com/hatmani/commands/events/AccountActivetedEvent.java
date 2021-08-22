package com.hatmani.commands.events;

import com.hatmani.commands.enums.AccountStatusEnum;

public class AccountActivetedEvent extends BaseEvent<String>{
private AccountStatusEnum status;

/**
 * @param id
 * @param status
 */
public AccountActivetedEvent(String id, AccountStatusEnum status) {
	super(id);
	this.status = status;
}

public AccountStatusEnum getStatus() {
	return status;
}

public void setStatus(AccountStatusEnum status) {
	this.status = status;
}

	
}
