<%--
  Created by IntelliJ IDEA.
  User: hieuh
  Date: 12/18/2023
  Time: 3:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>List</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>

<body>
<content>

        <div class="container mt-4" >
            <table class="table table-bordered table-striped">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Address</th>
                    <th>Actions</th>
                </tr>
                </thead>
                <tbody>
                <%-- Thêm kiểm tra nếu danh sách người dùng không rỗng thì hiển thị dữ liệu --%>

                <c:forEach var="list" items="${listCustomer}" varStatus="loop">
                    <tr>
                        <td>${loop.index + 1}</td>

                        <td>${list.name}</td>
                        <td>${list.email}</td>

                        <td>${list.address}</td>



                        <td >
                            <button ><a href="add/${list.id}" class="btn btn-primary" >Information</a></button>

                        </td>
                    </tr>
                </c:forEach>

                </tbody>
            </table>

        </div>
</content>
</body>
</html>
