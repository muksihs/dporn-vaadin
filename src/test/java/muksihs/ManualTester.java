package muksihs;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.steem.muksihs.BlogEntries;
import com.steem.muksihs.BlogEntry;
import com.steem.muksihs.Comment;
import com.steem.muksihs.SteemJsonRpc;
import com.steem.muksihs.SteemObjectMapper;
import com.steem.muksihs.model.BlogEntryQuery;

public class ManualTester {
	public static void main(String[] args) throws JsonProcessingException, IOException {
		SteemJsonRpc rpc = new SteemJsonRpc();
		BlogEntryQuery param=new BlogEntryQuery();
		param.setLimit(2);
		param.setAccount("leatherdog-games");
		System.out.println(SteemObjectMapper.instance().writeValueAsString(param));
		BlogEntries entries = rpc.getBlog(param);
		System.out.println(SteemObjectMapper.instance().writeValueAsString(entries));
		System.out.println("Entries: "+entries.getResult().getBlog().size());
		for (BlogEntry entry: entries.getResult().getBlog()) {
			Comment comment = entry.getComment();
			System.out.println(comment.getId());
			System.out.println(comment.getTitle());
			System.out.println(comment.getPermlink());
		}
	}
}
