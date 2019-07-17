package lab.spring.aop.service;

import java.util.Locale;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import lab.spring.aop.persist.UserManageDAO;
import lab.spring.aop.persist.UserVO;


@Service("userService")

public class UserServiceImpl implements UserService, ApplicationContextAware {
	@Autowired
	private UserManageDAO dao;
	private ApplicationContext context;
	


	public void setDao(UserManageDAO dao) {
		this.dao = dao;
	}

	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		this.context = arg0;
	}
	
	public int registMember(UserVO vo) {
		int result = 0;
		result = dao.joinProc(vo);
		
		return result;
	}
	
	
	
}
