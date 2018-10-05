<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ania
  Date: 05.09.2018
  Time: 01:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Schedule</title>
    <link href="${pageContext.servletContext.contextPath}/resources/css/app.css" rel="stylesheet">

</head>
<body>
<jsp:include page="menu.jsp"/>
<br>
<b>Schedule:</b><br>
<table>
    <thead>
    <tr>
    <td>Date</td>
    <td>Time from</td>
    <td>Time to</td>
    <td>Office</td>
    </tr>
    </thead>
    <c:forEach items="${schedule}" var="sc">
    <tr>
        <td>${sc.date}</td>
        <td>${sc.timeFrom}</td>
        <td>${sc.timeTo}</td>
        <td>${sc.office.number}</td>
    </tr>
    </c:forEach>
</table>
<br>
<a href="${pageContext.servletContext.contextPath}/schedule"><button>Back</button></a>
</body>
</html>
