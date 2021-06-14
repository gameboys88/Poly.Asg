<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="col mt-4">
	<nav>
		<div class="nav nav-tabs" id="myTab" role="tablist">
			<a class="nav-link active" id="nav-userEditing-tab" data-toggle="tab"
				href="#nav-userEditing" role="tab" aria-controls="nav-userEditing"
				aria-selected="true">User editing</a> <a class="nav-link"
				id="nav-userList-tab" data-toggle="tab" href="#nav-userList"
				role="tab" aria-controls="nav-userList" aria-selected="false">User
				list</a>
		</div>
	</nav>
	<div class="tab-content" id="myTabContent">
		<div class="tab-pane fade show active" id="nav-userEditing"
			role="tabpanel" aria-labelledby="nav-userEditing-tab">
			<form action="" method="post">
				<div class="card">
					<div class="card-body">
						<div class="row">
							<div class="col">
								<div class="form-group">
									<label for="username">Username</label> <input type="text"
										class="form-control" name="username" id="username"
										aria-describedby="usernameHid" placeholder="Username">
									<small id="usernameHid" class="form-text text-muted">Username
										is required</small>
								</div>
								<div class="form-group">
									<label for="fullname">Fullname</label> <input type="text"
										class="form-control" name="fullname" id="fullname"
										aria-describedby="fullnameHid" placeholder="Fullname">
									<small id="fullnameHid" class="form-text text-muted">Fullname
										is required</small>
								</div>
							</div>
							<div class="col">
								<div class="form-group">
									<label for="password">Password</label> <input type="password"
										class="form-control" name="password" id="password"
										placeholder="Password">
								</div>
								<div class="form-group">
									<label for="email">Email</label> <input type="text"
										class="form-control" name="email" id="email"
										aria-describedby="emailHid" placeholder="Email"> <small
										id="emailHid" class="form-text text-muted">Email is
										required</small>
								</div>
							</div>
						</div>
					</div>
					<div class="card-footer text-muted">
						<button class="btn btn-success">Create</button>
						<button class="btn btn-warning">Update</button>
						<button class="btn btn-danger">Delete</button>
						<button class="btn btn-info">Reset</button>
					</div>
				</div>
			</form>
		</div>
		<div class="tab-pane fade" id="nav-userList" role="tabpanel"
			aria-labelledby="nav-userList-tab">
			<table class="table table-stripe">
				<tr>
					<td>Username</td>
					<td>Fullname</td>
					<td>Email</td>
					<td>Role</td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td>Kakashi</td>
					<td>Kakashi Hatake</td>
					<td>kakashi@xxx</td>
					<td>Admin</td>
					<td><a href=""><i class="fas fa-edit    "></i>Edit</a> <a
						href=""><i class="fas fa-trash    "></i>Delete</a></td>
				</tr>
			</table>
		</div>
	</div>
</div>