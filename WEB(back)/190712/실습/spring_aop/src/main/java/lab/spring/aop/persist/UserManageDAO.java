package lab.spring.aop.persist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Repository;

import lab.spring.aop.util.JdbcUtil;


@Repository("dao")
public class UserManageDAO {
	//private JdbcUtil dbUtil;
	private JdbcTemplate template;
	
//	@Autowired
//	public void setDbUtil(JdbcUtil dbUtil) {
//		this.dbUtil = dbUtil;
//	}
	
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

	
	public int joinProc(final UserVO user) {
		//insert 처리
		int rows = 0;
		final StringBuffer sql = new StringBuffer();
		sql.append("insert into userinfo (userid, username, userpwd, email, phone, address, job)");
		sql.append(" values (?,?,?,?,?,?,?)");
		rows = template.update(new PreparedStatementCreator() {
			
			public PreparedStatement createPreparedStatement (Connection con)
			throws SQLException {
				PreparedStatement pstat = con.prepareStatement(sql.toString());
				pstat.setString(1, user.getUserid());
				pstat.setString(2, user.getUsername());
				pstat.setString(3, user.getUserpwd());
				pstat.setString(4, user.getEmail());
				pstat.setString(5, user.getPhone());
				pstat.setString(6, user.getAddress());
				pstat.setString(7, user.getJob());
				return pstat;
			}
		});
		return rows;
	}
	
	public List<UserVO> findUserList(){
		List<UserVO> userList =null;
		String sql = "select * from userinfo ";
		userList = template.query(sql, new UserRowMapper());
		return userList;
	}
	
	public UserVO findUser (String userid) {
		Object vo = null;
		String sql = "select * from userinfo where userid = ? ";
		vo = template.queryForObject(sql, new Object[] {userid}, new UserRowMapper());
		return (UserVO)vo;
	}
	
	public int updateUser(final UserVO user) {
		int rows = 0;
		final StringBuffer sql = new StringBuffer();
		sql.append("update userinfo set email=?, phone=?, address=?, job=? ");
		sql.append("where userid = ?");
		rows = template.update(new PreparedStatementCreator() {
			
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstat = con.prepareStatement(sql.toString());
				pstat.setString(1, user.getEmail());
				pstat.setString(2, user.getPhone());
				pstat.setString(3, user.getAddress());
				pstat.setString(4, user.getJob());
				pstat.setString(5, user.getUserid());
				return pstat;
			}
		});
		return rows;
	}
	
	public int removeUser(final String userid) {
		int rows=0;
		final String sql = "delete userinfo where userid = ?";
		rows = template.update(new PreparedStatementCreator() {
			
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstat =  con.prepareStatement(sql);
				pstat.setString(1, userid);
				return pstat;
			}
		});
		return rows;
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
	
	
	
//	public int joinProc(UserVO userVO) {
//		int rows = 0;
//		Connection con = null;
//		PreparedStatement stat = null;
//		String sql = "insert into userinfo "
//				+ "(userid, username, userpwd, phone, email, address, job) "
//				+ "values (?, ?, ?, ?, ?, ?, ?)";
//		try {
//			con = dbUtil.dbCon();
//			stat = con.prepareStatement(sql);
//			stat.setString(1, userVO.getUserid());
//			stat.setString(2, userVO.getUsername());
//			stat.setString(3, userVO.getUserpwd());
//			stat.setString(4, userVO.getPhone());
//			stat.setString(5, userVO.getEmail());
//			stat.setString(6, userVO.getAddress());
//			stat.setString(7, userVO.getJob());
//			rows = stat.executeUpdate();
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//		}
//		finally {
//			dbUtil.dbClose(con, stat, null);
//		}
//		
//		return rows;
//
//	}
	
	
	
	
}
