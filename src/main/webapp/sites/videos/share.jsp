<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="offset-3 col-6">
	<form action="" method="post">
		<div class="card">
			<div class="card-header">Send video to your friends</div>
			<div class="card-body">
				<div class="form-group">
					<label for="email">Your friend's email:</label> <input type="text"
						class="form-control" name="email" id="email"
						aria-describedby="emailHid" placeholder="Email"> <small
						id="emailHid" class="form-text text-muted">Email is
						required</small>
				</div>
			</div>
			<div class="card-footer text-muted">
				<button class="btn btn-success">Send</button>
			</div>
		</div>
	</form>
</div>