<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 29/3/2023
  Time: 9:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Form update</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<h1>Settings</h1>
<form:form modelAttribute="email" method="post" action="/email">
    <table class="table table-striped table-inverse table-responsive">
        <tbody>
        <tr>
            <td>Languages</td>
            <td>
                <form:select path="languages">
                    <form:options items="${languages}"></form:options>
                </form:select>
            </td>
        </tr>
        <tr>
            <td>Page Size:</td>
            <td>
                <span>Show</span>
                <form:select path="pageSize">
                    <form:options items="${pageSize}"></form:options>
                </form:select>
                <span>Emails per page</span>
            </td>
        </tr>
        <tr>
            <td>Spams filter</td>
            <td>
                <form:checkbox path="spamsFilter"></form:checkbox>
                <span>Enable spams filter</span>
            </td>
        </tr>
        <tr>
            <td>Signature</td>
            <td><form:textarea path="signature"></form:textarea></td>
        </tr>
        </tbody>
    </table>
    <button type="submit" class="btn btn-primary">update</button>
    <button type="reset" class="btn btn-primary">cancel</button>
</form:form>
</body>
</html>
