package com.comopt.touchpoint.model;

public class ExtRefId {
	
	private String id;
	private String sourceCd;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSourceCd() {
		return sourceCd;
	}
	public void setSourceCd(String sourceCd) {
		this.sourceCd = sourceCd;
	}
	@Override
	public String toString() {
		return "ExtRefId [id=" + id + ", sourceCd=" + sourceCd + "]";
	}
	

}
