<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ania
  Date: 30.07.2018
  Time: 03:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Specializations</title>
    <link href="${pageContext.servletContext.contextPath}/resources/css/app.css" rel="stylesheet">

</head>
<body>
<jsp:include page="menu.jsp"/>
<b>Specializations:</b><br>
<c:if test="${specializations.size() == 0}">
    There is no specialization.
</c:if>
<c:forEach items="${specializations}" var="spec">
    ${spec.name}<br>
</c:forEach>
<br>
<a href="${pageContext.servletContext.contextPath}/addSpecialization"><button>Add new</button></a><br>
<a href="${pageContext.servletContext.contextPath}/findSpecialization"><button>Find</button></a>
</body>
</html>
