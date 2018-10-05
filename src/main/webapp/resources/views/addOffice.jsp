<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: ania
  Date: 25.08.2018
  Time: 01:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new office</title>
    <link href="${pageContext.servletContext.contextPath}/resources/css/app.css" rel="stylesheet">

</head>
<body>
<jsp:include page="menu.jsp"/><br>
<form:form action="addNewOffice" modelAttribute="office" method="post">
    Number:<br>
    <form:input path="number"/><br>
    <form:errors path="name" cssStyle="color: red"/><br>
    Office's name:<br>
    <form:input path="name"/><br>
    <form:errors cssStyle="color: red"/><br>
    <input type="submit" value="Add">
</form:form>
<br>
<a href="${pageContext.servletContext.contextPath}/officeOption"><button>Back</button></a>

</body>
</html>
