package eteam;

//������̹� : ���̺��+Bean
//���� : ���ڵ�(����) ������ ������ ���
public class BMEMBERSBean {

	private static final int Idx = 0;
	private int MID;
	public int getMID() {
		return MID;
	}
	private String MNAME;
	private String MGRADE;
	private String MPHONE;
	private String MAXRENTAL;
	private String ECOUNT;
	private String ECOUNTP;
	private String ELIMIT;
	
	                 //getXxx
	public int getIdx() {
		return Idx;
	}                 
	                   //setXxx(Ÿ�� �÷���)
	public void setMID(int MID) {
		this.MID = MID;
	}
	public String getMNAME() {
		return MNAME;
	}
	public void setMNAME(String MNAME) {
		this.MNAME = MNAME;
	}
	public String getMPHONE() {
		return MPHONE;
	}
	public void setMPHONE(String MPHONE) {
		this.MPHONE = MPHONE;
	}
	public String getMGRADE() {
		return MGRADE;
	}
	public void setMGRADE(String MGRADE) {
		this.MGRADE = MGRADE;
	}
	public String getMAXRENTAL() {
		return MAXRENTAL;
	}
	public void setMAXRENTAL(String MAXRENTAL) {
		this.MAXRENTAL = MAXRENTAL;
	}
	public String getECOUNT() {
		return ECOUNT;
	}
	public void setECOUNT(String ECOUNT) {
		this.ECOUNT = ECOUNT;
		}
	public String getECOUNTP() {
		return ECOUNTP;
	}
	public void setECOUNTP(String ECOUNTP) {
		this.ECOUNTP = ECOUNTP;
	}
	public String getELIMIT() {
			return ELIMIT;
		}
	public void setELIMIT(String ELIMIT) {
			this.ELIMIT = ELIMIT;
		}
	}
