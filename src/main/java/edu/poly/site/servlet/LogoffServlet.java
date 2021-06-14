package edu.poly.site.servlet;

import java.io.IOException;

import edu.poly.common.CookieUtils;
import edu.poly.common.SessionUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Logoff")
public class LogoffServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CookieUtils.add("username", null, 0, resp);
		SessionUtils.invalidate(req);
		req.setAttribute("isLogin", false);
		req.getRequestDispatcher("/Homepage").forward(req, resp);
	}
}
