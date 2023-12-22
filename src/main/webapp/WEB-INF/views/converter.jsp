<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Chuyển đổi tiền tệ</title>
</head>
<body>
<h2>Chuyển đổi tiền tệ</h2>
<form action="load" method="post">
    <label>Tỷ lệ: </label><br/>
    <input type="number" name="rate" placeholder="RATE" /><br/>
    <label>USD: </label><br/>
    <input type="number" name="usd" placeholder="USD"/><br/>
    <input type="submit" id="submit" value="Chuyển đổi" />
</form>

<c:if test="${not empty result}">
    Số tiền là : <span>${result}</span>
</c:if>
</body>
</html>