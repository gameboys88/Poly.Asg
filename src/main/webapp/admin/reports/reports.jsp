<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="col mt-4">
	<nav>
		<div class="nav nav-tabs" id="myTab" role="tablist">
			<a class="nav-link active" id="nav-favorite-tab" data-toggle="tab"
				href="#nav-favorite" role="tab" aria-controls="nav-favorite"
				aria-selected="true">Favorites</a> 
			<a class="nav-link"
				id="nav-favoriteUser-tab" data-toggle="tab" href="#nav-favoriteUser"
				role="tab" aria-controls="nav-favoriteUser" aria-selected="false">Favorite
				user</a> 
			<a class="nav-link" id="nav-shareFriends-tab" data-toggle="tab"
				href="#nav-shareFriends" role="tab" aria-controls="nav-shareFriends"
				aria-selected="false">Share friends</a>
		</div>
	</nav>
	<div class="tab-content" id="myTabContent">
		<div class="tab-pane fade show active" id="nav-favorite"
			role="tabpanel" aria-labelledby="nav-favorite-tab">
			<table class="table table-border mt-3">
				<tr>
					<td>Video title</td>
					<td>Favorites count</td>
					<td>Lastest date</td>
					<td>Oldest date</td>
				</tr>
				<c:forEach var="item" items="${favList }">
				<tr>
					<td>${item.videoTitle }</td>
					<td>${item.favoriteCount }</td>
					<td>${item.oldestDate }</td>
					<td>${item.newestDate }</td>
				</tr>
				</c:forEach>
			</table>
		</div>
		<div class="tab-pane fade" id="nav-favoriteUser" role="tabpanel"
			aria-labelledby="nav-favoriteUser-tab">
			<form action="" method="get">
				<div class="row mt-3">
					<div class="col">
						<div class="form-inline">
							<div class="form-group ml-3">
								<label>Video title <select name="" id=""
									class="form-control ml-3">
										<option value="">Java programming</option>
										<option value="">Java programming</option>
										<option value="">Java programming</option>
										<option value="">Java programming</option>
								</select>
								</label>
								<button class="btn btn-info ml-3">Report</button>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col mt-3">
						<table class="table table-border">
							<tr>
								<td>Username</td>
								<td>Fullname</td>
								<td>Email</td>
								<td>Favorite date</td>
							</tr>
							<c:forEach var="item" items="${favList }">
							<tr>
								<td>${item.videoTitle }</td>
								<td>${item.favoriteCount }</td>
								<td>${item.newestDate }</td>
								<td>${item.oldestDate }</td>
							</tr>
							</c:forEach>
						</table>
					</div>
				</div>
			</form>
		</div>
		<div class="tab-pane fade" id="nav-shareFriends" role="tabpanel"
			aria-labelledby="nav-shareFriends-tab">
			<form action="" method="get">
				<div class="row mt-3">
					<div class="col">
						<div class="form-inline">
							<div class="form-group ml-3">
								<label>Video title <select name="" id=""
									class="form-control ml-3">
										<option value="">Java programming</option>
										<option value="">Java programming</option>
										<option value="">Java programming</option>
										<option value="">Java programming</option>
								</select>
								</label>
								<button class="btn btn-info ml-3">Report</button>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col mt-3">
						<table class="table table-border">
							<tr>
								<td>Sender name</td>
								<td>Sender email</td>
								<td>Receiver email</td>
								<td>Sent date</td>
							</tr>
							<tr>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
						</table>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>