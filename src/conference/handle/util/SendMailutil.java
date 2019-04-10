package conference.handle.util;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import conference.handle.bean.Mail;
import conference.handle.bean.Meets;

public class SendMailutil {
	
	//获取属性对象
	public Properties get() {
		    Properties prop = new Properties();
	        prop.setProperty("mail.host", "smtp.sohu.com");
	        prop.setProperty("mail.transport.protocol", "smtp");
	        prop.setProperty("mail.smtp.auth", "true");
		return prop;
		
	}

	public boolean Send(Properties prop,Mail mail,Message message,Session session) throws Exception {
	         //使用JavaMail发送邮件的5个步骤
	        //1、创建session
	       // Session session = Session.getInstance(prop);
	         //开启Session的debug模式，这样就可以查看到程序发送Email的运行状态
	        session.setDebug(true);
	         //2、通过session得到transport对象
	        Transport ts = session.getTransport();
	        //3、使用邮箱的用户名和密码连上邮件服务器，发送邮件时，发件人需要提交邮箱的用户名和密码给smtp服务器，用户名和密码都通过验证之后才能够正常发送邮件给收件人。
	        try {
	        	//连接
	        	ts.connect("smtp.qq.com", mail.getSend(),mail.getsPassword());
	        	 message = createSimpleMail(session,mail);
		         //5、发送邮件
			       try {
//				        "juwqaholwcarbdae"
				        //4、创建邮件
				        // Message 
			    	   ts.sendMessage(message, message.getAllRecipients());
			    	   ts.close();
			    	   return true;
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
					return false;
				}
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}

	}
	 
	 public  MimeMessage createSimpleMail(Session session,Mail mail)
             throws Exception {
        //创建邮件对象
        MimeMessage message = new MimeMessage(session);
         //指明邮件的发件人
        message.setFrom(new InternetAddress(mail.getSend()));
        //指明邮件的收件人，现在发件人和收件人是一样的，那就是自己给自己发
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(mail.getReciv()));
         //邮件的标题
        message.setSubject(mail.getTitle());
        //邮件的文本内容
        message.setContent(mail.getContent(), "text/html;charset=UTF-8");
         //返回创建好的邮件对象
        return message;
    }
	 public String get1(Meets meets) {
		 
		 String html="";
		 html="<html>"
		 		+ "<head>"
		 		+ "</head>"
		 		+ "<body>"+"<div>\r\n" + 
		 				"	<p>尊敬的<b>先生/女生：</b></p>\r\n" +
		 		        "   <p>&nbsp;&nbsp;&nbsp;&nbsp;    您好！</p>\r\n"+
		 				"   <p>    我们很荣幸地邀请您参加将于"+meets.getStartDate()+"在<b>"+meets.getAddress()+"</b>举办的<b>"+meets.getMeet_title()+"</b>会议</p>\n"+
		 		        "   <p>本次会议的主题是：<b>"+meets.getMeet_points()+"</b></p>"+
		 				"   <p>真诚地期待着您的积极支持于参与！</p>\n"+
		 		        "   <p>"+meets.getSponsor()+"</p>"+ 
		 				"   <p>"+new Date()+"</p>\r"+ 
		 				"  	<p>当您收到这封信的时候，您已经可以报名参会了。</p>\n" + 
		 				"  	<p>请点击链接报名参会首页: <a href='http://localhost:8080/HandleConferenceSystem/baoMing1.jsp?meet_id="+meets.getMeet_id()+"'>报名参会</a></p>\r\n" + 
		 				"  	<p>如果您的 email 程序不支持链接点击，请将上面的地址拷贝至您的浏览器(如IE)的地址栏进入。</p>\r\n" + 
		 				"  	<p>如果您还想参看更多会议信息，请登录掌上会议系统的首页</p>\r\n" + 
		 				"  	<p>希望您在该次会议中能有美好收获！</p>\r\n" + 
		 				"  	<p></p>\r\n" + 
		 				"  	<p>-----------------------</p>\r\n" + 
		 				"  	<p></p>\r\n" + 
		 				"  	<p>(这是一封自动产生的email，请勿回复。)</p>\r\n" + 
		 				"</div>"
		 		+ "<body>"
		 		+ "</html>";
		 return html;
		 
	 }
}
