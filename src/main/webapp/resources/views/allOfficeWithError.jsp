<%@ page import="healthCenter.service.VisitService" %>
<%@ page import="java.util.List" %>
<%@ page import="healthCenter.entity.Office" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ania
  Date: 25.08.2018
  Time: 01:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All offices</title>
    <link href="${pageContext.servletContext.contextPath}/resources/css/app.css" rel="stylesheet">

</head>
<body>
<jsp:include page="menu.jsp"/>
<br><br>
<b>OFFICES:</b><br><br>

<c:forEach items="${offices}" var="office">
    ${office.number} ${office.name}
    <a href="/deleteOffice/${office.id}"><button>Delete</button></a><br><br>
    <c:if test="${id == office.id}">
        <span style="color: red">
            Office number ${office.number} can not be deleted because there are visits
            planned in it
        </span><br>
    </c:if>
</c:forEach>

    </body>
    </html>
