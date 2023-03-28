<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 28/3/2023
  Time: 10:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<h1>Sandwich Condiments</h1>
<form method="post" action="/display/result">
<div class="btn-group" data-toggle="buttons">
    <label class="btn btn-primary active"> Lettuce
        <input type="checkbox" name="menu" value="Lettuce" checked autocomplete="off">
    </label>
    <label class="btn btn-primary"> Tomato
        <input type="checkbox" name="menu" value="Tomato" autocomplete="off">
    </label>
    <label class="btn btn-primary"> Mustard
        <input type="checkbox" name="menu" value="Mustard" autocomplete="off">
    </label>
    <label class="btn btn-primary"> Sprouts
        <input type="checkbox" name="menu" value="Sprouts" autocomplete="off">
    </label>
</div> <br>
    <input name="" id="" class="btn btn-danger" type="submit" value="submit">
</form>
<h2>Result:</h2>
<c:forEach items="${menu}" var="menu">
    <span>${menu}</span>

</c:forEach>
</body>
</html>
