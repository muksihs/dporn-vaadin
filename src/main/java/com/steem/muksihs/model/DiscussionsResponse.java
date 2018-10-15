package com.steem.muksihs.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategy.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.steem.muksihs.model.DiscussionsResponse.DiscussionEntries;
import com.steem.muksihs.rest.JsonRpcResponse;

@JsonNaming(SnakeCaseStrategy.class)
@JsonInclude(Include.NON_NULL)
public class DiscussionsResponse extends JsonRpcResponse<DiscussionEntries> {
	public static class DiscussionEntries {
		private List<Discussion> discussions;

		public List<Discussion> getDiscussions() {
			return discussions;
		}

		public void setDiscussions(List<Discussion> discussions) {
			this.discussions = discussions;
		}
	}
}
