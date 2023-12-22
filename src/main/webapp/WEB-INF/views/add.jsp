<%--
  Created by IntelliJ IDEA.
  User: hieuh
  Date: 12/18/2023
  Time: 8:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
  <title>Add</title>
</head>
<style>



  .containers {
    width: 600px;

    margin-top: auto;
    margin-bottom:10px;
    margin-left: 360px;      padding: 25px;
    background-color: #fff;
    border-radius: 10px;
  }


  select{
    margin-bottom: 0px;
    margin-left: 0px;
    margin-right: 0px;
    margin-top: 0px;
  }
  .form-group label {
    display: block;
    margin-bottom: 10px;

    font-weight: 700;
    font-size: 20px;
  }

  label.required span {
    color: red;
  }
  p span.required {
    color: red;
  }
  input[type="submit"] {
    width: 50%;
    padding: 15px;
    background-color: deeppink;
    color: #fff;
    border: none;
    border-radius: 10px;
    cursor: pointer;
    font-size: 18px;
    outline: none;
    transition: background-color 0.3s ease-in-out;
  }


  .form-row {
    display: flex;
  }

  .form-group {
    flex: 1;
    margin-right: 10px;
  }

  .form-group:last-child {
    margin-right: 0;
  }

  h2 {
    text-align: center;
  }
  .form-group {
    margin-bottom: 20px;
  }
  label {
    display: block;
    margin-bottom: 5px;
    font-weight: bold;
    font-size: 20px;
  }
  .form-group input[type="text"],
  .form-group input[type="date"],
  .form-group select {
    width: 100%;
    height: 40px;
    padding: 5px;
    border-radius: 10px;
    border:  solid pink;
    box-sizing: border-box;
    font-size: 18px;
    outline: none;
    transition: border-color 0.3s ease-in-out;
  }

  .form-group input[type="text"]:focus,
  .form-group input[type="date"]:focus,
  .form-group select:focus {
    border-color: pink;
  }

  .form-group input[type="text"]:-webkit-autofill,
  .form-group input[type="date"]:-webkit-autofill,
  .form-group select:-webkit-autofill {
    box-shadow: 0 0 0 30px pink inset !important;
    -webkit-box-shadow: 0 0 0 30px pink inset !important;
  }


  input[type="submit"]:hover {
    background-color: mediumvioletred;
  }



  .form-group input[type="file"],
  .form-group textarea {
    width: 100%;
    height: 80px;

    padding: 15px;

    border:  solid pink;
    box-sizing: border-box;
    font-size: 18px;
    outline: none;
    resize: vertical;
  }
  .form-group input[type="file"] {
    display: none;
  }




  .row {
    display: flex;
    justify-content: space-between;
  }

  @media (max-width: 768px) {
    .container {
      max-width: 90%;
    }

  }

</style>


<body>
<div class="containers">

  <h2>Information</h2>
  <div id="successMessage" class=" alert-success" style="display: none;">

    <div>
      <p style="text-align: center">Update successful!</p>
    </div>
  </div>

    <div class="form-group">
      <label>ID</label>
      <input value="${customer.id}" name="idStudent" type="text" class="form-control" readonly required>
    </div>
    <div class="form-group"style="margin-right:0px">
      <label for="name" class="required"> Name:</label>
      <input type="text"  value="${customer.name}" id="name" name="name" placeholder="Enter name" required>
    </div>
    <div class="form-group">
      <label for="email"class="required">Email address:</label>

      <input type="text" value="${customer.email}"id="email" name="email" placeholder="Enter email" required>
    </div>

    <div class="form-group">
      <label for="dob" class="required">Address:</label>
      <input type="text"value="${customer.address}" id="dob" name="dateOfBirth" required>
    </div>

<a href="http://localhost:8080/list">Back</a>

</div>
</body>
</html>
