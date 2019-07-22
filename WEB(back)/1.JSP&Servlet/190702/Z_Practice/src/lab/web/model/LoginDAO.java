package lab.web.model;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class LoginDAO {
	public Connection dbCon() {
		Connection con = null;
		try {
			Properties prop = new Properties();
			prop.load(new FileInputStream("C:/workspace2/Web07_01_2/WebContent/WEB-INF/dbinfo.properties"));
			Class.forName(prop.getProperty("driver"));
			con = DriverManager.getConnection(prop.getProperty("url"),
			prop.getProperty("user"), prop.getProperty("pwd"));
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public void dbClose(Connection con, Statement stat, ResultSet rs)
	{
		try {
			if(rs!=null) rs.close();
			if(stat!=null) stat.close();
			if(con!=null)con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public boolean loginProc(String uid, String upwd) {
		boolean success = false;
		Connection con = null;
		PreparedStatement stat = null;
		String sql = "select * from userinfo where userid=? and userpwd =?";
		ResultSet rs = null;
		try {
			con = dbCon();
			stat = con.prepareStatement(sql);
			stat.setString(1, uid);
			stat.setString(2, upwd);
			stat.executeQuery();
			rs = stat.executeQuery();
			if(rs.next()) {
				success = true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbClose(con,stat,rs);
		}
		return success;
	}
	
	public int joinProc(UserVO user) {
		//insert처리 (회원 가입 처리)
		//UserVO는 파라미터를 모두 가져오는 객체
		int rows = 0;
		Connection con = null;
		PreparedStatement stat = null;
		String sql = "insert into userinfo (userid, username, userpwd, phone, email, address, job) values (?,?,?,?,?,?,?)";
		try {
			con = dbCon();
			stat = con.prepareStatement(sql);
			stat.setString(1, user.getUserid());
			stat.setString(2, user.getUsername());
			stat.setString(3, user.getUserpwd());
			stat.setString(4, user.getPhone());
			stat.setString(5, user.getEmail());
			stat.setString(6, user.getAddress());
			stat.setString(7, user.getJob());
			
			rows=stat.executeUpdate();
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbClose(con,stat,null);
		}
		return rows;
	}
		
	
	
}


