<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Chuyển đổi tiền tệ</title>
</head>
<body>
<h2>Chuyển đổi tiền tệ</h2>
<%--<form action="load" method="post">--%>
<%--    <label>Tỷ lệ: </label><br/>--%>
<%--    <input type="number" name="rate" placeholder="RATE" /><br/>--%>
<%--    <label>USD: </label><br/>--%>
<%--    <input type="number" name="usd" placeholder="USD"/><br/>--%>
<%--    <input type="submit" id="submit" value="Chuyển đổi" />--%>
<%--</form>--%>



















<form action="/converter" method="post">
    <div class="rate" style="display: flex">
    <label for="rate">Tỉ lệ:</label>
    <input type="number" id="rate" name="rate" placeholder="Nhập vào đây rate">
    </div>
    <br>
    <div class="usd" style="display: flex">
    <label for="usd">USD:</label>
    <input type="number" id="usd" name="usd" placeholder="Nhập vào đây usd">
    </div>
    <input type="submit" value="Chuyển đổi">
</form>
<c:if test="${not empty result}">
    Số tiền là : <span>${result}</span>
</c:if>
<jsp:include page="hello.jsp"></jsp:include>
</body>
</html>