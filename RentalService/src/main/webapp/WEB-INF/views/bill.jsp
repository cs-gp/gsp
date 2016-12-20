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
 <h1>Receit</h1>
  <p>Resize the browser window to see the effect.</p>
   <div class="row">
    <div class="col-xs-9 col-md-4" style="background-color:white;">Car Name:</div>
    <div class="col-xs-3 col-md-8" style="background-color:grey;">${carwithinsurance.name}</div>
  </div>
  <div class="row">
    <div class="col-xs-9 col-md-4" style="background-color:white;">Car Year:</div>
    <div class="col-xs-3 col-md-8" style="background-color:lavender;">${carwithinsurance.year}</div>
  </div>
  <div class="row">
    <div class="col-xs-9 col-md-4" style="background-color:white;">Car Insurane</div>
    <div class="col-xs-3 col-md-8" style="background-color:lavender;">${carwithinsurance.insurance.name}</div>
  </div>
    <div class="row">
    <div class="col-xs-9 col-md-4" style="background-color:white;">Car rental period:</div>
    <div class="col-xs-3 col-md-8" style="background-color:lavender;">${numberofDays} Days</div>
  </div>
  </div>
    <div class="row">
    <div class="col-xs-9 col-md-4" style="background-color:white;">Total car cost:</div>
    <div class="col-xs-3 col-md-8" style="background-color:white;">$${cartotal}</div>
  </div>
  <div class="row">
    <div class="col-xs-9 col-md-4" style="background-color:white;">Total Insurance cost:</div>
    <div class="col-xs-3 col-md-8" style="background-color:lavender;">$${insurancetotal}</div>
    
  </div>
   <div class="row">
    <div class="col-xs-9 col-md-4" style="background-color:white;">Total cost:xxxxxxxxxxxxxxxxxxxxxxxxxxxx</div>
    <div class="col-xs-3 col-md-8" style="background-color:lavender;">$${total}</div>
    
  </div>
   <a href="/carRentals/user/searchCarFormPost"><button class="btn btn-default btn-xs">Select another Car</button></a>
   <a href="/carRentals/user/searchCarFormPost"><button class="btn btn-default btn-xs">Back</button></a>
   <a href="/google.com"><button class="btn btn-default btn-xs">Print Reciet and pay</button></a>
</div>
</body>
</html>