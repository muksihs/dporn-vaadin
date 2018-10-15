package com.steem.muksihs.model;

import java.math.BigInteger;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Vote extends SteemJsonObject {
	private String voter;
	private BigInteger weight;
	private BigInteger rshares;
	private int percent;
	private BigInteger reputation;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone="UTC")
	private Date time;
	public String getVoter() {
		return voter;
	}
	public void setVoter(String voter) {
		this.voter = voter;
	}
	public BigInteger getWeight() {
		return weight;
	}
	public void setWeight(BigInteger weight) {
		this.weight = weight;
	}
	public BigInteger getRshares() {
		return rshares;
	}
	public void setRshares(BigInteger rshares) {
		this.rshares = rshares;
	}
	public int getPercent() {
		return percent;
	}
	public void setPercent(int percent) {
		this.percent = percent;
	}
	public BigInteger getReputation() {
		return reputation;
	}
	public void setReputation(BigInteger reputation) {
		this.reputation = reputation;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
}
