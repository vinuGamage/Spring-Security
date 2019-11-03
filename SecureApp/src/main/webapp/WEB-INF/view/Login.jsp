<%--
  Created by IntelliJ IDEA.
  User: vinu_g
  Date: 11/1/2019
  Time: 10:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
    <div class="container">
        <h2 class="display-2">User Login</h2>
        <br>

        <form:form action="${pageContext.request.contextPath}/authenticateUser" method="post">

            <c:if test="${param.error != null}">
                <i class="alert alert-danger ">Invalid credentials</i>
            </c:if>
            <br><br>
            <div class="form-group">
                <label>Username : </label>
                <input  class="form-control" type="text" name="username" placeholder="Username"/>
            </div>

            <div class="form-group">
                <label>Password: </label>
                <input  class="form-control" type="password" name="password" placeholder="Password"/>
            </div>

            <div class="form-group">
                <button type="submit" class="btn btn-warning btn-lg btn-block">Login</button>
            </div>
        </form:form>

    </div>
</body>
</html>
