package lab.board.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Vector;

public class BbsVO {
	private int bid;
	private String subject;
	private String writer;
	private String password;
	private Date idate;
	private String contents;
	private String email;
	private String ip;
	private String fileYN;
	private int rcount;
	private int vcount;
	protected Vector<CommentVO> comments;
	private ArrayList<FileInfoVO> files;
	
	public BbsVO() {
		comments = new Vector<CommentVO>();
		files = new ArrayList<FileInfoVO>();
	}
	
	public void addComment(CommentVO a) {
		comments.add(a);
	}

	public void addFiles(FileInfoVO a) {
		files.add(a);
	}
	
	
	public ArrayList<FileInfoVO> getFiles() {
		return files;
	}

	public void setFiles(ArrayList<FileInfoVO> files) {
		this.files = files;
	}

	public Vector<CommentVO> getComments() {
		return comments;
	}

	public void setComments(Vector<CommentVO> comments) {
		this.comments = comments;
	}

	


	public void setSubject(String subject) {
		this.subject = subject;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public void setRcount(int rcount) {
		this.rcount = rcount;
	}

	public void setVcount(int vcount) {
		this.vcount = vcount;
	}

	public void setIdate(Date idate) {
		this.idate = idate;
	}

	public void setFileYN(String fileYN) {
		this.fileYN = fileYN;
	}

	public String getSubject() {
		return subject;
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

	public String getEmail() {
		return email;
	}

	public String getIp() {
		return ip;
	}

	public int getBid() {
		return bid;
	}

	public int getRcount() {
		return rcount;
	}

	public int getVcount() {
		return vcount;
	}

	public Date getIdate() {
		return idate;
	}

	public String getFileYN() {
		return fileYN;
	}

	public BbsVO(int bid,String subject, String writer, String password, Date idate,String contents, String email, String ip,
			String fileYN,  int rcount, int vcount) {
	}


	

}
