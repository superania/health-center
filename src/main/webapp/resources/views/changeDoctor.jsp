<%@ page import="healthCenter.entity.Specialization" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: ania
  Date: 03.08.2018
  Time: 05:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html>
<head>
    <title>Change doctor details</title>
    <link href="${pageContext.servletContext.contextPath}/resources/css/app.css" rel="stylesheet">

</head>
<body>
<jsp:include page="menu.jsp"/>

<form:form action="changeDetailsDoctor" modelAttribute="doctorForm" method="post">
    Enter name:<br>
    <form:input path="name" value="${doctor.name}"/><br>
    <form:errors path="name" cssStyle="color: red"/><br>
    Enter surname:<br>
    <form:input path="surname" value="${doctor.surname}"/><br>
    <form:errors path="surname" cssStyle="color: red"/><br>
    Enter country:<br>
    <form:input path="address.country" value = "${doctor.address.country}"/><br>
    <form:errors path="address.country" cssStyle="color: red"/><br>
    Enter city:<br>
    <form:input path="address.city" value = "${doctor.address.city}"/><br>
    <form:errors path="address.city" cssStyle="color: red"/><br>
    Enter street:<br>
    <form:input path="address.street" value="${doctor.address.street}"/><br>
    <form:errors path="address.street" cssStyle="color: red"/><br>
    Choose specializations:<br>
    <% List<Specialization> specializations = (List<Specialization>) request.getAttribute("specializations");%>
    <form:select path="specializations">
        <% for (Specialization specialization : specializations) { %>
        <form:option value="<%=specialization.getName()%>">
            <%=specialization.getName()%>
        </form:option>
        <%}%>
    </form:select><br><br>
    <input type="submit" value="Change">
</form:form>

</body>
</html>
