package com.comopt.touchpoint.model;

import java.time.LocalDate;
import java.util.Date;

public class Touchpoint {
	
	private ExtRefId extRefId;
	private Initiator initiator;
	private Initiator aboutWhom;
	private Initiator whReciever;
	
	private String mode;
	private String channelId;
	private String reasonCd;
	private LocalDate statDtTs;
	
	private CommDetails commDetails;

	public ExtRefId getExtRefId() {
		return extRefId;
	}

	public void setExtRefId(ExtRefId extRefId) {
		this.extRefId = extRefId;
	}

	public Initiator getInitiator() {
		return initiator;
	}

	public void setInitiator(Initiator initiator) {
		this.initiator = initiator;
	}

	public Initiator getAboutWhom() {
		return aboutWhom;
	}

	public void setAboutWhom(Initiator aboutWhom) {
		this.aboutWhom = aboutWhom;
	}

	public Initiator getWhReciever() {
		return whReciever;
	}

	public void setWhReciever(Initiator whReciever) {
		this.whReciever = whReciever;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	public String getReasonCd() {
		return reasonCd;
	}

	public void setReasonCd(String reasonCd) {
		this.reasonCd = reasonCd;
	}

	public LocalDate getStatDtTs() {
		return statDtTs;
	}

	public void setStatDtTs(LocalDate statDtTs) {
		this.statDtTs = statDtTs;
	}

	public CommDetails getCommDetails() {
		return commDetails;
	}

	public void setCommDetails(CommDetails commDetails) {
		this.commDetails = commDetails;
	}

	@Override
	public String toString() {
		return "Touchpoint [extRefId=" + extRefId + ", initiator=" + initiator + ", aboutWhom=" + aboutWhom
				+ ", whReciever=" + whReciever + ", mode=" + mode + ", channelId=" + channelId + ", reasonCd="
				+ reasonCd + ", statDtTs=" + statDtTs + ", commDetails=" + commDetails + "]";
	}
	
	

}
