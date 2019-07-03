package lab.web.model;

import java.sql.Date;

public class EmailVO {
	private String username;
	private String email;
	private int no;
	public EmailVO() {
		super();
	}
	public EmailVO(String username, String email, int no) {
		super();
		this.username = username;
		this.email = email;
		this.no = no;
	}
	public String getUsername() {
		return username;
	}
	public String getEmail() {
		return email;
	}
	public int getNo() {
		return no;
	}

	
	
}
