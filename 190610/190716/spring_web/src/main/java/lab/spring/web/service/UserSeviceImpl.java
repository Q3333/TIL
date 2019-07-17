package lab.spring.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lab.spring.web.dao.UserDAO;
import lab.spring.web.model.UserVO;


@Service("userService")
public class UserSeviceImpl implements UserService{
	
	public List<UserVO> findUser(String condition, String keyword) {
		return dao.findUser(condition, keyword);
	}

	@Autowired
	private UserDAO dao;
	
	public int addUser(UserVO user) {
		return dao.addUser(user);
	}

	public int updateUser(UserVO user) {
		return dao.updateUser(user);
	}

	public int removeUser(String uid) {
		return dao.removeUser(uid);
	}

	public UserVO findUser(String uid) {
		return dao.findUser(uid);
	}

	public UserVO login(String uid, String upwd) {
		return dao.login(uid, upwd);
	}

	public List<UserVO> findUserList() {
		return dao.findUserList();
	}
	
}
