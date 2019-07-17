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

import lab.board.model.ProductDAO;
import lab.board.model.ProductVO;

/**
 * Servlet implementation class ShopViewAciton
 */
@WebServlet("/productView2.do")
public class ShopViewAciton extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ShopViewAciton() {
        super();
        // TODO Auto-generated constructor stub
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
		ProductVO headers = null;
		
		headers = dao.getProduct(request.getParameter("prodid"));
		
		request.setAttribute("prod", headers);

	rd = sc.getRequestDispatcher("/product.jsp");
	rd.forward(request, response);
	}

}

//String pid = request.getParameter("PID");
//System.out.println(pid);
//headers = dao.getProduct(pid);
//	
//request.setAttribute("test2", headers);
