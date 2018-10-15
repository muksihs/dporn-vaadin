package com.steem.muksihs.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class DiscussionsByAuthorBeforeDate extends QueryObject {
	private String author;
	private String startPermlink;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone="UTC")
	private Date beforeDate;
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getStartPermlink() {
		return startPermlink;
	}
	public void setStartPermlink(String startPermlink) {
		this.startPermlink = startPermlink;
	}
	public Date getBeforeDate() {
		return beforeDate;
	}
	public void setBeforeDate(Date beforeDate) {
		this.beforeDate = beforeDate;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	private int limit;
}
