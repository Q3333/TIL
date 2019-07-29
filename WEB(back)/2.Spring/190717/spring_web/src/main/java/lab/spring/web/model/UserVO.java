package lab.spring.web.model;


import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserVO {
	String userid;
	@JsonIgnore
	String userpwd;
	String username;
	String phone;
	String email;
	String address;
	String job;
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUserpwd() {
		return userpwd;
	}
	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	
	
	@Override
	public String toString() {
		return "UserVO [userid=" + userid + ", userpwd=" + userpwd + ", username=" + username + ", phone=" + phone
				+ ", email=" + email + ", address=" + address + ", job=" + job + "]";
	}
	
	
	
	
}
