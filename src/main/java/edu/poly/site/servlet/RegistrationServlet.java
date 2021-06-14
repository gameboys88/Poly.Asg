package edu.poly.site.servlet;

import java.io.IOException;

import org.apache.commons.beanutils.BeanUtils;

import edu.poly.common.PageInfo;
import edu.poly.common.PageType;
import edu.poly.dao.UserDao;
import edu.poly.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Registration")
public class RegistrationServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PageInfo.prepareAndForwardSite(req, resp, PageType.SITE_REGISTRATION_PAGE);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = new User();
		try {
			BeanUtils.populate(user, req.getParameterMap());
			
			UserDao dao = new UserDao();
			dao.insert(user);
			
			req.getRequestDispatcher("/Login").forward(req, resp);
			return;
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", e.getMessage());
		}
		req.setAttribute("user", user);
		PageInfo.prepareAndForwardSite(req, resp, PageType.SITE_REGISTRATION_PAGE);
	}
}
