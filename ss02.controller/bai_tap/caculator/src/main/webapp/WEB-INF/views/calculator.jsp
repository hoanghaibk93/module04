<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 28/3/2023
  Time: 2:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body class="container-sm border border-primary" style="height: 300px; margin-top: 50px">
<h1 style="text-align: center">Calculator</h1>
<form method="post" action="/calculate">
    <div class="form-group">
        <label for="1"></label>
        <input type="text" name="numberOne" id="1" class="form-control" placeholder="" aria-describedby="helpId"
               value="${numberOne}">
    </div>
    <div class="form-group">
        <label for="2"></label>
        <input type="text" name="numberTwo" id="2" class="form-control" placeholder="" aria-describedby="helpId"
               value="${numberTwo}">
    </div>
    <button type="submit" class="btn btn-primary" name="calculation" value="Addition(+)">Addition(+)</button>
    <button type="submit" class="btn btn-primary" name="calculation" value="Subtraction(-)">Subtraction(-)</button>
    <button type="submit" class="btn btn-primary" name="calculation" value="Multiplication(x)">Multiplication(x)
    </button>
    <button type="submit" class="btn btn-primary" name="calculation" value="Division(/)">Division(/)</button>
</form>
<h1>Result: ${result} </h1>
</body>
</html>
