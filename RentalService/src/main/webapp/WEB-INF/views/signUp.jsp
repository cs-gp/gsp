<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css"
	href="${pageContext.request.contextPath}/css/style.css"
	rel="stylesheet" />
<link href="http://getbootstrap.com/dist/css/bootstrap.css"
	rel="stylesheet">
<link href="http://getbootstrap.com/examples/jumbotron/jumbotron.css"
	rel="stylesheet" />
<title>Create New User</title>
</head>
<body>




	<form:form class="form-horizontal" align="center"
		justify-content="left" overflow="hidden" modelAttribute="user"
		action="/carRentals/user/signUp" method="post">
		<div class="control-group">
			First Name:
			<form:input path="firstName" type="text" />
			<form:errors path="firstName" class="text-danger" />
		</div>
		<div class="control-group">

			Last Name:
			<form:input path="lastName" type="text" />
			<form:errors path="lastName" class="text-danger" />
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
			Username: <form:input path="userName" type="text" />
			<!-- variefy retype password by angular-->
		</div>
		<div class="control-group">
			<form:input path="role.role" type="hidden" value="1" />

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
			<form:errors path="address.street" class="text-danger" />
		</div>

		<input type="submit" name="submit" class="btn btn-success"
			value="Add User">


	</form:form>

</body>
</html>


