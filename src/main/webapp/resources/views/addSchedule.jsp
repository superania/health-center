<%@ page import="java.time.LocalTime" %>
<%@ page import="java.time.LocalDate" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: ania
  Date: 04.08.2018
  Time: 01:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add schedule</title>
    <link href="${pageContext.servletContext.contextPath}/resources/css/app.css" rel="stylesheet">

</head>
<body>
<jsp:include page="menu.jsp"/>
<br>
<form:form action="addSchedule" modelAttribute="scheduleForm" method="post">
    Enter date: <br>
    <form:input path="date" type ="date"/><br>
    <form:errors path="date" cssStyle="color: red"/><br>

    Enter time from:<br>
    <form:select path="timeFrom">
        <%
            LocalTime timeFrom = LocalTime.of(8, 0);
            while (timeFrom.isBefore(LocalTime.of(20, 0))) {
        %>
        <form:option value="<%=timeFrom%>">
            <%=timeFrom%>
        </form:option>
        <% timeFrom = timeFrom.plusMinutes(20);
        }%>
    </form:select><br>
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
        <% timeTo = timeTo.plusMinutes(20);
        } %>
    </form:select><br>
    <br>
    <input type="submit" value="Add">
</form:form>
<a href="${pageContext.servletContext.contextPath}/schedule"><button>Back</button></a>


</body>
</html>
