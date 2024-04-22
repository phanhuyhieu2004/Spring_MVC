<%--
  Created by IntelliJ IDEA.
  User: hieuh
  Date: 12/22/2023
  Time: 11:11 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
  <title>Từ điển đơn giản</title>

</head>
<body>
<h2>Từ điển VN </h2>
<form action="translate"method="post">
  <input type="text" name="key"  placeholder="Enter your word: "/>
  <input type = "submit" id = "submit" value = "Search"/>
  <br>

</form>
<c:if test="${not empty result}">
      <p> ${result}</p>

  </c:if>
</body>
</html>


