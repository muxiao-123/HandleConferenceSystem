package conference.handle.bean;

import java.sql.Timestamp;

public class Message {
   
	private int message_id;
	private String meetTitle;
	private String messageContent;
	private Timestamp sendTime;
	private String sender;
	private int oid;
	private int meet_id;
	public int getMeet_id() {
		return meet_id;
	}
	public void setMeet_id(int meet_id) {
		this.meet_id = meet_id;
	}
	public int getMessage_id() {
		return message_id;
	}
	public void setMessage_id(int message_id) {
		this.message_id = message_id;
	}
	public String getMeetTitle() {
		return meetTitle;
	}
	public void setMeetTitle(String meetTitle) {
		this.meetTitle = meetTitle;
	}
	public String getMessageContent() {
		return messageContent;
	}
	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}
	public Timestamp getSendTime() {
		return sendTime;
	}
	public void setSendTime(Timestamp sendTime) {
		this.sendTime = sendTime;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	
	
}
