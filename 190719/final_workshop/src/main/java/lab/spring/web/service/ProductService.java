package lab.spring.web.service;

import java.util.List;

import lab.spring.web.model.ProductVO;



public interface ProductService {
	public int addProduct(ProductVO vo);
	public int updateProduct(ProductVO vo);
	public int removeProduct(String pcode);
	public ProductVO findProduct(String pcode);
	public List<ProductVO> getProductList();
}
