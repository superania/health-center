<%@ page import="healthCenter.entity.Office" %>
<%@ page import="java.util.Set" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ania
  Date: 06.08.2018
  Time: 16:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Find office</title>
    <link href="${pageContext.servletContext.contextPath}/resources/css/app.css" rel="stylesheet">

</head>
<body>
<jsp:include page="menu.jsp"/> ${scheduleForm.date}
${scheduleForm.timeFrom} - ${scheduleForm.timeTo}<br>
Choose office:
<form:form action="saveSchedule" modelAttribute="officeId" method="post">
    <form:input path="scheduleId" type="hidden" value="${officeId.scheduleId}"/>

    <% Set<Office> offices = (Set<Office>) request.getAttribute("offices");%>
    <c:if test="${offices == null}">
        There is no office available
    </c:if>
<form:select path="officeId">

    <% for (Office office : offices) { %>
        <form:option value="<%= office.getId()%>">
            <%=office.getNumber()%>
        </form:option>
    <% } %>
</form:select>
    <br>
    <br>
<input type="submit" value="Add">
</form:form>
</body>
</html>
