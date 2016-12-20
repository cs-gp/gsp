<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <link href="http://getbootstrap.com/dist/css/bootstrap.css"	rel="stylesheet">
<link href="http://getbootstrap.com/examples/jumbotron/jumbotron.css"	rel="stylesheet"/>
<title>Insert title here</title>
</head>
<body align="center">  
<h1>${message}</h1>


<a href="#"><input type="button" value="My Profile"></a>
 <div class="table-responsive">
        <table class="table table-bordered" align="center">
	
  <thead>
    <tr>
      <th>Name</th>
      <th>Last Name</th>
      <th>Email</th>
      <th>Edit</th>
      <th> Delete</th>
    </tr>
  </thead>

    <tbody>  
	<c:forEach items="${userList}" var="user">
	
	
	  <tr align="left">
      <td>${user.firstName}</td>
      <td>${user.lastName}</td>
      <td>${user.email}</td> 
      
      <td><a href="edit/${user.id}">
      <button class="btn btn-primary btn-xs" action="/edit" ><span class="glyphicon glyphicon-pencil"></span></button></a></td>
    <td>
    <a href="delete/${user.id}"><button class="btn btn-danger btn-xs" action="/delete" ><span class="glyphicon glyphicon-trash"></span></button></a></td>
   </tr>
	</c:forEach>
	</tbody>
</table>
</div>
<a href="addUser"><input type="button" value="Add User"></a>
</body>
</html>