package com.comopt.touchpoint.model;

import java.util.List;

public class CommDetails {
	private String typeCd;
	private List<Address> address;
	public String getTypeCd() {
		return typeCd;
	}
	public void setTypeCd(String typeCd) {
		this.typeCd = typeCd;
	}
	public List<Address> getAddress() {
		return address;
	}
	public void setAddress(List<Address> address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "CommDetails [typeCd=" + typeCd + ", address=" + address + "]";
	}
	

}
