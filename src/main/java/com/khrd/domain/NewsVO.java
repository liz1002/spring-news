package com.khrd.domain;

import java.util.Date;

public class NewsVO {
	private int nNo;
	private String nTitle;
	private String nSubtitle;
	private String nPath;
	private String nSource;
	private Date nRegdate;
	private String cName;
	private String gName;
	private String nLink;
	private String dContent;
	
	public NewsVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public NewsVO(int nNo, String nTitle, String nSubtitle, String nPath, String nSource, Date nRegdate, String cName,
			String gName, String nLink, String dContent) {
		super();
		this.nNo = nNo;
		this.nTitle = nTitle;
		this.nSubtitle = nSubtitle;
		this.nPath = nPath;
		this.nSource = nSource;
		this.nRegdate = nRegdate;
		this.cName = cName;
		this.gName = gName;
		this.nLink = nLink;
		this.dContent = dContent;
	}

	public int getnNo() {
		return nNo;
	}

	public void setnNo(int nNo) {
		this.nNo = nNo;
	}

	public String getnTitle() {
		return nTitle;
	}

	public void setnTitle(String nTitle) {
		this.nTitle = nTitle;
	}

	public String getnSubtitle() {
		return nSubtitle;
	}

	public void setnSubtitle(String nSubtitle) {
		this.nSubtitle = nSubtitle;
	}

	public String getnPath() {
		return nPath;
	}

	public void setnPath(String nPath) {
		this.nPath = nPath;
	}

	public String getnSource() {
		return nSource;
	}

	public void setnSource(String nSource) {
		this.nSource = nSource;
	}

	public Date getnRegdate() {
		return nRegdate;
	}

	public void setnRegdate(Date nRegdate) {
		this.nRegdate = nRegdate;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getgName() {
		return gName;
	}

	public void setgName(String gName) {
		this.gName = gName;
	}

	public String getnLink() {
		return nLink;
	}

	public void setnLink(String nLink) {
		this.nLink = nLink;
	}

	public String getdContent() {
		return dContent;
	}

	public void setdContent(String dContent) {
		this.dContent = dContent;
	}

	@Override
	public String toString() {
		return "\n[NewsVO] nNo=" + nNo + ", nTitle=" + nTitle + ", nSubtitle=" + nSubtitle + ", nPath=" + nPath
				+ ", nSource=" + nSource + ", nRegdate=" + nRegdate + ", cName=" + cName + ", gName=" + gName
				+ ", nLink=" + nLink + ", dContent=" + dContent + "\n";
	}	
}
