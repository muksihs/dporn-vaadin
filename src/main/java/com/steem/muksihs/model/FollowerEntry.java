package com.steem.muksihs.model;

import java.util.List;

public class FollowerEntry {
	private String follower;
	private String following;
	private List<String> what;
	public String getFollower() {
		return follower;
	}
	public void setFollower(String follower) {
		this.follower = follower;
	}
	public String getFollowing() {
		return following;
	}
	public void setFollowing(String following) {
		this.following = following;
	}
	public List<String> getWhat() {
		return what;
	}
	public void setWhat(List<String> what) {
		this.what = what;
	}
}
