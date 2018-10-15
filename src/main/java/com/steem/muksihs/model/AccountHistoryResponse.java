package com.steem.muksihs.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategy.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.steem.muksihs.rest.JsonRpcResponse;

@JsonNaming(SnakeCaseStrategy.class)
@JsonInclude(Include.NON_NULL)
//public class BlogEntriesResponse extends JsonRpcResponse<BlogEntries> {
public class AccountHistoryResponse extends JsonRpcResponse<AccountHistoryEntries> {
	
}
