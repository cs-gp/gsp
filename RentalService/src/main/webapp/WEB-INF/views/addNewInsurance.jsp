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
<title>Add new Insurance</title>
<body>
<div class="container">
<form:form class="form-horizontal" modelAttribute="newInsurance" action="addNewInsurance" method="post" >
		<div class="form-group">
			<label for="name">Insurance Name: </label>
			<form:input id="name" path="name" 
				type="text" class="form-control" />
			<form:errors path="name" class="text-danger" />
		</div>

		<div class="form-group">
			<label for="name">Cost Pre Day: </label>
			<form:input id="year" path="costPerDay"
				placeholder="Enter cost" type="text"
				class="form-control"/>
			<form:errors path="costPerDay" class="text-danger" />
		</div>
		<div class="form-group">
			<label for="name">Coverage type: </label>
			<form:input id="name" path="coveredType" placeholder="Enter type of insurance"
				type="text" class="form-control" />
			<form:errors path="coveredType" class="text-danger" />
		</div>
		
		<div class="form-group">
			<div class="col-lg-offset-2 col-lg-10">
				<input type="submit" id="btnAdd" class="btn btn-primary" value="Add Car" />
			</div>
		</div>
	</form:form>
	</div>
</body>
</html>