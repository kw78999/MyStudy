package JAVAP;

import java.util.Vector;
//������̹� : ���̺��+Bean
//���� : ���ڵ�(����) ������ ������ ���
public class BrentalBean {

	private static final int Idx = 0;
	private int RID;
	public int getRID() {
		return RID;
	}
	private String RMID;
	private String BMID;
	private String RENTAL;
	private String ENDRENTAL;

	
	                 //getXxx
	public int getIdx() {
		return Idx;
	}                 
	                   //setXxx(Ÿ�� �÷���)
	public void setRID(int RID) {
		this.RID = RID;
	}
	public String getRMID() {
		return RMID;
	}
	public void setRMID(String RMID) {
		this.RMID = RMID;
	}
	public String getBMID() {
		return BMID;
	}
	public void setBMID(String BMID) {
		this.BMID = BMID;
	}
	public String RENTAL() {
		return RENTAL;
	}
	public void setRENTAL(String RENTAL) {
		this.RENTAL = RENTAL;
	}
	public String getENDRENTAL() {
		return ENDRENTAL;
	}
	public void setENDRENTAL(String ENDRENTAL) {
		this.ENDRENTAL = ENDRENTAL;
	}
	
	public int size() {
		return 0;
	}
	public BrentalBean elementAt(int j) {
		return null;
	}
	public String getRENTAL() {
		return null;
	}
}

