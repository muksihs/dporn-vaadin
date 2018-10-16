package muksihs;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;

import org.apache.commons.lang3.time.DateUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.steem.muksihs.model.Comment;
import com.steem.muksihs.model.DiscussionsByAuthorBeforeDate;
import com.steem.muksihs.model.DiscussionsResponse;
import com.steem.muksihs.rest.SteemJsonRpc;

public class ManualTester {
	public static void main(String[] args) throws JsonProcessingException, IOException {
		SteemJsonRpc rpc = new SteemJsonRpc();

		discussions1(rpc);

		// BlogEntryQuery param=new BlogEntryQuery();
		// param.setLimit(2);
		// param.setAccount("leatherdog-games");
		// System.out.println(SteemObjectMapper.instance().writeValueAsString(param));
		// BlogEntriesResponse entries = rpc.getBlog(param);
		// System.out.println(SteemObjectMapper.instance().writeValueAsString(entries));
		// System.out.println("Entries: "+entries.getResult().getBlog().size());
		// for (BlogEntry entry: entries.getResult().getBlog()) {
		// Comment comment = entry.getComment();
		// System.out.println(comment.getId());
		// System.out.println(comment.getTitle());
		// System.out.println(comment.getPermlink());
		// }
		//
		// FollowingQuery fparam=new FollowingQuery();
		// fparam.setAccount("muksihs");
		// fparam.setType("blog");
		// fparam.setLimit(5);
		// FollowingResponse following = rpc.getFollowing(fparam);
		// for (FollowerEntry entry: following.getResult().getFollowing()) {
		// System.out.println(entry.getFollower()+" follows "+entry.getFollowing());
		// }
		// fparam.setStart(following.getResult().getFollowing().get(following.getResult().getFollowing().size()-1).getFollowing());
		// following = rpc.getFollowing(fparam);
		// for (FollowerEntry entry: following.getResult().getFollowing()) {
		// System.out.println(entry.getFollower()+" follows "+entry.getFollowing());
		// }
	}

	// @JsonFormat(shape = JsonFormat.Shape.STRING, pattern =
	// "yyyy-MM-dd'T'HH:mm:ss", timezone="UTC")
	private static void discussions1(SteemJsonRpc rpc) throws JsonProcessingException, IOException {
		int total=0;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
		DiscussionsByAuthorBeforeDate dparam = new DiscussionsByAuthorBeforeDate();
		dparam.setAuthor("leatherdog-games");
		dparam.setBeforeDate(new Date());
		dparam.setLimit(10);
		dparam.setStartPermlink("");
		// System.out.println(SteemObjectMapper.instance().writeValueAsString(dparam));
		DiscussionsResponse discussions = rpc.getDiscussionsByAuthorBeforeDate(dparam);
		System.out.println("=== " + (total+=discussions.getResult().getDiscussions().size()));
		printFirstAndLastComments(discussions.getResult().getDiscussions());
		Comment oldest = getOldest(discussions.getResult().getDiscussions());
		Date oldestDate = oldest.getActive();
		oldestDate = DateUtils.addDays(oldestDate, 1);
		while (discussions.getResult().getDiscussions().size() > 1) {
			dparam.setBeforeDate(oldestDate);
			dparam.setStartPermlink(oldest.getPermlink());
			dparam.setLimit(11);
			// System.out.println(SteemObjectMapper.instance().writeValueAsString(dparam));
			discussions = rpc.getDiscussionsByAuthorBeforeDate(dparam);
			System.out.println("=== " + (total+=(discussions.getResult().getDiscussions().size()-1)));
			printFirstAndLastComments(discussions.getResult().getDiscussions());
			oldest = getOldest(discussions.getResult().getDiscussions());
			oldestDate = oldest.getActive();
			oldestDate = DateUtils.addDays(oldestDate, 1);
		}
	}

	static void printComments(List<? extends Comment> list) {
		if (list == null || list.isEmpty()) {
			return;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
		Iterator<? extends Comment> iList = list.iterator();
		while (iList.hasNext()) {
			Comment next = iList.next();
			System.out.println(next.getTitle());
			System.out.println("\t" + next.getPermlink());
			// sdf.format(next.getCreated())
			System.out.println("\t" + sdf.format(next.getCreated()));
			System.out.println("\t" + sdf.format(next.getLastUpdate()));
			System.out.println("\t" + sdf.format(next.getActive()));
		}
	}

	static void printFirstAndLastComments(List<? extends Comment> list) {
		if (list == null || list.isEmpty()) {
			return;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
		Iterator<? extends Comment> iList = list.iterator();
		Comment next = iList.next();
		System.out.println("[1] " + next.getTitle());
		System.out.println("\t" + next.getPermlink());
		// sdf.format(next.getCreated())
		System.out.println("\t" + sdf.format(next.getCreated()));
		System.out.println("\t" + sdf.format(next.getLastUpdate()));
		System.out.println("\t" + sdf.format(next.getActive()));
		while (iList.hasNext()) {
			next = iList.next();
			if (iList.hasNext()) {
				continue;
			}
			System.out.println("[2] "+next.getTitle());
			System.out.println("\t" + next.getPermlink());
			// sdf.format(next.getCreated())
			System.out.println("\t" + sdf.format(next.getCreated()));
			System.out.println("\t" + sdf.format(next.getLastUpdate()));
			System.out.println("\t" + sdf.format(next.getActive()));
		}
	}

	static Comment getOldest(List<? extends Comment> list) {
		if (list == null || list.isEmpty()) {
			return null;
		}
		return list.get(list.size() - 1);
		// Iterator<? extends Comment> iList = list.iterator();
		// Comment oldest = iList.next();
		// Date oldestDate = oldest.getActive();
		// while (iList.hasNext()) {
		// Comment next = iList.next();
		// Date modified = next.getActive();
		// if (modified.before(oldestDate)) {
		// oldest = next;
		// oldestDate = modified;
		// }
		// }
		// return oldest;
	}
}
