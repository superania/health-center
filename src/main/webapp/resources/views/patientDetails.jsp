<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ania
  Date: 03.08.2018
  Time: 08:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Patient details</title>
    <link href="${pageContext.servletContext.contextPath}/resources/css/app.css" rel="stylesheet">

</head>
<body>
<jsp:include page="menu.jsp"/>
<b>Name:</b><br>
${patient.name}<br>
<b>Surname:</b><br>
${patient.surname}<br>
<b>Id number:</b><br>
${patient.idNumber}<br>
<b>Date of birth:</b><br>
${patient.dateOfBirth}<br>
<b>Address:</b><br>
${patient.address.country} ${patient.address.city} ${patient.address.street}<br>
<a href="${pageContext.servletContext.contextPath}/showPatientVisits/${patient.id}/${type}"><button>Show visits</button></a><br>
<c:if test="${type.equals('byId')}">
    <a href="${pageContext.servletContext.contextPath}/findPatientByIdNumber/${patient.id}"><button>Back</button></a><br>
</c:if>
<c:if test="${type.equals('byName')}">
    <a href="${pageContext.servletContext.contextPath}/showPatient/${patient.name}/${patient.surname}/${type}"><button>Back</button></a><br>

</c:if>
</body>
</html>
