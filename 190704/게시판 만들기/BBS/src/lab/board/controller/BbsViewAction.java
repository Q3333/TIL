package lab.board.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lab.board.model.BbsDAO;
import lab.board.model.BbsVO;

public class BbsViewAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BbsViewAction() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		ServletContext sc = getServletContext();
		RequestDispatcher rd = null;
		BbsDAO dao = new BbsDAO();
		int num = Integer.parseInt(request.getParameter("bid"));
		BbsVO article = new BbsVO();
		
		
		String page = request.getParameter("page");
		
	
		article = dao.getArticle(num);
		
		if (article != null) {
			request.setAttribute("article", article);
			request.setAttribute("bid", new Integer(num));
			request.setAttribute("page", new Integer(page));
			rd = sc.getRequestDispatcher("/bbs_view.jsp");
			rd.forward(request, response);
		}else {
			out.print("<script>");
			out.print("alert(\"글 내용 조회 실패\");");
			out.print("location.href=\"./list.do\"");
			out.print("</script>");
			
			}

}
}
