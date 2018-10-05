<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ania
  Date: 03.08.2018
  Time: 05:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Doctor details</title>
    <link href="${pageContext.servletContext.contextPath}/resources/css/app.css" rel="stylesheet">

</head>
<body>
<jsp:include page="menu.jsp"/>
<br>
<b>Name:</b>
${doctor.name}<br>
<b>Surname:</b>
${doctor.surname}<br>
<b>Id number:</b>
${doctor.idNumber}<br>
<b>Date of birth:</b>
${doctor.dateOfBirth}<br>
<b>Address:</b>
${doctor.address.country} ${doctor.address.city} ${doctor.address.street}<br>
<b>Specializations:</b><br>
<c:forEach items="${doctor.specializations}" var="spec">
    ${spec.name}<br>
</c:forEach>
<a href="${pageContext.servletContext.contextPath}/changeDetailsDoctor"><button>Change</button></a>

</body>
</html>
