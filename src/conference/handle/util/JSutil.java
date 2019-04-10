package conference.handle.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
public class JSutil {
	//返回差的分钟数
	public static int JiSuan(String start,String end) {
		String format="yyyy-mm-dd HH:mm:ss";
			 //String start="2019-1-2 14:20:20";
			 //String end="2019-1-2 14:23:19";
			 //Date date=new Date();
			 //String str="";
			 //SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
			 //str=sdf.format(date);
			 //String format="yyyy-mm-dd HH:mm:ss";
	            SimpleDateFormat sd= new SimpleDateFormat(format);
	            long nd=1000*24*60*60;
	            long nh=1000*60*60;
	            long nm=1000*60;
	            long ns=1000;
	            long diff;
	            try {
					diff=sd.parse(end).getTime()-sd.parse(start).getTime();
					long day=diff/nd;
					long hour=diff%nd/nh;
					long min=diff%nd%nh/nm;
					int minn=(int)min;
					long sec=diff%nd%nh%nm/ns;
					System.out.println("时间相差："+day+"天"+hour+"小时"+min+"分钟"+sec+"秒");
					//返回差的分钟数
					return minn;
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            		
		return 0;
	}
	
}
