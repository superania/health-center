<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ania
  Date: 03.08.2018
  Time: 07:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Patients</title>
    <link href="${pageContext.servletContext.contextPath}/resources/css/app.css" rel="stylesheet">

</head>
<body>
<jsp:include page="menu.jsp"/>
<c:if test="${patients.size() == 0}">
    There is no result<br>
    <br>
    <c:if test="${type.equals('byId')}"><a href="${pageContext.servletContext.contextPath}/findPatientByIdNumber"><button>Try again</button></a>
    </c:if>
    <c:if test="${type.equals('byName')}"><a href="${pageContext.servletContext.contextPath}/findPatientByNameAndSurname"><button>Try again</button></a>
    </c:if>
</c:if>
<c:forEach items="${patients}" var="patient">
    ${patient.surname} ${patient.name} ${patient.dateOfBirth} ${patient.idNumber}
    <a href="${pageContext.servletContext.contextPath}/showPatientDetails/${patient.id}/${type}"><button>Details</button></a> <br>
</c:forEach>
</body>
</html>
