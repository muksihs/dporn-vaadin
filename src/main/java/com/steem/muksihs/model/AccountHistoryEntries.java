package com.steem.muksihs.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public class AccountHistoryEntries extends SteemJsonObject {
	
	private List<AccountHistoryEntry> list;
	
	@JsonValue
	protected List<AccountHistoryEntry> jsonValue(){
		return list;
	}
	
	@JsonCreator
	protected static AccountHistoryEntries jsonCreator(List<AccountHistoryEntry> list) {
		AccountHistoryEntries entries = new AccountHistoryEntries();
		entries.list=list;
		return entries;
	}
}
