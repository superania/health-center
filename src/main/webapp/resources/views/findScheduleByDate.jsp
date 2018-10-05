<%--
  Created by IntelliJ IDEA.
  User: ania
  Date: 05.09.2018
  Time: 01:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Schedule</title>
    <link href="${pageContext.servletContext.contextPath}/resources/css/app.css" rel="stylesheet">

</head>
<body>
<jsp:include page="menu.jsp"/>
<br>
<form:form action="" modelAttribute="date" method="post">
    Enter date:<br>
    <form:input path="date" type="date"/><br>
    <form:errors path="date" cssStyle="color: red"/><br>
    <input type="submit" value="Find">
</form:form>
<a href="${pageContext.servletContext.contextPath}/schedule"><button>Back</button></a>
</body>
</html>
