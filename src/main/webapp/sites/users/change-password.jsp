<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="offset-3 col-6 mt-4">
	<form action="" method="post">
		<div class="card">
			<div class="card-header">
				<b>Change password</b>
			</div>
			<div class="card-body">
				<div class="row">
					<div class="col">
						<div class="form-group">
							<label for="username">Username</label> <input type="text"
								class="form-control" name="username" id="username"
								aria-describedby="usernameHid" placeholder="Username"> <small
								id="usernameHid" class="form-text text-muted"></small>
						</div>
						<div class="form-group">
							<label for="password">Password</label> <input type="password"
								class="form-control" name="password" id="password"
								placeholder="Password">
						</div>
					</div>
					<div class="col">
						<div class="form-group">
							<label for="currentPassword">Current password</label> <input
								type="password" class="form-control" name="currentPassword"
								id="currentPassword" placeholder="Current password">
						</div>
						<div class="form-group">
							<label for="confirmPassword">Confirm password</label> <input
								type="password" class="form-control" name="confirmPassword"
								id="confirmPassword" placeholder="Confirm password">
						</div>
					</div>
				</div>
			</div>
			<div class="card-footer text-muted">
				<button class="btn btn-success">Change password</button>
			</div>
		</div>
	</form>
</div>