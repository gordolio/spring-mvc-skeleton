<%--
  Created by IntelliJ IDEA.
  User: gchild
  Date: 1/6/2015
  Time: 5:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title></title>
</head>
<body>
<c:if test="${ pageContext.request.userPrincipal.name!= null}">
  <form action="<c:url value='/j_spring_security_logout'/>" method="POST" id="logoutForm">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
  </form>
  <script type="text/javascript">
    function formSubmit() {
      document.getElementById("logoutForm").submit();
    }
  </script>
  <h3>Welcome ${pageContext.request.userPrincipal.name}<span style="width:10px;">&nbsp;</span>
    <a href="javascript:formSubmit()">Logout</a>
  </h3>
</c:if>
</body>
</html>
