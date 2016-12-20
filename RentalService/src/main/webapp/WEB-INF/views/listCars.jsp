<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<link rel="stylesheet"
	href="https://formden.com/static/cdn/bootstrap-iso.css" />
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css" />
<script type="text/javascript"
	src="<spring:url value="/resource/js/ajax.js"/>"></script>
<title>Insert title here</title>
</head>
<body>
	<h3>Welcome ${loggedUser.firstName} ${loggedUser.lastName}!!!!   <a href="/carRentals/user/myreservation"><button class="btn btn-default btn-xs">View my List</button></a></h3>
	<section class="container-fluid col-md-2"> 
	<form:form
		id="searchCarForm" method="post" modelAttribute="Reservation"
		action="searchCarFormPost">
		<div class="form-group">
			<label for="pickuplocation">Pick up car:</label>
			<form:input path="pickuplocation" type="text" class="form-control"
				placeholder="Enter pick up location" />

		</div>
		<div class="form-group">
			<form:input path="dropofflocation" type="text" class="form-control"
				id="email" placeholder="Enter drop off location" />

		</div>
		<div class="form-group">
			<label for="">pick up date:</label>
			<form:input path="pickupdate" type="text" class="form-control"
				id="pickupdate" placeholder="Enter pick up date" />

		</div>
		<div class="form-group">
			<label for="pwd">drop off date:</label>
			<form:input path="dropoffdate" type="text" class="form-control"
				id="dropoffdate" placeholder="Enter drop off date" />
		</div>
		
			
		<input type="submit" value="Search Available Car">
	</form:form> </section>

	<section class="container-fluid col-md-10">

	<div class="panel panel-default">
		<div class="panel-body">
			<c:forEach items="${compositeModel}" var="car">
				<div class="thumbnail col-md-4">
					<img src="<c:url value="/resources/images/${car.name}.png"></c:url>"
						alt="image" style="width: 30%" />
				</div>
				<div class="caption col-md-8">
					<h3>Car name: ${car.name}</h3>
					<p>manufactured year:${car.year}</p>
					<p>Charge per day: ${car.pricePerDay}</p>
					<p>Number of Miles:${car.numberOfMiles}miles</p>
					<p>Number of Passenger: ${car.carType.noOfPerson}</p>
					<p>
						<a href="<spring:url value='/user/continueCheckout/${car.id}' />"><button
								type="button" class="btn btn-primary">Continue</button></a>
					</p>
					<td><a href="continueCheckout/${car.id}">
							<button class="btn btn-primary btn-xs"
								action="/user/continueCheckout/${car.id}">
								<span class="glyphicon glyphicon-pencil"></span>
							</button>
					</a></td>
					<td>
				</div>
			</c:forEach>
		</div>
	</section>






</body>
</html>