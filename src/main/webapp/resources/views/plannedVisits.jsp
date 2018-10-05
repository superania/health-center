<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ania
  Date: 07.09.2018
  Time: 02:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Planned visits</title>
    <link href="${pageContext.servletContext.contextPath}/resources/css/app.css" rel="stylesheet">

</head>
<body>
<jsp:include page="menu.jsp"/>
<br>
<c:if test="${visits.size() == 0}">
    No planned visits<br>
</c:if>
<c:if test="${visits.size() > 0}">
    <b>Planned visits</b><br><br>
    <table>
        <thead>
        <tr>
            <td>Date</td>
            <td>Time</td>
            <td>Doctor</td>
            <td>Delete</td>
        </tr>
        </thead>

        <c:forEach items="${visits}" var="visit">
            <tr>
                <td>${visit.date}</td>
                <td>${visit.timeFrom} - ${visit.timeTo}</td>
                <td>${visit.doctor.surname} ${visit.doctor.name}</td>
                <td><a href="${pageContext.servletContext.contextPath}/deleteVisit/${visit.id}">
                    <button>Delete</button>
                </a></td>
            </tr>

        </c:forEach>
    </table>
</c:if>
<br>
<a href="${pageContext.servletContext.contextPath}/main">
    <button>Back</button>
</a>
</body>
</html>
