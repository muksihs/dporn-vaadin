package com.steem.muksihs;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JsonRpcResponse<T> {
	@JsonProperty("jsonrpc")
	private String jsonRpc;
	public String getJsonRpc() {
		return jsonRpc;
	}
	public void setJsonRpc(String jsonRpc) {
		this.jsonRpc = jsonRpc;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	private T result;
	public T getResult() {
		return result;
	}
	public void setResult(T result) {
		this.result = result;
	}
	private long id;
}
