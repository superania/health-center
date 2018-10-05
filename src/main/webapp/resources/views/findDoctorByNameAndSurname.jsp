<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: ania
  Date: 03.08.2018
  Time: 02:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Find doctor by name and surname</title>
    <link href="${pageContext.servletContext.contextPath}/resources/css/app.css" rel="stylesheet">

</head>
<body>
<jsp:include page="menu.jsp"/>
<br>
<form:form action="findDoctorByNameAndSurname" modelAttribute="doctor" method="post">
    <br>
    Enter name:<br>
    <form:input path="name"/><br>
    <form:errors path="name" cssStyle="color: red"/><br>
    Enter surname:<br>
    <form:input path="surname"/><br>
    <form:errors path="surname" cssStyle="color: red"/><br>
    <input type="submit" value="Find">

</form:form>
<a href="${pageContext.servletContext.contextPath}/doctorOptions"><button>Back</button></a>
</body>
</html>
