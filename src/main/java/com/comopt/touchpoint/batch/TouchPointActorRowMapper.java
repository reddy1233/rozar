package com.comopt.touchpoint.batch;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.comopt.touchpoint.AppConstant;
import com.comopt.touchpoint.model.Address;
import com.comopt.touchpoint.model.CommDetails;
import com.comopt.touchpoint.model.Initiator;
import com.comopt.touchpoint.model.TouchPointActor;
import com.comopt.touchpoint.model.Touchpoint;

public class TouchPointActorRowMapper implements RowMapper<TouchPointActor>{
	
	int count = 0;

 @Override
 public TouchPointActor mapRow(ResultSet rs, int rowNum) throws SQLException {
	 
	 count=count+1;
	 System.out.println("coiunt >>."+count);
	 
	 List<Touchpoint> tpList = new ArrayList<>();
	 TouchPointActor tpa = new TouchPointActor();
	 
	 tpa.setAppId(AppConstant.APP_ID);
	 tpa.setTransId(rs.getString("trans_id"));
	// tpa.setSourceCd(rs.getString("source_system_cd"));// rs.getInt("source_system_cd")
	 tpa.setEtlBusinessRecordId(rs.getString("comm_pfm_trns_id"));	 
	 tpa.setTenantId(1);
	 Touchpoint tp = new Touchpoint();
	 
	 tp.setStatDtTs(LocalDate.now()); // current time should populate here
	 tp.setMode("OutBound"); // default mode
	 tp.setChannelId(rs.getString("del_chnl"));

	 Initiator initiator=new Initiator();
	 initiator.setId(rs.getString("comm_pfm_status_cd"));
	 initiator.setCategory("SYSTEM"); // default to system for now 
	 initiator.setConstinuencyCd("System"); // default to system for now 
	 
	 tp.setInitiator(initiator);
	 
	 // aboutWhom
	 /*if doc_type=grp and set group id else if doc_type=mbr and set member id */
	 Initiator aboutWhom = new Initiator();
	 aboutWhom.setCategory(rs.getString("doc_type"));
	 String docType = rs.getString("doc_type");
	 if(docType!=null && !docType.equalsIgnoreCase("") ) {
		 
		 if(docType.equalsIgnoreCase("grp")) {
			 aboutWhom.setId(rs.getString("grp_id"));
			 
		 }
		 if(docType.equalsIgnoreCase("mbr")) {
			 aboutWhom.setId(rs.getString("mbr_id"));
		 }
	 }

	 aboutWhom.setConstinuencyCd("ENRL");
	 tp.setAboutWhom(aboutWhom);
	 
	 // Receiver
	 Initiator receiver = new Initiator(); 
	 receiver.setId("whid"); // TBD 
	 receiver.setCategory("MBR"); // TBD
	 receiver.setConstinuencyCd("ENRL"); // default to ENRL for now 
	 tp.setWhReciever(receiver);
	 
	 tpList.add(tp); 
	 
	 // commDetails 
	 CommDetails cmd = new CommDetails();
	 
	 cmd.setTypeCd("Home");
	 
	 // list of address 
	 List<Address> adList = new ArrayList<>();
	 Address ad = new Address();
	 ad.setLine1("line 1");
	 ad.setLine2("line2");
	 ad.setCityName("Jacksonville");
	 ad.setStateName("Florida");
	 ad.setPostalCd("123456");
	  
	 adList.add(ad);
	 cmd.setAddress(adList);
	 
	 tp.setCommDetails(cmd);
	 
	 tpa.setTouchpoint(tpList);
  
	 return tpa;
 }
 
}