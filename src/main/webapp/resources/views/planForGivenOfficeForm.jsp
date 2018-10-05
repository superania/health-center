<%@ page import="java.util.List" %>
<%@ page import="healthCenter.entity.Office" %>
<%@ page import="healthCenter.entity.Specialization" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: ania
  Date: 06.09.2018
  Time: 19:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Office plan</title>
    <link href="${pageContext.servletContext.contextPath}/resources/css/app.css" rel="stylesheet">

</head>
<body>
<jsp:include page="menu.jsp"/>
<br>
<form:form action="" method="post" modelAttribute="form">
    Enter date:<br>
    <form:input path="date" type="date"/><br>
    <form:errors cssStyle="color: red"/><br>
    Enter office number:<br>
    <%List<Office> offices = (List<Office>) request.getAttribute("offices");%>
    <form:select path="officeId">
        <% for (Office office : offices) { %>
        <form:option value="<%=office.getId()%>">
                <%=office.getNumber()%>
        </form:option>
        <%}%>
    </form:select>
    <br><br>
    <input type="submit" value="Show">
</form:form>
<br>
<a href="${pageContext.servletContext.contextPath}/officeOption"><button>Back</button></a>
</body>
</html>
