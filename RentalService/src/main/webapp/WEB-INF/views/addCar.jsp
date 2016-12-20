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
<title>Add new Car</title>
</head>
<body>
	<form:form class="form-horizontal" modelAttribute="verynewCar"
		action="addverynewCar" method="post" enctype="multipart/form-data">
		<div class="form-group">
			<label for="name">Car Name: </label>
			<form:input id="name" path="name" placeholder="Enter name of car"
				type="text" class="form-control" value="${name}" />
			<form:errors path="name" class="text-danger" />
		</div>

		<div class="form-group">
			<label for="name">Car make Year: </label>
			<form:input id="year" path="year"
				placeholder="Enter model year of car" type="text"
				class="form-control" />
			<form:errors path="name" class="text-danger" />
		</div>
		<div class="form-group">
			<label for="name">Car price: </label>
			<form:input id="name" path="pricePerDay" placeholder="Enter pice pre day"
				type="text" class="form-control" />
			<form:errors path="pricePerDay" class="text-danger" />
		</div>
		<div class="form-group">
			<label for="name">No of miles used: </label>
			<form:input id="name" path="numberOfMiles"
				placeholder="Enter car used duration" type="text"
				class="form-control" />
			<form:errors path="numberOfMiles" class="text-danger" />
		</div>
		<label for="company">Select Company: </label>
		<form:select path="company" class="dropdown">
			<form:options items="${companyList}" />
		</form:select>
		<a href="/carRental/admin/addType"><button type="button"
				class="btn btn-default">Add new type</button></a>

		<div class="form-group">
			<label class="control-label col-lg-1" for="productImage">Upload
				Image:</label>
			<div class="col-lg-10">
				<form:input id="carImage" path="carImage" type="file"
					class="form:input-large" />
			</div>
		</div>

		<div class="form-group">
			<div class="col-lg-offset-2 col-lg-10">
				<input type="submit" id="btnAdd" class="btn btn-primary" value="Add Car" />
			</div>
		</div>
	</form:form>

</body>
</html>
