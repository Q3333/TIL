package lab.board.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lab.board.model.BbsDAO;
import lab.board.model.BbsVO;
import lab.board.model.CommentVO;

/**
 * Servlet implementation class BbsCommentAction
 */
//@WebServlet("./comment.do")
public class BbsCommentAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		response.sendRedirect("./bbs_write.jsp");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		BbsDAO dao = new BbsDAO();
		CommentVO form = null;
		String page = null;
		page = request.getParameter("page");
		form = new CommentVO();
		int bid = Integer.parseInt(request.getParameter("bid"));
		
		form.setRbid(bid);
		form.setContents(request.getParameter("contents"));
		form.setWriter(request.getParameter("writer"));
		form.setPassword(request.getParameter("password"));
		form.setIp(request.getRemoteAddr());
		
		if (dao.insertComment(form) > 0) {
			response.sendRedirect("./view.do?bid="+bid+"&page="+page);
		}
	}

}
