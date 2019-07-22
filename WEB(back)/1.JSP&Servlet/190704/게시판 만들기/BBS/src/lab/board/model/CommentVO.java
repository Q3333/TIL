package lab.board.model;

import java.sql.Date;

public class CommentVO {
	
	private String writer;
	private String password;
	private String contents;
	private String ip;
	private int cmid;
	private int rbid;
	private Date idate;
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public void setCmid(int cmid) {
		this.cmid = cmid;
	}
	public void setRbid(int rbid) {
		this.rbid = rbid;
	}
	public void setIdate(Date idate) {
		this.idate = idate;
	}
	public String getWriter() {
		return writer;
	}
	public String getPassword() {
		return password;
	}
	public String getContents() {
		return contents;
	}
	public String getIp() {
		return ip;
	}
	public int getCmid() {
		return cmid;
	}
	public int getRbid() {
		return rbid;
	}
	public Date getIdate() {
		return idate;
	}
	@Override
	public String toString() {
		return "CommentVO [writer=" + writer + ", password=" + password + ", contents=" + contents + ", ip=" + ip
				+ ", cmid=" + cmid + ", rbid=" + rbid + ", idate=" + idate + "]";
	}
	

}
