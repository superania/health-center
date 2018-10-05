<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ania
  Date: 25.08.2018
  Time: 00:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Offices</title>
    <link href="${pageContext.servletContext.contextPath}/resources/css/app.css" rel="stylesheet">

</head>
<body>
<jsp:include page="menu.jsp"/>
<b>Offices:</b><br>
<c:forEach items="${offices}" var="office">
    ${office.number} ${office.name} <a href="${pageContext.servletContext.contextPath}/deleteOffice/${office.id}" ><button>Delete</button></a><br>
    <br>
</c:forEach>
<a href="${pageContext.servletContext.contextPath}/officeOption"><button>Back</button></a>
</body>
</html>
