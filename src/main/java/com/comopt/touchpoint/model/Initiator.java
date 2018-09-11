package com.comopt.touchpoint.model;

public class Initiator {
	
	private String id;
	private String category;
	private String constinuencyCd;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getConstinuencyCd() {
		return constinuencyCd;
	}
	public void setConstinuencyCd(String constinuencyCd) {
		this.constinuencyCd = constinuencyCd;
	}
	@Override
	public String toString() {
		return "Initiator [id=" + id + ", category=" + category + ", constinuencyCd=" + constinuencyCd + "]";
	}

	
	

}
