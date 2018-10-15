package com.steem.muksihs.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public class AccountHistoryParam extends QueryObject {
	private String account;
	private long start;
	private int limit;
	@JsonValue
	protected List<Object> jsonValue(){
		List<Object> list = new ArrayList<>();
		list.add(account);
		list.add(start);
		list.add(limit);
		return list;
	}
	@JsonCreator
	protected static AccountHistoryParam jsonCreator(List<Object> list) {
		AccountHistoryParam param = new AccountHistoryParam();
		if (list==null) {
			return null;
		}
		Iterator<Object> iList = list.iterator();
		if (iList.hasNext()) {
			Object next = iList.next();
			param.setAccount(next==null?null:String.valueOf(next));
		}
		if (iList.hasNext()) {
			Object next = iList.next();
			try {
				param.setStart(Long.valueOf(next==null?null:String.valueOf(next)));
			} catch (NumberFormatException e) {
			}
		}
		if (iList.hasNext()) {
			Object next = iList.next();
			try {
				param.setLimit(Integer.valueOf(next==null?null:String.valueOf(next)));
			} catch (NumberFormatException e) {
			}
		}
		return param;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public long getStart() {
		return start;
	}
	public void setStart(long start) {
		this.start = start;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
}
