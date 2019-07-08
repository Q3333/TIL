import java.util.ArrayList;

import lab.board.model.ProductDAO;
import lab.board.model.ProductVO;

public class prac {

	public static void main(String[] args) {
		ProductDAO dao = new ProductDAO();
		ProductVO headers = null;
		
		headers = dao.getProduct("P1235");
		
		System.out.println(headers);

	}

}
