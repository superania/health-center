<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ania
  Date: 03.08.2018
  Time: 08:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Patient visit</title>
    <link href="${pageContext.servletContext.contextPath}/resources/css/app.css" rel="stylesheet">

</head>
<body>
<jsp:include page="menu.jsp"/>
<br>
<b>PATIENT: ${patient.surname} ${patient.name}</b><br>
<br>
<table>
    <thead>
    <td>Date</td>
    <td>Doctor</td>
    <td>Annotations</td>
    </thead>

<c:forEach items="${visits}" var="visit">
    <tr><td>${visit.date} </td>
    <td>${visit.doctor.surname} ${visit.doctor.name}</td>
    <td>${visit.doctorAnnotation}</td>
    </tr>
</c:forEach>
</table>
<br>
<a href="${pageContext.servletContext.contextPath}/addVisit/${patient.id}/${type}"><button>Add new visit</button></a><br><br>
<a href="${pageContext.servletContext.contextPath}/showPatientDetails/${patient.id}/${type}"><button>Back</button></a><br>

</body>
</html>
