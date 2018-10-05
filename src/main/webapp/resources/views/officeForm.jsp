<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: ania
  Date: 07.08.2018
  Time: 00:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Available offices</title>
    <link href="${pageContext.servletContext.contextPath}/resources/css/app.css" rel="stylesheet">

</head>
<body>
<jsp:include page="menu.jsp"/><br>
<form:form action="showOfficesPlan" modelAttribute="date" method="post">
    Enter date:<br>
    <form:input path="date" type="date"/><br>
    <form:errors path="date" cssStyle="color: red"/><br>
    <input type="submit" value="Show">
</form:form>
<a href="${pageContext.servletContext.contextPath}/officeOption"><button>Back</button></a>
</body>
</html>
