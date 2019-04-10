package conference.handle.bean;

import java.util.List;

public class QDTongJi<T> {
	//总的规模数
	private int allTotal;
	//报名数
    private int allBM;
	//签到数
	private int allQD;
	//所有报名用户
	private List<String> allUser;
	//未签到数
	private int allNQD;
	//所有未签到人员
	private List<String> allUserN;
	//签到人员
	private int userK;
	private List<Qd_item> allUserK;
	//补录人员
	private int userK1;
	private List<Qd_item> allUserK1;
	
	//会议标题
	private String meet_title;
	public int getUserK() {
		return userK;
	}
	public void setUserK(int userK) {
		this.userK = userK;
	}
	public int getUserK1() {
		return userK1;
	}
	public void setUserK1(int userK1) {
		this.userK1 = userK1;
	}
	public List<Qd_item> getAllUserK1() {
		return allUserK1;
	}
	public void setAllUserK1(List<Qd_item> allUserK1) {
		this.allUserK1 = allUserK1;
	}
	
	
	
	public List<Qd_item> getAllUserK() {
		return allUserK;
	}
	public void setAllUserK(List<Qd_item> allUserK) {
		this.allUserK = allUserK;
	}
	
	
	public int getAllTotal() {
		return allTotal;
	}
	public void setAllTotal(int allTotal) {
		this.allTotal = allTotal;
	}
	public int getAllBM() {
		return allBM;
	}
	public void setAllBM(int allBM) {
		this.allBM = allBM;
	}
	public int getAllQD() {
		return allQD;
	}
	public void setAllQD(int allQD) {
		this.allQD = allQD;
	}
	public List<String> getAllUser() {
		return allUser;
	}
	public void setAllUser(List<String> allUser) {
		this.allUser = allUser;
	}
	public List<String> getAllUserN() {
		return allUserN;
	}
	public void setAllUserN(List<String> allUserN) {
		this.allUserN = allUserN;
	}
	public int getAllNQD() {
		return allNQD;
	}
	public void setAllNQD(int allNQD) {
		this.allNQD = allNQD;
	}
	public String getMeet_title() {
		return meet_title;
	}
	public void setMeet_title(String meet_title) {
		this.meet_title = meet_title;
	}
	
	
	
}
