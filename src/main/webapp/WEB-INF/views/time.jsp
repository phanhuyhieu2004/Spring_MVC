<%--
  Created by IntelliJ IDEA.
  User: hieuh
  Date: 12/26/2023
  Time: 10:06 AM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>

<html xmlns:th="http://www.thymeleaf.org" lang="en">


<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h2>Current Local Times Around the World</h2>
<span>Current time in ${city}: <strong>${date}</strong></span>
<form id="locale" action="world-clock" method="get">
    <select name="city" onchange="document.getElementById('locale').submit()">
        <option value=""disabled selected hidden >Select a city</option>
        <option value="Asia/Ho_Chi_Minh">Ho Chi Minh</option>
        <option value="Singapore">Singapore</option>
        <option value="Asia/Hong_Kong">Hong Kong</option>
        <option value="Asia/Tokyo">Tokyo</option>
        <option value="Asia/Seoul">Seoul</option>
        <option value="Europe/London">London</option>
        <option value="Europe/Madrid">Madrid</option>
        <option value="America/New_York">New York</option>
        <option value="Australia/Sydney">Sydney</option>
        <option value="Argentina/Buenos_Aires">Buenos Aires</option>
    </select>
</form>
</body>
</html>


