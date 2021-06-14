<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="col mt-4">
	<jsp:include page="/common/inform.jsp"></jsp:include>
	<nav>
		<div class="nav nav-tabs" id="myTab" role="tablist">
			<a class="nav-link active" id="nav-videoEditing-tab"
				data-toggle="tab" href="#nav-videoEditing" role="tab"
				aria-controls="nav-videoEditing" aria-selected="true">Video
				editing</a> 
			<a class="nav-link" id="nav-videoList-tab" data-toggle="tab"
				href="#nav-videoList" role="tab" aria-controls="nav-videoList"
				aria-selected="false">Video list</a>
		</div>
	</nav>
	<div class="tab-content" id="myTabContent">
		<div class="tab-pane fade show active" id="nav-videoEditing"
			role="tabpanel" aria-labelledby="nav-videoEditing-tab">
			<form action="" method="post" enctype="multipart/form-data">
				<div class="card">
					<div class="card-body">
						<div class="row">
							<div class="col-3">
								<div class="border p-3">
									<img src="${video.poster != null? video.poster: 'images/laptop.jpg' }" alt="" class="img-fluid">
									<div class="input-group mb-3 mt-3">
										<div class="input-group-prepend">
											<span class="input-group-text">Upload</span>
										</div>
										<div class="custom-file">
											<input type="file" class="custom-file-input" id="cover" name="cover" />
											<label for="cover">Choose file</label>
										</div>
									</div>
								</div>
							</div>
							<div class="col-9">
								<div class="form-group">
									<label for="videoId">Youtube id</label> <input type="text" value="${video.videoId }"
										class="form-control" name="videoId" id="videoId"
										aria-describedby="youtubeIdHid" placeholder="Youtube id">
									<small id="youtubeIdHid" class="form-text text-muted">Youtube
										id is required</small>
								</div>
								<div class="form-group">
									<label for="title">Video title</label> <input type="text" value="${video.title }"
										class="form-control" name="title" id="title"
										aria-describedby="videoTitleHid" placeholder="Video title">
									<small id="videoTitleHid" class="form-text text-muted">Video
										title is required</small>
								</div>
								<div class="form-group">
									<label for="views">View count</label> <input type="text" value="${video.views }"
										class="form-control" name="views" id="views"
										aria-describedby="viewCountHid" placeholder="View count">
									<small id="viewCountHid" class="form-text text-muted">View
										count is required</small>
								</div>
								<div class="form-check form-check-inline">
									<label><input type="radio" class="form-check-input" name="active" 
										id="active" value="true" ${video.active? 'checked':'' }>Active</label> 
									<label><input type="radio" class="form-check-input" name="active"
										id="active" value="false" ${!video.active? '': 'checked' }>Inactive</label>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col">
								<label for="">Description</label>
								<textarea name="description" id="description" cols="30" rows="4"
									class="form-control">${video.description }</textarea>
							</div>
						</div>
					</div>
					<div class="card-footer text-muted">
						<button class="btn btn-primary" formaction="Admin/VideosManagement/create">Create</button>
						<button class="btn btn-warning" formaction="Admin/VideosManagement/update">Update</button>
						<button class="btn btn-danger" formaction="Admin/VideosManagement/delete">Delete</button>
						<button class="btn btn-info" formaction="Admin/VideosManagement/reset">Reset</button>
					</div>
				</div>
			</form>
		</div>
		<div class="tab-pane fade" id="nav-videoList" role="tabpanel"
			aria-labelledby="nav-videoList-tab">
			<table class="table table-stripe">
				<tr>
					<td>Youtube id</td>
					<td>Video title</td>
					<td>View count</td>
					<td>Status</td>
					<td>&nbsp;</td>
				</tr>
				<c:forEach var="item" items="${videos }">
				<tr>
					<td>${item.videoId }</td>
					<td>${item.title }</td>
					<td>${item.views }</td>
					<td>${item.active? 'Active':'Deactive' }</td>
					<td>
						<a href="Admin/VideosManagement/edit?videoId=${item.videoId }"><i class="fas fa-edit    "></i>Edit</a> 
						<a href="Admin/VideosManagement/delete?videoId=${item.videoId }"><i class="fas fa-trash    "></i>Delete</a>
					</td>
				</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</div>