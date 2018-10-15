package com.steem.muksihs.model;

import java.math.BigInteger;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategy.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(SnakeCaseStrategy.class)
@JsonInclude(Include.NON_NULL)
public class Discussion extends Comment {
	private String url;
	private String rootTitle;
	private SteemCurrency pendingPayoutValue;
	private SteemCurrency totalPendingPayoutValue;
	private List<Vote> activeVotes;
	private List<Object> replies;
	private BigInteger authorRepution;
	private SteemCurrency promoted;
	private int bodyLength;
	private List<String> rebloggedBy;
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getRootTitle() {
		return rootTitle;
	}
	public void setRootTitle(String rootTitle) {
		this.rootTitle = rootTitle;
	}
	public SteemCurrency getPendingPayoutValue() {
		return pendingPayoutValue;
	}
	public void setPendingPayoutValue(SteemCurrency pendingPayoutValue) {
		this.pendingPayoutValue = pendingPayoutValue;
	}
	public SteemCurrency getTotalPendingPayoutValue() {
		return totalPendingPayoutValue;
	}
	public void setTotalPendingPayoutValue(SteemCurrency totalPendingPayoutValue) {
		this.totalPendingPayoutValue = totalPendingPayoutValue;
	}
	public List<Vote> getActiveVotes() {
		return activeVotes;
	}
	public void setActiveVotes(List<Vote> activeVotes) {
		this.activeVotes = activeVotes;
	}
	public List<Object> getReplies() {
		return replies;
	}
	public void setReplies(List<Object> replies) {
		this.replies = replies;
	}
	public BigInteger getAuthorRepution() {
		return authorRepution;
	}
	public void setAuthorRepution(BigInteger authorRepution) {
		this.authorRepution = authorRepution;
	}
	public SteemCurrency getPromoted() {
		return promoted;
	}
	public void setPromoted(SteemCurrency promoted) {
		this.promoted = promoted;
	}
	public int getBodyLength() {
		return bodyLength;
	}
	public void setBodyLength(int bodyLength) {
		this.bodyLength = bodyLength;
	}
	public List<String> getRebloggedBy() {
		return rebloggedBy;
	}
	public void setRebloggedBy(List<String> rebloggedBy) {
		this.rebloggedBy = rebloggedBy;
	}
	
}
