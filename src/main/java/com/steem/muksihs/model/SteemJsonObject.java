package com.steem.muksihs.model;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;

public class SteemJsonObject {
	private final Map<String, Object> properties;
	public SteemJsonObject() {
		properties=new HashMap<>();
	}
	@JsonAnySetter
	public void setProperty(String key, Object value) {
		properties.put(key, value);
	}

	public Object getProperty(String key) {
		return properties.get(key);
	}

	@JsonAnyGetter
	protected Map<String, Object> getProperties() {
		return properties;
	}
	
	public void clearProperties() {
		properties.clear();
	}
}
