package com.steem.muksihs.model;

public class BlogEntryQuery extends QueryObject {
	private String account;
	private long startEntryId;
	public long getStartEntryId() {
		return startEntryId;
	}
	public void setStartEntryId(long startEntryId) {
		this.startEntryId = startEntryId;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	private int limit;
}
