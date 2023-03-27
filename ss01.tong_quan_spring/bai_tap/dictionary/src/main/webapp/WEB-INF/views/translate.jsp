<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 27/3/2023
  Time: 4:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Dictionary</h1>
<form class="form-inline" method="post" action="/translate/result">
  <div class="form-group">
    <label for="1">English</label>
    <input type="text" name="english" id="1" class="form-control" value="${english}" aria-describedby="helpId">
  </div>
  <button type="submit" class="btn btn-primary">submit</button>
</form>
<h3>result: ${result} </h3>
</body>
</html>
