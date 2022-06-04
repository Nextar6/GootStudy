package edu.java.jdbc08;

import java.util.Date;

public class ProductVO {
	private int pno;
	private String pname;
	private int pprice;
	private int ppcount;
	private String pseller;
	private Date pdate;
	
	ProductVO(){}
	public ProductVO(int pno, String pname, int pprice, int ppcount, String pseller, Date pdate) {
		super();
		this.pno = pno;
		this.pname = pname;
		this.pprice = pprice;
		this.ppcount = ppcount;
		this.pseller = pseller;
		this.pdate = pdate;
	}
	public int getPno() {
		return pno;
	}
	public void setPno(int pno) {
		this.pno = pno;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getPprice() {
		return pprice;
	}
	public void setPprice(int pprice) {
		this.pprice = pprice;
	}
	public int getPpcount() {
		return ppcount;
	}
	public void setPpcount(int ppcount) {
		this.ppcount = ppcount;
	}
	public String getPseller() {
		return pseller;
	}
	public void setPseller(String pseller) {
		this.pseller = pseller;
	}
	public Date getPdate() {
		return pdate;
	}
	public void setPdate(Date pdate) {
		this.pdate = pdate;
	}
	@Override
	public String toString() {
		return "ProductVO [pno=" + pno + ", pname=" + pname + ", pprice=" + pprice + ", ppcount=" + ppcount
				+ ", pseller=" + pseller + ", pdate=" + pdate + "]";
	}
	
	
	

}
