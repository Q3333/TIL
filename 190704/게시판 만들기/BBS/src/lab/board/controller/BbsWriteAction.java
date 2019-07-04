package lab.board.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import lab.board.model.BbsDAO;
import lab.board.model.BbsVO;
import lab.board.model.FileInfoVO;

//@WebServlet("/write.do")
public class BbsWriteAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BbsWriteAction() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		response.sendRedirect("./bbs_write.jsp");
		
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		BbsDAO dao = new BbsDAO();
		BbsVO form = null;
		String page = null;
		page = request.getParameter("page");
		form = new BbsVO();
		String fileFlag = "N";
		
		if (request.getParameter("upload") != null) {
			fileFlag = "Y";
		}
		form.setFileYN(fileFlag);
		form.setWriter(request.getParameter("writer"));
		form.setPassword(request.getParameter("password"));
		form.setSubject(request.getParameter("subject"));
		form.setEmail(request.getParameter("email"));
		form.setContents(request.getParameter("contents"));
		form.setIp(request.getRemoteAddr());

		if (dao.insertBbs(form) > 0) {
			response.sendRedirect("./list.do");
		}
	}

	

	public void uploadProc(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BbsDAO dao = new BbsDAO();
		String path = "C:/uploadtest";
		File isDir = new File(path);
		String savefile = null;
		if (isDir.isDirectory()) {
			isDir.mkdir();
		}
		Collection<Part> parts = request.getParts();
		for (Part part : parts) {
			if (part.getContentType() != null) {
				String filename = part.getSubmittedFileName();
				if (filename != null) {
					savefile = filename.substring(0, filename.lastIndexOf(".")) + "_" + System.currentTimeMillis()
							+ filename.substring(filename.lastIndexOf("."));
					part.write(savefile);
					System.out.println("파일저장");
					FileInfoVO file = new FileInfoVO();
					//file.setRbid();
					file.setFilename(savefile);
					String fileType = filename.substring(filename.lastIndexOf("."));
					file.setFiletype(fileType);
					// dao.insertUploadFile(file);
				}
			}
		}

	}

}
