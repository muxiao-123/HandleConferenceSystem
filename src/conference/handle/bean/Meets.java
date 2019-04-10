package conference.handle.bean;

import java.sql.Timestamp;
import java.util.Date;

public class Meets {
	
   private int meet_id;
   private String meet_title;
   private String meet_points;//会议概况 
   private int number;//参会人数
   private Timestamp startDate;
   private Timestamp endDate;
   private String toastMaster;//主持人
   private String address;
   private String  meetInfo;//会议详情
   private String sponsor;//主办方
   private int oid;
   private String url_img;
	   public String getUrl_img() {
	return url_img;
}
public void setUrl_img(String url_img) {
	this.url_img = "/load/"+url_img;
}
	public int getMeet_id() {
		return meet_id;
	}
	public void setMeet_id(int meet_id) {
		this.meet_id = meet_id;
	}
	public String getMeet_title() {
		return meet_title;
	}
	public void setMeet_title(String meet_title) {
		this.meet_title = meet_title;
	}
	public String getMeet_points() {
		return meet_points;
	}
	public void setMeet_points(String meet_points) {
		this.meet_points = meet_points;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public Timestamp getStartDate() {
		return startDate;
	}
	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}
	public Timestamp getEndDate() {
		return endDate;
	}
	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}
	public String getToastMaster() {
		return toastMaster;
	}
	public void setToastMaster(String toastMaster) {
		this.toastMaster = toastMaster;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMeetInfo() {
		return meetInfo;
	}
	public void setMeetInfo(String meetInfo) {
		this.meetInfo = meetInfo;
	}
	public String getSponsor() {
		return sponsor;
	}
	public void setSponsor(String sponsor) {
		this.sponsor = sponsor;
	}
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}

   
}
