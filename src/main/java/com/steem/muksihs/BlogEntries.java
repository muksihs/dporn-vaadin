package com.steem.muksihs;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategy.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.steem.muksihs.BlogEntries.Blog;

@JsonNaming(SnakeCaseStrategy.class)
@JsonInclude(Include.NON_NULL)
public class BlogEntries extends JsonRpcResponse<Blog> {
	public static class Blog {
		private List<BlogEntry> blog;

		public List<BlogEntry> getBlog() {
			return blog;
		}

		public void setBlog(List<BlogEntry> blog) {
			this.blog = blog;
		}
	}
	
}
