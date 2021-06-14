package edu.poly.site.servlet;

import java.io.IOException;

import org.apache.commons.beanutils.BeanUtils;

import edu.poly.common.PageInfo;
import edu.poly.common.PageType;
import edu.poly.common.SessionUtils;
import edu.poly.dao.UserDao;
import edu.poly.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/EditProfile")
public class EditProfileServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = SessionUtils.getLoginedUsername(req);
		
		if(username == null) {
			req.getRequestDispatcher("/Login").forward(req, resp);
			return;
		}
		try {
			UserDao dao = new UserDao();
			User user = dao.findById(username);
			
			req.setAttribute("user", user);
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", e.getMessage());
		}
		PageInfo.prepareAndForwardSite(req, resp, PageType.SITE_EDIT_PROFILE_PAGE);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			User user = new User();
			BeanUtils.populate(user, req.getParameterMap());
			String username = SessionUtils.getLoginedUsername(req);
			
			UserDao dao = new UserDao();
			User oldUser = dao.findById(username);
			
			user.setAdmin(oldUser.getAdmin());
			dao.update(user);
			
			req.setAttribute("message", "User profile is updated!");
			req.setAttribute("user", user);
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", e.getMessage());
		}
		PageInfo.prepareAndForwardSite(req, resp, PageType.SITE_EDIT_PROFILE_PAGE);
	}
}
