package lab.board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lab.board.model.BbsDAO;
import lab.board.model.BbsVO;
import lab.board.model.ProductDAO;
import lab.board.model.ProductVO;


@WebServlet("/product.do")
public class BbsShopAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public BbsShopAction() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		ServletContext sc = request.getServletContext();
		RequestDispatcher rd = null;
		ProductDAO dao = new ProductDAO();
		ArrayList<ProductVO> headers = null;
		
		
		headers = dao.getProductList();
			
		request.setAttribute("products", headers);

	rd = sc.getRequestDispatcher("/bbs_shop.jsp");
	rd.forward(request, response);
	}

}
