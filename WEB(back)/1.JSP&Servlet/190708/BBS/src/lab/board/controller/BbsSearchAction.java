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

/**
 * Servlet implementation class BbsSearchAction
 */
//@WebServlet("/serach.do")
public class BbsSearchAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static int numPerPage = 10;
	public static int numPerBlock = 10;
 
    public BbsSearchAction() {
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
		BbsDAO dao = new BbsDAO();
		ArrayList<BbsVO> headers = null;
		String page = null;
		page = request.getParameter("page");
		int pageNo = 1;

		String SearchKey = request.getParameter("searchKey");
		String SearchWord = request.getParameter("searchWord");
		
		if(page == null) {
			pageNo = dao.getPageCount(numPerPage);
			headers = dao.getSearchList(pageNo, numPerPage, SearchKey,SearchWord);
		} else {
			pageNo = Integer.parseInt(page);
			headers = dao.getSearchList(pageNo, numPerPage, SearchKey,SearchWord);
		}
		
		Integer totalPage =new Integer(dao.getPageCount(numPerPage));
		request.setAttribute("headers", headers);
		request.setAttribute("pageNo", new Integer(pageNo));
		request.setAttribute("totalPage", totalPage);
		
	rd = sc.getRequestDispatcher("/bbs_list.jsp");
	rd.forward(request, response);
		
	}	

}
