<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<li><a href="<spring:url value="/"/>"  class="btn btn-danger">Home</a></li>
<li><security:authorize access="isAnonymous()"><a href="<spring:url value="/login"/>"   class="btn btn-danger">Login</a></security:authorize></li>
<li><security:authorize access="isAnonymous()"><a href="<spring:url value="/user/signUp"/>"   class="btn btn-danger">SignUp</a></security:authorize></li>
<li><a href="<spring:url value="/user/searchCarFormPost"/>" class="btn btn-danger">Set Trip</a></li>
<li><security:authorize  access="hasRole('ROLE_ADMIN')"><a href="<spring:url value="/admin/home"/>" class="btn btn-danger">Admin</a></security:authorize></li>
<li><security:authorize access="isAuthenticated()">	<a href="<spring:url  value="/doLogout" />" class="btn btn-danger">Logout</a>	
</security:authorize></li>