package conference.handle.util;


import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
public class DataFormatUtil {
     
	@Test
	public void transform1() {
		//2019-01-02 17:00:00
		Timestamp ts= new Timestamp(System.currentTimeMillis());
		String tsStr="2019-01-02 17:00:00";
		try {
			ts=Timestamp.valueOf(tsStr);
			System.out.println(ts);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//String转Date
	public static Timestamp transform1(String bb) {
//		Timestamp ts= new Timestamp(System.currentTimeMillis());
//		String tsStr="bb";
//		//数据类型必须是yyyy-mm-dd HH:mm:ss;
//		try {
//			ts=Timestamp.valueOf(tsStr);
//			return ts;
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		//return ts;
		//Timestamp aa=new Timestamp();
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Timestamp date;
		try {
			date=Timestamp.valueOf(bb);
			//date = (Date) format1.parse(bb);
			//SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			//String sdate=format2.format(date);
			//imestamp fTimestamp=Timestamp.valueOf(sdate);
			return date;
		} catch (Exception e) {
			e.printStackTrace();
		}
		   return null;
	}
	//date转字符串
	   public static  String transform(Date b) {
		 //Timestamp ts= new Timestamp(System.currentTimeMillis());
		   //直接传值转换
		 String tsStr="";
		 // SimpleDateFormat sdf= new SimpleDateFormat("yyyy-mm-dd HH:mm");
//		 //System.out.println(sdf.format(date));
//		 return sdf.format(b);
		  DateFormat sdf=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		  tsStr=sdf.format(b);
		  //tsStr=ts.toString();
		 //Date date=new Date();
		 //date=b;
		 //SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		   return tsStr;
	 }

//	public static Date transfrom1(String sDate) {
//		//String string="2016-10-24 21:59:06";
////		字符串转变为date类型
//		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-mm-dd HH:mm");
//		Date dd=new Date();
//		try {
//			dd= sdf.parse(sDate);
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//		 return dd;
//	}




}
