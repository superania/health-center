<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="healthCenter.entity.Visit" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: ania
  Date: 07.09.2018
  Time: 00:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Past visits</title>
    <link href="${pageContext.servletContext.contextPath}/resources/css/app.css" rel="stylesheet">

</head>
<body>
<jsp:include page="menu.jsp"/>
<br>
<c:forEach items="${visits}" var="visit">
    ${visit.date} ${visit.doctor.surname} ${visit.doctor.name}
    <a href="${pageContext.servletContext.contextPath}/visitDetails/${visit.id}"><button>Details</button></a><br><br>
</c:forEach>
<a href="${pageContext.servletContext.contextPath}/main"><button>Back</button></a>
</body>
</html>
