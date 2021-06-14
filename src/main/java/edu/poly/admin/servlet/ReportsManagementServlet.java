package edu.poly.admin.servlet;

import java.io.IOException;
import java.util.List;

import edu.poly.common.PageInfo;
import edu.poly.common.PageType;
import edu.poly.dao.FavoriteDao;
import edu.poly.domain.FavoriteReport;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Admin/ReportsManagement")
public class ReportsManagementServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		reportFavoriteVideos(req, resp);
		PageInfo.prepareAndForwardAdmin(req, resp, PageType.REPORT_MANAGEMENT_PAGE);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException ,IOException {
		
	};
	
	protected void reportFavoriteVideos(HttpServletRequest req, HttpServletResponse resp) throws ServletException ,IOException {
		try {
			FavoriteDao dao = new FavoriteDao();
			List<FavoriteReport> list = dao.reportFavoriteByVideos();
			req.setAttribute("favList", list);
		} catch(Exception e) {
			e.printStackTrace();
			req.setAttribute("error", e.getMessage());
		}
	};
}
