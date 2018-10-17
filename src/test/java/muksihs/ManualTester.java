package muksihs;

import java.io.IOException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;

import org.apache.commons.lang3.time.DateUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.steem.muksihs.model.Comment;
import com.steem.muksihs.model.DiscussionsByAuthorBeforeDate;
import com.steem.muksihs.model.DiscussionsResponse;
import com.steem.muksihs.rest.SteemJsonRpc;

import eu.bittrade.libs.steemj.SteemJ;
import eu.bittrade.libs.steemj.apis.follow.model.BlogEntry;
import eu.bittrade.libs.steemj.base.models.AccountName;
import eu.bittrade.libs.steemj.base.models.AppliedOperation;
import eu.bittrade.libs.steemj.base.models.operations.CommentOperation;
import eu.bittrade.libs.steemj.base.models.operations.virtual.CommentBenefactorRewardOperation;
import eu.bittrade.libs.steemj.exceptions.SteemCommunicationException;
import eu.bittrade.libs.steemj.exceptions.SteemResponseException;

public class ManualTester {
	public static void main(String[] args)
			throws JsonProcessingException, IOException, SteemCommunicationException, SteemResponseException {

		AccountName accountName = new AccountName("dporn");
		// blogEntryWalk(accountName);
		accountHistoryWalk(accountName);

//		 SteemJsonRpc rpc = new SteemJsonRpc();

//		 discussions1(rpc);

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

	private static void blogEntryWalk(AccountName accountName)
			throws SteemCommunicationException, SteemResponseException {
		SteemJ steemJ = new SteemJ();
		int entryId = -1;
		int count = 1;
		int total = 1;
		do {
			List<BlogEntry> entries = steemJ.getBlogEntries(accountName, entryId, (short) 10);
			total += (entries.size() - 1);
			count = entries.size();
			System.out.println("-");
			for (BlogEntry entry : entries) {
				System.out.print(entry.getEntryId());
				System.out.print(") " + entry.getAuthor().getName());
				System.out.println(": " + entry.getPermlink().getLink());
				entryId = entryId > 0 ? Math.min(entryId, entry.getEntryId()) : entry.getEntryId();
			}
		} while (count > 1);
		System.out.println("- TOTAL: " + total);
	}

	private static void accountHistoryWalk(AccountName accountName)
			throws SteemCommunicationException, SteemResponseException {
		Set<String> already = new HashSet<>();//used to hide earlier versions of edited posts
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setTimeZone(TimeZone.getTimeZone("EST5EDT"));
		SteemJ steemJ = new SteemJ();
		int prevEntryId = -1;
		int count = 1;
		int total = 1;
		int limit = 100;
		do {
			limit = prevEntryId > 0 ? Math.min(limit, prevEntryId - 1) : limit;
			Map<Integer, AppliedOperation> entries = steemJ.getAccountHistory(accountName, prevEntryId, (short) limit);
			total += (entries.size() - 1);
			count = entries.size();
			List<Integer> sorted = new ArrayList<>(entries.keySet());
			Collections.sort(sorted);
			Collections.reverse(sorted);
			for (Integer entryId : sorted) {
				AppliedOperation entry = entries.get(entryId);
				prevEntryId = prevEntryId > 0 ? Math.min(prevEntryId, entryId) : entryId;
				
				if (entry.getOp() instanceof CommentBenefactorRewardOperation) {
					CommentBenefactorRewardOperation cbro = (CommentBenefactorRewardOperation) entry.getOp();
					System.out.println("CBRO: https://busy.org/@"+cbro.getAuthor().getName()+"/"+cbro.getPermlink().getLink());
					continue;
				}
				
				if (!(entry.getOp() instanceof CommentOperation)) {
					continue;
				}
				CommentOperation commentOperation = (CommentOperation) entry.getOp();
				if (commentOperation.getTitle().trim().isEmpty()) {
					continue;
				}
				String link = commentOperation.getPermlink().getLink();
				if (already.contains(link)) {
					continue;
				}
				already.add(link);
				Date when = entry.getTimestamp().getDateTimeAsDate();
				System.out.println(sdf.format(when) + " " + entryId + ": " + commentOperation.getTitle() + " "
						+ link);
			}
		} while (count > 1);
		System.out.println("- TOTAL: " + total);
	}

	// @JsonFormat(shape = JsonFormat.Shape.STRING, pattern =
	// "yyyy-MM-dd'T'HH:mm:ss", timezone="UTC")
	private static void discussions1(SteemJsonRpc rpc) throws JsonProcessingException, IOException {
		int total = 0;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		sdf.setTimeZone(TimeZone.getTimeZone("EST5EDT"));
		DiscussionsByAuthorBeforeDate dparam = new DiscussionsByAuthorBeforeDate();
		dparam.setAuthor("muksihs");
		dparam.setBeforeDate(new Date());
		dparam.setLimit(100);
		dparam.setStartPermlink("");
		// System.out.println(SteemObjectMapper.instance().writeValueAsString(dparam));
		DiscussionsResponse discussions = rpc.getDiscussionsByAuthorBeforeDate(dparam);
		System.out.println("=== " + (total += discussions.getResult().getDiscussions().size()));
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
			System.out.println("=== " + (total += (discussions.getResult().getDiscussions().size() - 1)));
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
			System.out.println("[2] " + next.getTitle());
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
