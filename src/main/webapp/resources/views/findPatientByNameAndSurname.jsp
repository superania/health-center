<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: ania
  Date: 03.08.2018
  Time: 07:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Find patient by name and surname</title>
    <link href="${pageContext.servletContext.contextPath}/resources/css/app.css" rel="stylesheet">

</head>
<body>
<jsp:include page="menu.jsp"/>
<form:form action="findPatientByNameAndSurname" modelAttribute="findPatient" method="post">
    Enter name:<br>
    <form:input path="name"/><br>
    <form:errors path="name" cssStyle="color: red"/><br>
    Enter surname:<br>
    <form:input path="surname"/><br>
    <form:errors path="surname" cssStyle="color: red"/><br>
    <input type="submit" value="Find">
</form:form>

</body>
</html>
