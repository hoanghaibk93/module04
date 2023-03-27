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
</head>
<body>
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
    <button type="submit" class="btn btn-primary">submit</button>
</form>
<h3>result: ${result} vnd </h3>

</div>
</body>
</html>
