<%--
  Created by IntelliJ IDEA.
  User: ania
  Date: 07.09.2018
  Time: 01:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Visit details</title>
    <link href="${pageContext.servletContext.contextPath}/resources/css/app.css" rel="stylesheet">

</head>
<body>
<jsp:include page="menu.jsp"/>
<br>
<b>Date:</b> ${visit.date}<br>
<b>Time:</b> ${visit.timeFrom} - ${visit.timeTo}<br>
<b>Doctor:</b> ${visit.doctor.surname} ${visit.doctor.name}<br>
<b>Annotations:</b> ${visit.doctorAnnotation}<br><br>
<a href="${pageContext.servletContext.contextPath}/showVisitHistory"><button>Back</button></a>
</body>
</html>
