package conference.handle.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

//释放资源

public class DButil {
	static String driverClass =null;
	static String url=null;
	static String name=null;
	static String password=null;
	
	static {
		
//		得到一个属性对象值
		try {
			Properties proper= new Properties();
			//InputStream is=new FileInputStream("JDBC.properties");
//			使用类加载器获得src文件夹下的配置文件
			InputStream is=DButil.class.getClassLoader().getResourceAsStream("JDBC.properties");
			proper.load(is);
			driverClass = proper.getProperty("driverClass");
			url = proper.getProperty("url");
			name = proper.getProperty("name");
			password = proper.getProperty("password");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//	连接数据库
	public  static Connection getConnection() {
		
		Connection conn=null;
		try {
			
			 Class.forName(driverClass);
			 conn = DriverManager.getConnection(url, name, password);
			 
			 System.out.println("连接成功");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
			return conn;
	} 
	
//	释放资源
	public static void release( Connection conn, Statement st, ResultSet rs) {
		closeRs(rs);
		closeSt(st);
		closeConn(conn);
	}
	
	public static void release( Connection conn, Statement st) {
		
		closeSt(st);
		closeConn(conn);
	}
   
	
	
//	关闭结果集
	private static void closeRs(ResultSet rs) {
		try {
			if(rs !=null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			rs = null;
		}
	}
	
	//关闭statement
//	private static void closePs(PreparedStatement ps) {
//		try {
//			if(ps !=null) {
//				ps.close();
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}finally{
//			ps = null;
//		}
//	}
	
//利用statement 对象创建关闭	
	private static void closeSt(Statement st) {
		try {
			if(st !=null) {
				st.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			st = null;
		}
	}
	
//	关闭连接
	private static void closeConn(Connection conn) {
		try {
			if(conn !=null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			conn = null;
		}

	}
	
	
	
}
