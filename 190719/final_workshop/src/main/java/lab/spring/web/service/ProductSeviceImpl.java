package lab.spring.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lab.spring.web.dao.ProductDAO;
import lab.spring.web.model.ProductVO;



@Service("userService")
public class ProductSeviceImpl implements ProductService{
	

	@Autowired
	private ProductDAO dao;
	
	public int addProduct(ProductVO product) {
		return dao.addProduct(product);
	}

	public int updateProduct(ProductVO vo) {
		return dao.updateProduct(vo);
	}

	public int removeProduct(String pcode) {
		return dao.removeProduct(pcode);
	}

	public List<ProductVO> getProductList() {
		return dao.getProductList();
	}

	public ProductVO findProduct(String pcode) {
		return dao.findProduct(pcode);
	}
	
	
	
}
