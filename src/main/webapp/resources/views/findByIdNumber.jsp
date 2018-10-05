<%--
  Created by IntelliJ IDEA.
  User: ania
  Date: 03.08.2018
  Time: 07:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Find by id number</title>
    <link href="${pageContext.servletContext.contextPath}/resources/css/app.css" rel="stylesheet">

</head>
<body>
<jsp:include page="menu.jsp"/>
<form:form action="findPatientByIdNumber" modelAttribute="idNumber" method="post">
    Enter id number:<br>
    <form:input path="idNumber"/><br>
    <form:errors path="idNumber" cssStyle="color: red"/><br>
    <input type="submit" value="Find">
</form:form>
</body>
</html>
