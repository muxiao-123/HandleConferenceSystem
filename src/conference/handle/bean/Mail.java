package conference.handle.bean;

public class Mail {

	//发送者邮箱
	private String send;
	//发送者授权密码，默认是qq授权密码
	private String sPassword;
	//接受者邮箱
	private String reciv;
	//邮件内容
	private String content;
	//邮件标题
	private String title;
	public String getSend() {
		return send;
	}
	public void setSend(String send) {
		this.send = send;
	}
	public String getsPassword() {
		return sPassword;
	}
	public void setsPassword(String sPassword) {
		this.sPassword = sPassword;
	}
	public String getReciv() {
		return reciv;
	}
	public void setReciv(String reciv) {
		this.reciv = reciv;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	
}
