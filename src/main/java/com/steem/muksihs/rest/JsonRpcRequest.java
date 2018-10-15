package com.steem.muksihs.rest;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategy.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.steem.muksihs.model.QueryObject;

@JsonNaming(SnakeCaseStrategy.class)
@JsonInclude(Include.NON_NULL)
public class JsonRpcRequest<T extends QueryObject> {

	private static long _counter = System.currentTimeMillis();
	private static synchronized long nextCounter() {
		_counter = (++_counter) > System.currentTimeMillis() ? _counter : System.currentTimeMillis();
		return _counter;
	}

	private final long id;

	private String jsonrpc = "2.0";
	private String method;

	private T params;

	public JsonRpcRequest() {
		id = nextCounter();
	}

	public JsonRpcRequest(String method, T params) {
		this();
		this.method = method;
		this.params = params;
	}

	public long getId() {
		return id;
	}

	public String getMethod() {
		return method;
	}

	public T getParams() {
		return params;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public void setParams(T params) {
		this.params = params;
	}

	public String getJsonrpc() {
		return jsonrpc;
	}
}
