package com.steem.muksihs;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.steem.muksihs.model.BlogEntryQuery;
import com.steem.muksihs.model.JsonRpcRequest;
import com.steem.muksihs.rest.RestClient;

/**
 * See <a href='https://developers.steem.io/apidefinitions/'>Steem Api</a>
 * @author muksihs
 *
 */
public class SteemJsonRpc {
	
	private final ObjectMapper mapper;
	
	public SteemJsonRpc() {
		mapper = SteemObjectMapper.instance();
	}
	
	private String endpoint = "https://api.steemit.com";

	public String getEndpoint() {
		return endpoint;
	}

	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}
	
	public BlogEntries getBlog(BlogEntryQuery param) throws JsonProcessingException, IOException {
		JsonRpcRequest<BlogEntryQuery> postData = new JsonRpcRequest<BlogEntryQuery>();
		postData.setParams(param);
		postData.setMethod("follow_api.get_blog");
		String jsonString = RestClient.post(endpoint, postData);
		System.out.println(jsonString);
		return mapper.readValue(jsonString, BlogEntries.class);
	}
}
