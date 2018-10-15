package com.steem.muksihs.model;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategy.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(SnakeCaseStrategy.class)
@JsonInclude(Include.NON_NULL)
public class Transaction extends SteemJsonObject {
	
	private String trxId;
	private BigInteger block;
	private int trxInBlock;
	private int opInTrx;
	private int virtualOp;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone="UTC")
	private Date timestamp;
	private List<Object> op;
	
	@Override
	public Map<String, Object> getProperties() {
		return super.getProperties();
	};
}
