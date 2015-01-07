<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>Main Page</title>
  </head>
  <body>
  <%@include file="header.jsp"%>
    <h1>Main Page</h1>
    <h3>Links</h3>
    <ul>
      <li><a href="${pageContext.request.contextPath}/home">Test</a></li>
      <li><a href="${pageContext.request.contextPath}/users">Users</a></li>
    </ul>
  </body>
</html>
