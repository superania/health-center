<%--
  Created by IntelliJ IDEA.
  User: ania
  Date: 30.07.2018
  Time: 03:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Add specialization</title>
    <link href="${pageContext.servletContext.contextPath}/resources/css/app.css" rel="stylesheet">

</head>
<body>
<jsp:include page="menu.jsp"/>
<form:form action="addSpecialization" modelAttribute="specialization" method="post">
    <br>
    Enter name of specialization:<br>
    <form:input path="name"/><br>
    <form:errors path="name" cssStyle="color: red"/><br>
    <input type="submit" value="Add">
</form:form>

</body>
</html>
