package guestbook;

public class CommentBean {
	private int cnum;
	private int num;
	private String cid;
	private String comment;
	private String cip;
	private String cregdate;
	
	public int getCnum() {
		return cnum;
	}
	public void setCnum(int cnum) {
		this.cnum = cnum;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getCip() {
		return cip;
	}
	public void setCip(String cip) {
		this.cip = cip;
	}
	public String getCregdate() {
		return cregdate;
	}
	public void setCregdate(String cregdate) {
		this.cregdate = cregdate;
	}
}
