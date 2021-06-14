package edu.poly.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class PageInfo {
	private String title;
	private String contentUrl;
	private String scriptUrl;
	
	public static Map<PageType, PageInfo> pageRoute = new HashMap();
	
	static {
		pageRoute.put(PageType.USER_MANAGEMENT_PAGE, new PageInfo("User management", "/admin/users/users.jsp", null));
		pageRoute.put(PageType.REPORT_MANAGEMENT_PAGE, new PageInfo("Reports", "/admin/reports/reports.jsp", null));
		pageRoute.put(PageType.VIDEO_MANAGEMENT_PAGE, new PageInfo("Video management", "/admin/videos/videos.jsp", null));
		
		pageRoute.put(PageType.SITE_HOME_PAGE, new PageInfo("Home page", "/sites/home/home.jsp", null));
		pageRoute.put(PageType.SITE_LOGIN_PAGE, new PageInfo("Login", "/sites/users/login.jsp", null));
		pageRoute.put(PageType.SITE_REGISTRATION_PAGE, new PageInfo("Registration", "/sites/users/registration.jsp", null));
		pageRoute.put(PageType.SITE_CHANGE_PASSWORD_PAGE, new PageInfo("Change password", "/sites/users/change-password.jsp", null));
		pageRoute.put(PageType.SITE_EDIT_PROFILE_PAGE, new PageInfo("Edit profile", "/sites/users/edit-profile.jsp", null));
		pageRoute.put(PageType.SITE_FORGOT_PASSWORD_PAGE, new PageInfo("Forgot password", "/sites/users/forgot-password.jsp", null));
		pageRoute.put(PageType.SITE_FAVORITE_PAGE, new PageInfo("Favorites", "/sites/videos/favorite.jsp", null));
		pageRoute.put(PageType.SITE_SHARE_PAGE, new PageInfo("Shares", "/sites/videos/share.jsp", null));
		pageRoute.put(PageType.SITE_VIDEO_DETAIL_PAGE, new PageInfo("Video detail", "/sites/videos/detail.jsp", null));
	}
	
	public static void prepareAndForwardAdmin(HttpServletRequest req, HttpServletResponse resp, PageType pageType) throws ServletException, IOException {
		PageInfo page = pageRoute.get(pageType);
		req.setAttribute("page", page);
		req.getRequestDispatcher("/admin/layout.jsp").forward(req, resp);
	}
	
	public static void prepareAndForwardSite(HttpServletRequest req, HttpServletResponse resp, PageType pageType) throws ServletException, IOException {
		PageInfo page = pageRoute.get(pageType);
		req.setAttribute("page", page);
		req.getRequestDispatcher("/sites/layout.jsp").forward(req, resp);
	}
	
	public PageInfo(String title, String contentUrl, String scriptUrl) {
		super();
		this.title = title;
		this.contentUrl = contentUrl;
		this.scriptUrl = scriptUrl;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContentUrl() {
		return contentUrl;
	}
	public void setContentUrl(String contentUrl) {
		this.contentUrl = contentUrl;
	}
	public String getScriptUrl() {
		return scriptUrl;
	}
	public void setScriptUrl(String scriptUrl) {
		this.scriptUrl = scriptUrl;
	}
	
	
}
