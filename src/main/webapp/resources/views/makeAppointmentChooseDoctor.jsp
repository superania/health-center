<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ania
  Date: 07.09.2018
  Time: 03:12
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
<form:form modelAttribute="appointmentForm" method="post">
<form:select path="doctorId">
    Choose doctor <br>
    <c:forEach items="${doctors}" var="doctor">
     <form:option value="${doctor.id}">
         ${doctor.surname} ${doctor.name} <br>
     </form:option>
    </c:forEach>
</form:select>
    <br>
    <input type="submit" value="Choose">
</form:form>
<br><br>
<a href="${pageContext.servletContext.contextPath}/main"><button>Back</button></a>
</body>
</html>
