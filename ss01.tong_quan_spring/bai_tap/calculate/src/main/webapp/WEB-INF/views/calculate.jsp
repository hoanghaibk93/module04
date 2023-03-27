<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 27/3/2023
  Time: 1:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body class="container-sm border border-primary" style="height: 300px">
<h1>CONVERT USD TO VND</h1>
<form class="form-inline" method="post" action="/calculate/result">
    <div class="form-group">
        <label for="1">Exchange rate</label>
        <input type="text" name="rate" id="1" class="form-control" value="${rate}" aria-describedby="helpId">
    </div>
    <div class="form-group">
        <label for="2">USD</label>
        <input type="text" name="usd" id="2" class="form-control" value="${usd}" aria-describedby="helpId">
    </div>
    <button type="submit" class="btn btn-primary">Convert</button>
</form>
<h3>Result: ${result} vnd </h3>
</div>
</body>
</html>
