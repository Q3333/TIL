package lab.spring.orm.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.core.io.Resource;


import lab.spring.orm.dao.UserManageDAO;
import lab.spring.orm.model.UserVO;

public class SqlMappingTest {

	public static void main(String[] args) throws IOException{
		String resource = "mybatis_config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory
		= new SqlSessionFactoryBuilder().build(inputStream);
		UserManageDAO userDao = new UserManageDAO();
		userDao.setSqlSessionFactory(sqlSessionFactory);
	
		System.out.println("####################전체목록####################");
		List<UserVO> lists = userDao.findUserList();
		Iterator<UserVO> iter = lists.iterator();
		while(iter.hasNext()) {
			UserVO u = iter.next();
			System.out.println(u);
		}

		UserVO vo = new UserVO();
		vo.setUserid("s3");
		vo.setUsername("서울3");
		vo.setUserpwd("1234");
		vo.setEmail("spdsal@koreasda.or.kr");
		vo.setPhone("102-12332-1111");
		vo.setAddress("서울");
		vo.setJob("백수");
		
		System.out.println("insert rows =>" + userDao.addUser(vo));
		System.out.println("######## s3 아이디 한행 검색 #######");
		System.out.println(userDao.findUser("s3"));
		
		vo.setUserid("s3");
		vo.setEmail("g3g3@BUsan.or.kr");
		vo.setPhone("080-12332-1111");
		vo.setAddress("부산");
		vo.setJob("배고픈사람");
		
		System.out.println("update : s3 => " + userDao.updateUser(vo));
		System.out.println(userDao.findUser("s3"));
		System.out.println("delete : s3 => " + userDao.removeUser("s3"));
		System.out.println("####################전체목록####################");
		lists = userDao.findUserList();
		iter = lists.iterator();
		while(iter.hasNext()) {
			UserVO u = iter.next();
			System.out.println(u);
		}
	
	
	}

}
