package conference.handle.bean;

import java.sql.Timestamp;

public class Qd_item {
    private String meet_title;
    private String a_userName;
    private Timestamp qd_time;
	public String getMeet_title() {
		return meet_title;
	}
	public void setMeet_title(String meet_title) {
		this.meet_title = meet_title;
	}
	public String getA_userName() {
		return a_userName;
	}
	public void setA_userName(String a_userName) {
		this.a_userName = a_userName;
	}
	public Timestamp getQd_time() {
		return qd_time;
	}
	public void setQd_time(Timestamp qd_time) {
		this.qd_time = qd_time;
	}
}
