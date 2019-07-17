package lab.spring.aop.persist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import lab.spring.aop.util.JdbcUtil;


@Repository("dao")
public class UserManageDAO {
	private JdbcUtil dbUtil;
	private JdbcTemplate template;
	
	@Autowired
	public void setDbUtil(JdbcUtil dbUtil) {
		this.dbUtil = dbUtil;
	}
	
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	public List<UserVO> loginProc(String uid, String upwd) {
		List<UserVO> lists = null;
		Object args[] = new String[] {uid,upwd};
		String sql= "select * from userinfo where userid=? and userpwd=?";
		lists = template.query(sql,args,new UserRowMapper());
		
		return lists;
	}
//	
//	public UserVO loginProc(String uid, String upwd) {
//		UserVO user = null;
//		Connection con = null;
//		PreparedStatement stat = null;
//		String sql = "select * from userinfo where userid=? and userpwd=?";
//		ResultSet rs = null;
//		try {
//			con = dbUtil.dbCon();
//			stat = con.prepareStatement(sql);
//			stat.setString(1,  uid);
//			stat.setString(2,  upwd);
//			rs = stat.executeQuery();
//			
//			while(rs.next()) {
//				user = new UserVO();
//				user.setUserid(rs.getString("userid"));
//				user.setUsername(rs.getString("username"));
//				user.setAddress(rs.getString("address"));
//				user.setEmail(rs.getString("email"));
//				user.setJob(rs.getString("job"));
//				user.setPhone(rs.getString("phone"));
//				user.setUserpwd(rs.getString("userpwd"));
//				
//			}
//			
//			
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//		}
//		finally {
//			dbUtil.dbClose(con, stat, rs);
//		}
//		
//		return user;
//	}
	
	public int joinProc(UserVO userVO) {
		int rows = 0;
		Connection con = null;
		PreparedStatement stat = null;
		String sql = "insert into userinfo "
				+ "(userid, username, userpwd, phone, email, address, job) "
				+ "values (?, ?, ?, ?, ?, ?, ?)";
		try {
			con = dbUtil.dbCon();
			stat = con.prepareStatement(sql);
			stat.setString(1, userVO.getUserid());
			stat.setString(2, userVO.getUsername());
			stat.setString(3, userVO.getUserpwd());
			stat.setString(4, userVO.getPhone());
			stat.setString(5, userVO.getEmail());
			stat.setString(6, userVO.getAddress());
			stat.setString(7, userVO.getJob());
			rows = stat.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			dbUtil.dbClose(con, stat, null);
		}
		
		return rows;

	}
	
}
