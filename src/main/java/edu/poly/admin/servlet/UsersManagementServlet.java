package edu.poly.admin.servlet;

import java.io.IOException;

import edu.poly.common.PageInfo;
import edu.poly.common.PageType;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/UsersManagement")
public class UsersManagementServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PageInfo.prepareAndForwardAdmin(req, resp, PageType.USER_MANAGEMENT_PAGE);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
