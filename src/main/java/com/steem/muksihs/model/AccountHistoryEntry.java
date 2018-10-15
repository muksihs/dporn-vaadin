package com.steem.muksihs.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public class AccountHistoryEntry {
	@JsonValue
	protected List<Object> jsonValue() {
		List<Object> list = new ArrayList<>();
		list.add(id);
		list.add(getTransaction());
		return list;
	}
	
	//TODO
	@SuppressWarnings("unchecked")
	@JsonCreator
	protected static AccountHistoryEntry jsonCreator(List<Object> list) {
		if (list==null) {
			return null;
		}
		AccountHistoryEntry entry = new AccountHistoryEntry();
		Iterator<Object> iList = list.iterator();
		if (iList.hasNext()) {
			Object next = iList.next();
			long id;
			try {
				id = Long.valueOf(String.valueOf(next));
				entry.setId(id);
			} catch (NumberFormatException e) {
			}
		}
		if (iList.hasNext()) {
			Object next = iList.next();
			if (next instanceof Map) {
				Transaction transaction = new Transaction();
				transaction.getProperties().putAll((Map<String, ?>)next);
				entry.setTransaction(transaction);
			}
		}
		return entry;
	}
	
	private long id;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Transaction getTransaction() {
		return transaction;
	}
	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}
	private Transaction transaction;
}
