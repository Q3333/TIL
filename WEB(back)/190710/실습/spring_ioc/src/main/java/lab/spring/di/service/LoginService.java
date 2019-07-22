package lab.spring.di.service;

import lab.spring.di.persist.UserVO;

public interface LoginService {
	public String[] login (String userid, String userpwd);
}
