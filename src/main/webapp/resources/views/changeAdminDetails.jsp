<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: ania
  Date: 30.07.2018
  Time: 22:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Change admin details</title>
    <link href="${pageContext.servletContext.contextPath}/resources/css/app.css" rel="stylesheet">

</head>
<body>
<jsp:include page="menu.jsp"/>
<form:form action="changeAdminDetails" modelAttribute="adminDto" method="post">
    Name:<br>
    <form:input path="name" value="${admin.name}"/><br>
    <form:errors path="name" cssStyle="color: red"/><br>
    Surname:<br>
    <form:input path="surname" value="${admin.surname}"/><br>
    <form:errors path="surname" cssStyle="color: red"/><br>
    Id number:<br>
    <form:input path="idNumber" value="${admin.idNumber}"/><br>
    <form:errors path="idNumber" cssStyle="color: red"/><br>
    Date of birth:<br>
    <form:input path="dateOfBirth" value="${admin.dateOfBirth}" type = "date"/><br>
    <form:errors path="dateOfBirth" cssStyle="color: red"/><br>
    Country:<br>
    <form:input path="country" value="${admin.address.country}"/><br>
    <form:errors path="country" cssStyle="color: red"/><br>
    City:<br>
    <form:input path="city" value="${admin.address.city}"/><br>
    <form:errors path="city" cssStyle="color: red"/><br>
    Street:<br>
    <form:input path="street" value="${admin.address.street}"/><br>
    <form:errors path="street" cssStyle="color: red"/><br>
    <form:input path="login" type = "hidden" value = "${admin.login}"/>
    <form:input path="password" type="hidden" value="${admin.password}"/>
    <input type="submit" value="Change">
</form:form>
</body>
</html>
