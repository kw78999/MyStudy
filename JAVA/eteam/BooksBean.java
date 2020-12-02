package eteam;

import java.util.Vector;
//빈즈네이밍 : 테이블명+Bean
//빈즈 : 레코드(한줄) 단위를 데이터 덩어리
public class BooksBean {

	private static final int Idx = 0;
	private int BID;
	public int getBID() {
		return BID;
	}
	private String ISBN;
	private String TITLE;
	private String AUTHOR;
	private String PUBLISHER;
	private String LOCATION;
	private String BOOKSTATE;
	private String BCOPY;
	private String BDATE;
	private String BCOUNT;
	private String BCOUNTP;
	
	                 //getXxx
	public int getIdx() {
		return Idx;
	}                 
	                   //setXxx(타입 컬럼명)
	public void setBID(int BID) {
		this.BID = BID;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String ISBN) {
		this.ISBN = ISBN;
	}
	public String getAUTHOR() {
		return AUTHOR;
	}
	public void setAUTHOR(String AUTHOR) {
		this.AUTHOR = AUTHOR;
	}
	public String getTITLE() {
		return TITLE;
	}
	public void setTITLE(String TITLE) {
		this.TITLE = TITLE;
	}
	public String getPUBLISHER() {
		return PUBLISHER;
	}
	public void setPUBLISHER(String PUBLISHER) {
		this.PUBLISHER = PUBLISHER;
	}
	public String getLOCATION() {
		return LOCATION;
	}
	public void setLOCATION(String LOCATION) {
		this.LOCATION = LOCATION;
		}
	public String getBOOKSTATE() {
		return BOOKSTATE;
	}
	public void setBOOKSTATE(String BOOKSTATE) {
		this.BOOKSTATE = BOOKSTATE;
	}
	public String getBCOPY() {
			return BCOPY;
		}
	public void setBCOPY(String BCOPY) {
			this.BCOPY = BCOPY;
		}
	public String getBDATE() {
		return BDATE;
	}
    public void setBDATE(String BDATE) {
		this.BDATE = BDATE;
	}
	public String getBCOUNT() {
		return BCOUNT;
	}
    public void setBCOUNT(String BCOUNT) {
		this.BCOUNT = BCOUNT;		
	}
	public String getBCOUNTP() {
		return BCOUNTP;
	}
    public void setBCOUNTP(String BCOUNTP) {
		this.BCOUNTP = BCOUNTP;		
	}
	public int size() {
		return 0;
	}
	public BooksBean elementAt(int j) {
		return null;
	}
}

