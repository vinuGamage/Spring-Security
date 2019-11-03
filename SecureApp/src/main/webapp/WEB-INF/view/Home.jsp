<%--
  Created by IntelliJ IDEA.
  User: vinu_g
  Date: 11/1/2019
  Time: 8:45 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
    <h2>Home page</h2>
    <hr>
    <p>Welcome to the company home page!</p>

    <hr>
    <p>
        User:<security:authentication property="principal.username"/>
        <br/><br/>
        Role :<security:authentication property="principal.authorities"/>
    </p>
    <hr>

    <security:authorize access="hasRole('MANAGER')">
        <a href="${pageContext.request.contextPath}/leaders">Only For Managers</a>
    </security:authorize>


    <hr>
    <security:authorize access="hasRole('ADMIN')">
         <a href="${pageContext.request.contextPath}/systems">Only For Admins</a>
    </security:authorize>
    <br><br>
    <form:form action="${pageContext.request.contextPath}/logout" method="post">
        <input type="submit" value="logout"/>
    </form:form>
</body>
</html>
