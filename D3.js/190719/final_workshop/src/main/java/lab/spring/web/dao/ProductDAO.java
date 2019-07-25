package lab.spring.web.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lab.spring.web.model.ProductVO;



@Repository
public class ProductDAO {
	// Spring 연동하는 DAO
	@Autowired
	SqlSession sqlSession;
	
	
	public int addProduct(ProductVO vo) {
		System.out.println(vo);
		return sqlSession.insert("product.addProduct",vo);		
	}
	
	public List<ProductVO> getProductList(){
		System.out.println(sqlSession.selectList("product.getProductList").size());
		return sqlSession.selectList("product.getProductList");
	}
	
	public int updateProduct(ProductVO vo) {
		return sqlSession.update("product.modifyProduct",vo);		
	}
	
	public int removeProduct(final String pid) {
		return sqlSession.delete("product.removeProduct",pid);
	}
	
	public ProductVO findProduct(String pid) {
		return sqlSession.selectOne("product.getProduct",pid);
	}
	
	
	
}