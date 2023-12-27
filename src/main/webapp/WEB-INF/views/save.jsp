<%--
  Created by IntelliJ IDEA.
  User: hieuh
  Date: 12/26/2023
  Time: 10:36 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
  <title>Title</title>
</head>
<body>
<c:forEach items="${condiment}" var="eat">
  <h1>${eat}</h1>
</c:forEach>
</body>
</html>
