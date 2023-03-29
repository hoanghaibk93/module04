<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 29/3/2023
  Time: 11:38 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Information after update</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<h1>Information after update</h1>
<table class="table table-striped table-inverse table-responsive">
    <tbody>
    <tr>
        <td>Languages</td>
        <td>${languages}</td>
    </tr>
    <tr>
        <td>Page Size:</td>
        <td>${pageSize}</td>
    </tr>
    <tr>
        <td>Spams filter</td>
        <td>${spamsFilter}</td>
    </tr>
    <tr>
        <td>Signature</td>
        <td>${signature}</td>
    </tr>
    </tbody>
</table>
</body>
</html>
