package com.steem.muksihs;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategy.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;


@JsonNaming(SnakeCaseStrategy.class)
@JsonInclude(Include.NON_NULL)
public class Comment {
	private long id;
	private String author;
	private String permlink;
	private String category;
	private String parentAuthor;
	private String parentPermlink;
	private String title;
	private String body;
	private String jsonMetadata;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone="UTC")
	private Date lastUpdate;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone="UTC")
	private Date created;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone="UTC")
	private Date active;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone="UTC")
	private Date lastPayout;
	private int depth;
	private int children;
	private BigDecimal netRshares;
	private BigDecimal absRshares;
	private BigDecimal voteRshares;
	private BigDecimal childrenAbsRshares;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone="UTC")
	private Date cashoutTime;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone="UTC")
	private Date maxCashoutTime;
	private BigDecimal totalVoteWeight;
	private BigDecimal rewardWeight;
	private SteemCurrency totalPayoutValue;
	private SteemCurrency curatorPayoutValue;
	private BigDecimal authorRewards;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPermlink() {
		return permlink;
	}
	public void setPermlink(String permlink) {
		this.permlink = permlink;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getParentAuthor() {
		return parentAuthor;
	}
	public void setParentAuthor(String parentAuthor) {
		this.parentAuthor = parentAuthor;
	}
	public String getParentPermlink() {
		return parentPermlink;
	}
	public void setParentPermlink(String parentPermlink) {
		this.parentPermlink = parentPermlink;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getJsonMetadata() {
		return jsonMetadata;
	}
	public void setJsonMetadata(String jsonMetadata) {
		this.jsonMetadata = jsonMetadata;
	}
	public Date getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getActive() {
		return active;
	}
	public void setActive(Date active) {
		this.active = active;
	}
	public Date getLastPayout() {
		return lastPayout;
	}
	public void setLastPayout(Date lastPayout) {
		this.lastPayout = lastPayout;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	public int getChildren() {
		return children;
	}
	public void setChildren(int children) {
		this.children = children;
	}
	public BigDecimal getNetRshares() {
		return netRshares;
	}
	public void setNetRshares(BigDecimal netRshares) {
		this.netRshares = netRshares;
	}
	public BigDecimal getAbsRshares() {
		return absRshares;
	}
	public void setAbsRshares(BigDecimal absRshares) {
		this.absRshares = absRshares;
	}
	public BigDecimal getVoteRshares() {
		return voteRshares;
	}
	public void setVoteRshares(BigDecimal voteRshares) {
		this.voteRshares = voteRshares;
	}
	public BigDecimal getChildrenAbsRshares() {
		return childrenAbsRshares;
	}
	public void setChildrenAbsRshares(BigDecimal childrenAbsRshares) {
		this.childrenAbsRshares = childrenAbsRshares;
	}
	public Date getCashoutTime() {
		return cashoutTime;
	}
	public void setCashoutTime(Date cashoutTime) {
		this.cashoutTime = cashoutTime;
	}
	public Date getMaxCashoutTime() {
		return maxCashoutTime;
	}
	public void setMaxCashoutTime(Date maxCashoutTime) {
		this.maxCashoutTime = maxCashoutTime;
	}
	public BigDecimal getTotalVoteWeight() {
		return totalVoteWeight;
	}
	public void setTotalVoteWeight(BigDecimal totalVoteWeight) {
		this.totalVoteWeight = totalVoteWeight;
	}
	public BigDecimal getRewardWeight() {
		return rewardWeight;
	}
	public void setRewardWeight(BigDecimal rewardWeight) {
		this.rewardWeight = rewardWeight;
	}
	public SteemCurrency getTotalPayoutValue() {
		return totalPayoutValue;
	}
	public void setTotalPayoutValue(SteemCurrency totalPayoutValue) {
		this.totalPayoutValue = totalPayoutValue;
	}
	public SteemCurrency getCuratorPayoutValue() {
		return curatorPayoutValue;
	}
	public void setCuratorPayoutValue(SteemCurrency curatorPayoutValue) {
		this.curatorPayoutValue = curatorPayoutValue;
	}
	public BigDecimal getAuthorRewards() {
		return authorRewards;
	}
	public void setAuthorRewards(BigDecimal authorRewards) {
		this.authorRewards = authorRewards;
	}
	public String getRootAuthor() {
		return rootAuthor;
	}
	public void setRootAuthor(String rootAuthor) {
		this.rootAuthor = rootAuthor;
	}
	public String getRootPermlink() {
		return rootPermlink;
	}
	public void setRootPermlink(String rootPermlink) {
		this.rootPermlink = rootPermlink;
	}
	public boolean isAllowReplies() {
		return allowReplies;
	}
	public void setAllowReplies(boolean allowReplies) {
		this.allowReplies = allowReplies;
	}
	public boolean isAllowVotes() {
		return allowVotes;
	}
	public void setAllowVotes(boolean allowVotes) {
		this.allowVotes = allowVotes;
	}
	public boolean isAllowCurationRewards() {
		return allowCurationRewards;
	}
	public void setAllowCurationRewards(boolean allowCurationRewards) {
		this.allowCurationRewards = allowCurationRewards;
	}
	public List<Beneficiary> getBeneficiaries() {
		return beneficiaries;
	}
	public void setBeneficiaries(List<Beneficiary> beneficiaries) {
		this.beneficiaries = beneficiaries;
	}
	public String getBlog() {
		return blog;
	}
	public void setBlog(String blog) {
		this.blog = blog;
	}
	public Date getReblogOn() {
		return reblogOn;
	}
	public void setReblogOn(Date reblogOn) {
		this.reblogOn = reblogOn;
	}
	public long getEntryId() {
		return entryId;
	}
	public void setEntryId(long entryId) {
		this.entryId = entryId;
	}
	private String rootAuthor;
	private String rootPermlink;
	private boolean allowReplies;
	private boolean allowVotes;
	private boolean allowCurationRewards;
	private List<Beneficiary> beneficiaries;
	private String blog;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone="UTC")
	private Date reblogOn;
	private long entryId;
}
