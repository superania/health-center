<%@ page import="java.time.LocalDate" %>
<%@ page import="java.time.LocalTime" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: ania
  Date: 03.08.2018
  Time: 13:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add visit</title>
    <link href="${pageContext.servletContext.contextPath}/resources/css/app.css" rel="stylesheet">

</head>
<body>
<jsp:include page="menu.jsp"/>
<form:form action="${type}" modelAttribute="visit" method="post">
    <form:input path="patientId" value="${patientId}" type="hidden"/><br>
    Enter date:<br>
    <form:input path="date" value="<%=LocalDate.now()%>" type="date"/><br>
    <form:errors path="date" cssStyle="color:red"/><br>
    Enter time from:<br>
    <form:select path="timeFrom"><br>
        <% LocalTime timeFrom = LocalTime.of(8, 0);
            while (timeFrom.isBefore(LocalTime.of(20, 0))) { %>
        <form:option value="<%=timeFrom%>">
            <%=timeFrom%>
        </form:option>
        <%
                timeFrom = timeFrom.plusMinutes(20);
            }
        %>
    </form:select>
    <br>
    Enter time to:<br>
    <form:select path="timeTo">
        <%
            LocalTime timeTo = LocalTime.of(8, 0);
            while (timeTo.isBefore(LocalTime.of(20, 0))) {
        %>
        <form:option value="<%=timeTo%>">
            <%=timeTo%>
        </form:option>
        <%
                timeTo = timeTo.plusMinutes(20);
            }
        %>
    </form:select>
    <br>
    Description:<br>
    <form:textarea path="doctorAnnotation" rows="10" cols="50"/><br>
    <form:errors path="doctorAnnotation" cssStyle="color: red"/><br>
    <input type="submit" value="Add">

</form:form>
</body>
</html>
