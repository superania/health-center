<%@ page import="healthCenter.entity.Specialization" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="select" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: ania
  Date: 03.08.2018
  Time: 03:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create doctor account</title>
    <link href="${pageContext.servletContext.contextPath}/resources/css/app.css" rel="stylesheet">

</head>
<body>
<jsp:include page="menu.jsp"/>

<form:form action="createDoctorAccount" modelAttribute="doctorDto" method="post">
    Enter login:<br>
    <form:input path="login"/><br>
    <form:errors path="login" cssStyle="color: red"/><br>
    Enter password:<br>
    <form:input path="password" type="password"/><br>
    <form:errors path="password" cssStyle="color: red"/><br>
    Enter name:<br>
    <form:input path="name"/><br>
    <form:errors path="name" cssStyle="color: red"/><br>
    Enter surname:<br>
    <form:input path="surname"/><br>
    <form:errors path="surname" cssStyle="color: red"/><br>
    Enter id number:<br>
    <form:input path="idNumber"/><br>
    <form:errors path="idNumber" cssStyle="color: red"/><br>
    Enter date of birth:<br>
    <form:input path="dateOfBirth" type="date"/><br>
    <form:errors path="dateOfBirth" cssStyle="color: red"/><br>
    Enter country:<br>
    <form:input path="country"/><br>
    <form:errors path="country" cssStyle="color: red"/><br>
    Enter city:<br>
    <form:input path="city" /><br>
    <form:errors path="city" cssStyle="color: red"/><br>
    Enter street:<br>
    <form:input path="street"/><br>
    <form:errors path="street" cssStyle="color: red"/><br>
    <% List<Specialization> specializations = (List<Specialization>) request.getAttribute("specializations");%>
    Choose specializations:<br>
    <form:select multiple="true" path="specializations" >
        <% for (Specialization specialization : specializations) { %>
        <form:option value="<%=specialization.getName()%>">
            <%=specialization.getName()%>
        </form:option>
        <%}%>
    </form:select><br><br>
    <input type="submit" value="Add">
</form:form>
<a href="${pageContext.servletContext.contextPath}/doctorOptions"><button>Back</button></a>

</body>
</html>
