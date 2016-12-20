<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<style type="text/css">
@import
url(
"<spring:url value="
/
css
/admin.css"/>");
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

	<div class="container-fluid">
		<!-- Second navbar for categories -->
		<!-- Second navbar for search -->
		<nav class="navbar navbar-inverse">
		<div class="container">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar-collapse-3">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Brand</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse" id="navbar-collapse-3">
				<ul class="nav navbar-nav navbar-left">
					<li><a href="/carRentals/admin/addverynewCar">Add Car</a></li>
					<li><a href="#">Add Type</a></li>
					<li><a href="#">Add Providers</a></li>
					<li><a href="/carRentals/admin/userList">List User</a></li>
					<li><a href="/carRentals/admin/addNewInsurance">Add Insurance</a></li>
					<li><a href="/carRentals/admin/addUser">Add User</a></li>

					<li><a
						class="btn btn-default btn-outline btn-circle collapsed"
						data-toggle="collapse" href="#nav-collapse3" aria-expanded="false"
						aria-controls="nav-collapse3">Search</a></li>
				</ul>

				<div class="collapse nav navbar-nav nav-collapse slide-down"
					id="nav-collapse3">
					<form class="navbar-form navbar-right" role="search">
						<div class="form-group">
							<input type="text" class="form-control" placeholder="Search" />
						</div>
						<button type="submit" class="btn btn-danger">
							<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
						</button>
					</form>
				</div>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container --> </nav>
		<!-- /.navbar -->
		<h1>Welcome ${luser.firstName} !!!</h1>

	</div>
	<!-- /.container-fluid -->
	<div class="[ container ]">
		<div class="[ row ]">
			<div class="panel panel-default">
				<div class="panel-body">
					<c:forEach items="${carList}" var="car">
						<div class="thumbnail col-md-4">
							<img
								src="<c:url value="/resources/images/${car.name}.png"></c:url>"
								alt="image" style="width:100%" />
						</div>
						<div class="caption col-md-8">
							<h3>Car name: ${car.name}</h3>
							<p>manufactured year:${car.year}</p>
							<p>Charge per day: $${car.pricePerDay}</p>
							<p>Number of Miles:${car.numberOfMiles}miles</p>
							<p>Availibility: ${car.available}</p>
							<p>
								<a href="<spring:url value='/editCar' />"><span
									class="glyphicon-info-sign glyphicon">Modify</span></a>
							</p>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>


</body>
</html>