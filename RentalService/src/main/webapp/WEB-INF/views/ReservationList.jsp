<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<style type="text/css">
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>


<title>Insert title here</title>
</head>
<body>
	<h3>*********Reservation List************</h3>
		<div class="container">

			<table class="table">
				<thead>
					<tr>
						<th>Firstname</th>
						<th>Lastname</th>
						<th>DropOffDate</th>
						<th>DropOffLocation</th>
						<th>Car Name</th>
						<th>Insurance Name</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${loggedUser.reservation}" var="res">
						<tr class="success">
							<td>${loggedUser.firstName}</td>
							<td>${loggedUser.lastName}</td>
							<td>${res.dropoffdate}</td>
							<td>${res.dropofflocation}</td>
							<td>${res.car.name}</td>
							<td>${res.car.insurance.name}</td>
						</tr>
					</c:forEach>

				</tbody>
			</table>
			 <a href="/carRentals/user/searchCarFormPost"><button class="btn btn-default btn-xs">Back</button></a>
		</div>
</body>
</html>