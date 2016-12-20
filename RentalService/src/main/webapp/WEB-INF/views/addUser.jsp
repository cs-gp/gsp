<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link
	href="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.28//angular-route.min.js"
	rel="script">
<link href="http://getbootstrap.com/dist/css/bootstrap.css"
	rel="stylesheet">
<link href="http://getbootstrap.com/examples/jumbotron/jumbotron.css"
	rel="stylesheet" />
<title>Create New User</title>
</head>
<body>




	<form:form class="form-horizontal" align="center"
		justify-content="left" overflow="hidden" modelAttribute="user"
		action="addUser" method="post">
		<div class="form-group">
			<label class="control-label col-lg-2 col-lg-2" for="uname">
				First Name:</label>
			<div class="col-lg-10">
				<form:input path="firstName" type="text" />
				<form:errors path="firstName" class="text-danger" />
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-lg-2 col-lg-2"> Last Name:</label>
			<div class="col-lg-10">
				<form:input path="lastName" type="text" />
				<form:errors path="lastName" class="text-danger" />
			</div>
		</div>

		<div class="control-group">

			Email:
			<form:input path="email" type="text" />
			<form:errors path="email" class="text-danger" />
		</div>
		<div class="control-group">
			Password:
			<form:input path="password" type="password" />
			<form:errors path="password" class="text-danger" />
		</div>
		<div class="control-group">
			UserName: <form:input path="userName" type="text" />
			<!-- variefy retype password by angular-->
		</div>
		
		<div class="control-group">
			City:
			<form:input path="address.city" type="text" />
			<form:errors path="address.city" class="text-danger" />
		</div>
		<div class="control-group">
			State:
			<form:input path="address.state" type="text" />
			<form:errors path="address.state" class="text-danger" />
		</div>
		<div class="control-group">
			ZIP:
			<form:input path="address.zip" type="text" />
			<form:errors path="address.zip" class="text-danger" />
		</div>
		<div class="control-group">

			Street:
			<form:input path="address.street" type="text" />
			<form:errors path="address.street" class="atext-danger" />
		</div>

		<input type="submit" name="submit" class="btn btn-success"
			value="Add User">


	</form:form>

</body>
</html>

