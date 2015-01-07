<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Users</title>
</head>
<body>
<%@include file="header.jsp"%>
<h1>Under Construction!!!</h1>
<table>
  <c:forEach var="user" items="${users}">
    <tr><td>${user.id }</td><td>${user.username }</td></tr>
  </c:forEach>
</table>
</body>
</html>
