<%@ page import="java.util.List" %>
<%@ page import="healthCenter.entity.Schedule" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ania
  Date: 07.09.2018
  Time: 04:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Make appointment</title>
    <link href="${pageContext.servletContext.contextPath}/resources/css/app.css" rel="stylesheet">

</head>
<body>
<jsp:include page="menu.jsp"/>
<br>
<b>${doctor.surname} ${doctor.name}</b><br>
<c:if test="${doctorSchedule.size() == 0}">
    No available dates
</c:if>
<c:if test="${doctorSchedule.size() > 0}">
    <c:forEach items="${doctorSchedule}" var="schedule">
        <b>${schedule.date}</b> ${schedule.timeFrom} - ${schedule.timeTo}
        <a href="${pageContext.servletContext.contextPath}/addVisit/${schedule.id}"><button>Choose</button></a> <br>
    </c:forEach>
</c:if>



</body>
</html>
