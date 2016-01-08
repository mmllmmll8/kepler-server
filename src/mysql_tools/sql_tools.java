package mysql_tools;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import object.Record;

public class sql_tools {
	
 
	public static void recordsql(Class<?> object, String table_name){
		//数据库操作-mysql
		Field[] fields = object.getDeclaredFields();
		String sql1 = "INSERT INTO "+ table_name;
		String sql2 = "VALUES";
		String haha1 = "(";
		String haha2 = "(";
		for (int i = 0; i < fields.length; i++) {
			try {
				String name = fields[i].getName();
				haha1 += name + ",";
				String value = (String) fields[i].get(object);
				haha2 +="'" + value+ "'" + ",";
			} catch (IllegalArgumentException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		haha1 = haha1.substring(0,haha1.length()-1)+")";
		haha2 = haha2.substring(0,haha2.length()-1)+")";
		String sql = sql1 + haha1 + sql2 + haha2;
		try {
			Connection conn = DriverManager.getConnection(url, user, password);
			PreparedStatement pst = conn.prepareStatement(sql);//准备执行语句  
			conn.close();  
			pst.close(); 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//获取连接  
	}
}
