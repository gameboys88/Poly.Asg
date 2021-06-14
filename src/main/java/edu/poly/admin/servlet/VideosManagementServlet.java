package edu.poly.admin.servlet;

import java.io.IOException;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import edu.poly.common.PageInfo;
import edu.poly.common.PageType;
import edu.poly.common.UploadUtils;
import edu.poly.dao.VideoDao;
import edu.poly.model.Video;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet({"/Admin/VideosManagement", "/Admin/VideosManagement/create", "/Admin/VideosManagement/update", 
			"/Admin/VideosManagement/delete", "/Admin/VideosManagement/reset", "/Admin/VideosManagement/edit"})
@MultipartConfig
public class VideosManagementServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURL().toString();
		if(url.contains("edit")) {
			edit(req, resp);
			return;
		} else if(url.contains("delete")) {
			delete(req, resp);
			return;
		} else if(url.contains("reset")) {
			reset(req, resp);
			return;
		}
		Video video = new Video();
		video.setPoster("images/destop.jpg");
		req.setAttribute("video", video);
		findAll(req, resp);
		PageInfo.prepareAndForwardAdmin(req, resp, PageType.VIDEO_MANAGEMENT_PAGE);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException ,IOException {
		String url = req.getRequestURL().toString();
		if(url.contains("create")) {
			create(req, resp);
			return;
		} else if(url.contains("update")) {
			update(req, resp);
			return;
		}
		findAll(req, resp);
		PageInfo.prepareAndForwardAdmin(req, resp, PageType.VIDEO_MANAGEMENT_PAGE);
	}
	
	private void findAll(HttpServletRequest req, HttpServletResponse resp) {
		try {
			VideoDao dao = new VideoDao();
			List<Video> list = dao.findAll();
			req.setAttribute("videos", list);
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", e.getMessage());
		}
	}

	private void create(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Video video = new Video();
		try {
			BeanUtils.populate(video, req.getParameterMap());
			video.setPoster("uploads/" + UploadUtils.processUploadField("cover", req, "/uploads", video.getVideoId()));
			VideoDao dao = new VideoDao();
			dao.insert(video);
			req.setAttribute("message", "Video is inserted!");
			req.setAttribute("video", video);
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", e.getMessage());
		}
		findAll(req, resp);
		PageInfo.prepareAndForwardAdmin(req, resp, PageType.VIDEO_MANAGEMENT_PAGE);
	};
	
	private void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Video video = new Video();
		try {
			BeanUtils.populate(video, req.getParameterMap());
			VideoDao dao = new VideoDao();
			Video oldVideo = dao.findById(video.getVideoId());
			
			if(req.getPart("cover").getSize() == 0) {
				video.setPoster(oldVideo.getPoster());
			} else {
				video.setPoster("uploads/" + UploadUtils.processUploadField("cover", req, "/uploads", video.getVideoId()));
			}
			dao.update(video);
			req.setAttribute("message", "Video is updated!");
			req.setAttribute("video", video);
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", e.getMessage());
		}
		findAll(req, resp);
		PageInfo.prepareAndForwardAdmin(req, resp, PageType.VIDEO_MANAGEMENT_PAGE);
	}
	
	private void reset(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		
	}

	private void delete(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		
	}

	private void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("videoId");
		if(id == null) {
			req.setAttribute("error", "Video is required!");
			PageInfo.prepareAndForwardAdmin(req, resp, PageType.VIDEO_MANAGEMENT_PAGE);
			return;
		}
		try {
			VideoDao dao = new VideoDao();
			Video video = dao.findById(id);
			req.setAttribute("video", video);
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", e.getMessage());
		}
		findAll(req, resp);
		PageInfo.prepareAndForwardAdmin(req, resp, PageType.VIDEO_MANAGEMENT_PAGE);
	}
}


