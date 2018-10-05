<%--
  Created by IntelliJ IDEA.
  User: ania
  Date: 29.07.2018
  Time: 20:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <title>Home page</title>
    <link href="${pageContext.servletContext.contextPath}/resources/css/app.css" rel="stylesheet">

</head>
<body>
<jsp:include page="menu.jsp"/>

<sec:authorize access="isAuthenticated()">
    <h1>You are log in</h1>
</sec:authorize>
</body>
</html>
