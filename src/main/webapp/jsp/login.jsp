<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
  <head>
    <title>Login</title>
  </head>
  <body>
    <c:if test="${msg != null}">
      <h4>${msg}</h4>
    </c:if>
    <c:if test="${error != null}">
      <h4 style="color:#ff0000;">${error}</h4>
    </c:if>
    <h3>Please Login with Username and Password</h3>
    <form action="<c:url value='/j_spring_security_check'/>" method="POST">
      <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
      <table>
        <tr>
          <td><label for="username">User:</label></td>
          <td><input id="username" type="text" name="j_username"/></td>
        </tr>
        <tr>
          <td><label for="password">Password:</label></td>
          <td><input id="password" type="password" name="j_password"/></td>
        </tr>
        <tr>
          <td colspan="2"><input type="submit" name="submit" value="Login"></td></tr>
      </table>
    </form>
  </body>
</html>