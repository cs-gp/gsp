<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="http://getbootstrap.com/dist/css/bootstrap.css"	rel="stylesheet">
<link href="http://getbootstrap.com/examples/jumbotron/jumbotron.css"	rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
<h3><p> 
	${message}
	</h3>
<img src="<c:url value="/resource/images/bannerhome.png"></c:url>" alt="image"  style = "width:100%"/>
<h2>You are logged in as $(luser.firstName) $(luser.lastName) Enjoy!!</h2>

</body>
</html>