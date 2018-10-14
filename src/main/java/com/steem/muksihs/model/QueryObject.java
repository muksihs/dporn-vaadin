package com.steem.muksihs.model;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategy.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(SnakeCaseStrategy.class)
@JsonInclude(Include.NON_NULL)
public class QueryObject {
	private final Map<String, Object> query = new HashMap<String, Object>();

	@JsonAnySetter
	public void setProperty(String key, Object value) {
		query.put(key, value);
	}

	public Object getProperty(String key) {
		return query.get(key);
	}

	@JsonAnyGetter
	protected Map<String, Object> getMap() {
		return query;
	}

	public void clear() {
		query.clear();
	}
}
