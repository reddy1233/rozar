package com.comopt.touchpoint.model;

import java.io.Serializable;
import java.util.List;

public class CommDetails implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4943943776562426822L;
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
