<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ania
  Date: 06.09.2018
  Time: 20:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Schedule for office</title>
    <link href="${pageContext.servletContext.contextPath}/resources/css/app.css" rel="stylesheet">

</head>
<body>
<jsp:include page="menu.jsp"/>
<br>
<b>${form.date} office number ${officeNumber}</b><br>
<c:if test="${visits.size() == 0}">
    There are no visits that day
</c:if>
<c:forEach items="${visits}" var="visit">
    ${visit.timeFrom} ${visit.timeTo} ${visit.doctor.surname} ${visit.doctor.name}<br>
</c:forEach>
<br>
<a href="${pageContext.servletContext.contextPath}/officeOption"><button>Back</button></a>
</body>
</html>
