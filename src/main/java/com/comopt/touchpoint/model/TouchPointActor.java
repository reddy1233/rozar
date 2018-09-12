package com.comopt.touchpoint.model;

import java.io.Serializable;
import java.util.List;

public class TouchPointActor implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2715028304215729777L;
	private String appId;
	private String transId;
	private String etlBusinessRecordId;
	private String sourceCd;
	private long tenantId;
	
	private List<Touchpoint> touchpoint;

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getTransId() {
		return transId;
	}

	public void setTransId(String transId) {
		this.transId = transId;
	}

	public String getEtlBusinessRecordId() {
		return etlBusinessRecordId;
	}

	public void setEtlBusinessRecordId(String etlBusinessRecordId) {
		this.etlBusinessRecordId = etlBusinessRecordId;
	}

	public String getSourceCd() {
		return sourceCd;
	}

	public void setSourceCd(String sourceCd) {
		this.sourceCd = sourceCd;
	}

	public long getTenantId() {
		return tenantId;
	}

	public void setTenantId(long tenantId) {
		this.tenantId = tenantId;
	}

	public List<Touchpoint> getTouchpoint() {
		return touchpoint;
	}

	public void setTouchpoint(List<Touchpoint> touchpoint) {
		this.touchpoint = touchpoint;
	}

	@Override
	public String toString() {
		return "TouchPointActor [appId=" + appId + ", transId=" + transId + ", etlBusinessRecordId="
				+ etlBusinessRecordId + ", sourceCd=" + sourceCd + ", tenantId=" + tenantId + ", touchpoint="
				+ touchpoint + "]";
	}
	
}
