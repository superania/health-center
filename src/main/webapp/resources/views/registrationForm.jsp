<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: ania
  Date: 29.07.2018
  Time: 22:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration form</title>
    <link href="${pageContext.servletContext.contextPath}/resources/css/app.css" rel="stylesheet">
</head>
<body>
<jsp:include page="menu.jsp"/>
</body>
<br>
<form:form action="register" modelAttribute="patient" method="post">
    Enter login:<br>
    <form:input path="login"/><br>
    <form:errors path="login" cssStyle="color: red"/><br>
    Enter password:<br>
    <form:input path="password" type="password"/><br>
    <form:errors path="password" cssStyle="color: red"/><br>
    Enter name:<br>
    <form:input path="name"/><br>
    <form:errors path="name" cssStyle="color: red"/><br>
    Enter surname:<br>
    <form:input path="surname"/><br>
    <form:errors path="surname" cssStyle="color: red"/><br>
    Enter id number:<br>
    <form:input path="idNumber"/><br>
    <form:errors path="idNumber" cssStyle="color: red"/><br>
    Enter date of birth:<br>
    <form:input path="dateOfBirth" type="date"/><br>
    <form:errors path="dateOfBirth" cssStyle="color: red"/><br>
    Enter country:<br>
    <form:input path="country"/><br>
    <form:errors path="country" cssStyle="color: red"/><br>
    Enter city:<br>
    <form:input path="city"/><br>
    <form:errors path="city" cssStyle="color: red"/><br>
    Enter street:<br>
    <form:input path="street"/><br>
    <form:errors path="street" cssStyle="color: red"/><br>
    <input type="submit" value="Create account">
</form:form>
</html>
