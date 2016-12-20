<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Please select your insurance?</h2>	
	<div class="[ container ]">
		<div class="[ row ]">
			<div class="panel panel-default">
				<div class="panel-body">
					<c:forEach items="${insuranceList}" var="insurance">
						<div class="thumbnail col-md-4">
							<img
								src="<c:url value="../resource/images/insurance.png"></c:url>"
								alt="image" style="width:100%" />
						</div>
						<div class="caption col-md-8">
							<h3>Insurance name: ${insurance.name}</h3>
							<p>manufactured year:${insurance.coveredType}</p>
							<p>Charge per day: $${insurance.costPerDay}</p>
							<p>	<a href="<spring:url value='/user/billWithInsurance/${insurance.id}' />"><span
									class="glyphicon-info-sign glyphicon">Continue</span></a>
							</p>
						</div>
					</c:forEach>
				</div>
				 <a href="/searchCarFormPost"><button class="btn btn-default btn-xs">Back</button></a>
			</div>
		</div>
	</div>



</body>
</html>