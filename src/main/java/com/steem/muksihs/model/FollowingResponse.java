package com.steem.muksihs.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategy.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.steem.muksihs.model.FollowingResponse.FollowerEntries;
import com.steem.muksihs.rest.JsonRpcResponse;

@JsonNaming(SnakeCaseStrategy.class)
@JsonInclude(Include.NON_NULL)
public class FollowingResponse extends JsonRpcResponse<FollowerEntries> {
	public static class FollowerEntries {
		private List<FollowerEntry> following;

		public List<FollowerEntry> getFollowing() {
			return following;
		}

		public void setFollowing(List<FollowerEntry> following) {
			this.following = following;
		}
	}
}
