<%--
  Created by IntelliJ IDEA.
  User: alina
  Date: 22.01.2023
  Time: 12:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>${messageToPrint}</div>
<div>
    <form action="/hello" method="post">
        <input type="text" name="userName"/>
        <input type="submit" value="Submit">
    </form>
</div>
<div>
    <form action="/hello/polite" method="get">
        <input type="submit" value="PoliteMessage">
    </form>
</div>
</body>
</html>
