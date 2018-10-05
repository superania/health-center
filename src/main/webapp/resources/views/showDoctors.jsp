<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ania
  Date: 31.07.2018
  Time: 02:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Doctors</title>
    <link href="${pageContext.servletContext.contextPath}/resources/css/app.css" rel="stylesheet">

</head>
<body>
<jsp:include page="menu.jsp"/>
<br>
<b>DOCTORS</b><br><br>
<c:if test="${doctors.size() == 0}">
    There is no result<br>
</c:if>
<c:forEach items="${doctors}" var="doctor">
   <b> ${doctor.name} ${doctor.surname} </b><br>
    <c:if test="${doctor.specializations.size() > 0}">
        Specializations:<br>
        <c:forEach items="${doctor.specializations}" var="spec">
            ${spec.name}<br>
        </c:forEach>
    </c:if>
    <a href="${pageContext.servletContext.contextPath}/doctorDetails/${doctor.id}"><button>Show details</button></a><br>
    <a href="${pageContext.servletContext.contextPath}/deleteDoctor/${doctor.id}"><button>Delete</button></a><br>
    <br>
    <br>
</c:forEach>

<a href="${pageContext.servletContext.contextPath}/doctorOptions"><button>Back</button></a>
</body>
</html>
