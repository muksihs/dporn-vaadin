package com.steem.muksihs.rest;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.steem.muksihs.model.BlogEntriesResponse;
import com.steem.muksihs.model.BlogEntryQuery;
import com.steem.muksihs.model.DiscussionsByAuthorBeforeDate;
import com.steem.muksihs.model.DiscussionsResponse;
import com.steem.muksihs.model.FollowingQuery;
import com.steem.muksihs.model.FollowingResponse;
import com.steem.muksihs.util.SteemObjectMapper;

/**
 * See <a href='https://developers.steem.io/apidefinitions/'>Steem Api</a>
 * 
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

	public BlogEntriesResponse getBlog(BlogEntryQuery param) throws JsonProcessingException, IOException {
		JsonRpcRequest<BlogEntryQuery> postData = new JsonRpcRequest<BlogEntryQuery>("follow_api.get_blog", param);
		String jsonString = RestClient.post(endpoint, postData);
		return mapper.readValue(jsonString, BlogEntriesResponse.class);
	}

	public FollowingResponse getFollowing(FollowingQuery param) throws JsonProcessingException, IOException {
		JsonRpcRequest<FollowingQuery> postData = new JsonRpcRequest<FollowingQuery>("follow_api.get_following", param);
		String jsonString = RestClient.post(endpoint, postData);
		return mapper.readValue(jsonString, FollowingResponse.class);
	}
	
	public DiscussionsResponse getDiscussionsByAuthorBeforeDate(DiscussionsByAuthorBeforeDate param) throws JsonProcessingException, IOException {
		JsonRpcRequest<DiscussionsByAuthorBeforeDate> postData = new JsonRpcRequest<DiscussionsByAuthorBeforeDate>("tags_api.get_discussions_by_author_before_date", param);
		String jsonString = RestClient.post(endpoint, postData);
		return mapper.readValue(jsonString, DiscussionsResponse.class);
	}
	
}
