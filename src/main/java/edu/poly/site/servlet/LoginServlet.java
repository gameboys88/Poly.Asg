package edu.poly.site.servlet;

import java.io.IOException;

import org.apache.commons.beanutils.BeanUtils;

import edu.poly.common.CookieUtils;
import edu.poly.common.PageInfo;
import edu.poly.common.PageType;
import edu.poly.common.SessionUtils;
import edu.poly.dao.UserDao;
import edu.poly.domain.LoginForm;
import edu.poly.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = CookieUtils.get("username", req);
		if(username == null) {
			PageInfo.prepareAndForwardSite(req, resp, PageType.SITE_LOGIN_PAGE);
			return;
		}
		SessionUtils.add(req, "username", username);
		req.getRequestDispatcher("/Homepage").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			LoginForm form = new LoginForm();
			BeanUtils.populate(form, req.getParameterMap());
			
			UserDao dao = new UserDao();
			User user = dao.findById(form.getUsername());
			
			if(user != null && user.getPassword().equals(form.getPassword())){
				SessionUtils.add(req, "username", user.getUsername());
				if(form.isRemember()) {
					CookieUtils.add("username", form.getUsername(), 24, resp);
				} else {
					CookieUtils.add("username", form.getUsername(), 0, resp);
				}
				req.setAttribute("isLogin", true);
				req.setAttribute("name", user.getFullname());
				req.getRequestDispatcher("/Homepage").forward(req, resp);
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", e.getMessage());
		}
		PageInfo.prepareAndForwardSite(req, resp, PageType.SITE_LOGIN_PAGE);
	}
}
