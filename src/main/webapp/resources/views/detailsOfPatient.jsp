<%--
  Created by IntelliJ IDEA.
  User: ania
  Date: 06.09.2018
  Time: 21:14
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
<br>
<b>${patient.surname} ${patient.name}</b><br>
<b>Id number:</b> ${patient.idNumber}<br>
<b>Date of birth:</b> ${patient.dateOfBirth}<br>
<b>Address:</b> ${patient.address.country} ${patient.address.city} ${patient.address.street}<br>
<br>
<a href="${pageContext.servletContext.contextPath}/main"><button>Back</button></a>
</body>
</html>
