package lab.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lab.web.model.LoginDAO;
import lab.web.model.UserVO;


 
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.sendRedirect("./member.jsp");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		UserVO User = new UserVO();
		PrintWriter out = response.getWriter();
		User.setUserid(request.getParameter("userid")); 
		User.setUserpwd(request.getParameter("userpwd"));
		User.setUsername(request.getParameter("username"));
		User.setPhone(request.getParameter("phone"));
		User.setEmail(request.getParameter("email"));
		User.setAddress(request.getParameter("address"));
		User.setJob(request.getParameter("job"));
		
		
		LoginDAO dao = new LoginDAO();
		ServletContext sc = request.getServletContext();
		RequestDispatcher rd = null;
		
		if(dao.joinProc(User)>0) {
			rd = sc.getRequestDispatcher("/memberOK3.jsp");
			request.setAttribute("user", User);
			rd.forward(request, response);
			
		}
		
		else {
			out.print("<script>");
			out.print("alert(\"회원가입 실패\");");
			out.print("location.href=\"./member.jsp\"");
			out.print("</script>");
			
		}
			
	}

}
