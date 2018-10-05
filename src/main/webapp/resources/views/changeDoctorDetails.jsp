<%@ page import="java.util.List" %>
<%@ page import="healthCenter.entity.Specialization" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: ania
  Date: 31.07.2018
  Time: 03:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Change doctor details</title>
    <link href="${pageContext.servletContext.contextPath}/resources/css/app.css" rel="stylesheet">

</head>
<body>
<jsp:include page="menu.jsp"/>
<form:form action="changeDetails" modelAttribute="doctorDto" method="post">
    <form:input path="id" value = "${doctor.id}" type="hidden"/><br>
    Name:<br>
    <form:input path="name" value="${doctor.name}"/><br>
    <form:errors path="name" cssStyle="color: red"/><br>
    Surname:<br>
    <form:input path="surname" value="${doctor.surname}"/><br>
    <form:errors path="surname" cssStyle="color: red"/><br>
    Id number:<br>
    <form:input path="idNumber" value="${doctor.idNumber}"/><br>
    <form:errors path="idNumber" cssStyle="color: red"/><br>
    Date of birth:<br>
    <form:input path="dateOfBirth" value="${doctor.dateOfBirth}" type="date"/><br>
    <form:errors path="dateOfBirth" cssStyle="color: red"/><br>
    Country:<br>
    <form:input path="country" value="${doctor.address.country}"/><br>
    <form:errors path="country" cssStyle="color: red"/><br>
    City:<br>
    <form:input path="city" value="${doctor.address.city}"/><br>
    <form:errors path="city" cssStyle="color: red"/><br>
    Street:<br>
    <form:input path="street" value="${doctor.address.street}"/><br>
    <form:errors path="street" cssStyle="color: red"/><br>
    Specializations:<br>
    <% List<Specialization> specializations = (List<Specialization>) request.getAttribute("specializations"); %>
    <form:select multiple="true" path="specializations">
        <%for (Specialization specialization: specializations) { %>
        <form:option value="<%=specialization.getName()%>">
            <%=specialization.getName()%>
        </form:option>
        <%}%>
    </form:select><br>
    <input type="submit" value="Change">
</form:form>
</body>
</html>
