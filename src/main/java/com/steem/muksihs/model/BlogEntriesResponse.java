package com.steem.muksihs.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategy.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.steem.muksihs.model.BlogEntriesResponse.BlogEntries;
import com.steem.muksihs.rest.JsonRpcResponse;

@JsonNaming(SnakeCaseStrategy.class)
@JsonInclude(Include.NON_NULL)
public class BlogEntriesResponse extends JsonRpcResponse<BlogEntries> {
	public static class BlogEntries {
		private List<BlogEntry> blog;

		public List<BlogEntry> getBlog() {
			return blog;
		}

		public void setBlog(List<BlogEntry> blog) {
			this.blog = blog;
		}
	}
	
}
