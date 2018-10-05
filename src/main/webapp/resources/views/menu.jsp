<%--
  Created by IntelliJ IDEA.
  User: ania
  Date: 29.07.2018
  Time: 22:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <title>Menu</title>
</head>
<body>
<ul>
    <li><a href="${pageContext.servletContext.contextPath}/main">Home</a> </li>
    <sec:authorize access="isAuthenticated()">
        <li><a href="<c:url value="/logout"/>">Logout</a></li>
    </sec:authorize>
    <sec:authorize access="isAnonymous()">
        <li><a href="<c:url value="/login"/>">Login</a> </li>
    </sec:authorize>
    <sec:authorize access="isAnonymous()">
        <li><a href="<c:url value="/register"/>">Create new account</a> </li>
    </sec:authorize>
    <sec:authorize access="hasRole('ROLE_PATIENT')">
        <li><a href="${pageContext.servletContext.contextPath}/showPatientDetails">Personal details</a> </li>
        <li><a href="${pageContext.servletContext.contextPath}/showVisitHistory">History of visits</a> </li>
        <li><a href="${pageContext.servletContext.contextPath}/showPlannedVisits">Planned visits</a> </li>
        <li><a href="${pageContext.servletContext.contextPath}/makeAppointment">Make an appointment</a> </li>
    </sec:authorize>
    <sec:authorize access="hasRole('ROLE_DOCTOR')">
        <li><a href="${pageContext.servletContext.contextPath}/showDoctorDetails">My personal details</a> </li>
        <li><a href="${pageContext.servletContext.contextPath}/schedule">Create schedule</a> </li>
        <li><a href="${pageContext.servletContext.contextPath}/workPlan">Work plan</a> </li>
        <li><a href="${pageContext.servletContext.contextPath}/findPatientByNameAndSurname">Find patient by name</a> </li>
        <li><a href="${pageContext.servletContext.contextPath}/findPatientByIdNumber">Find patient by id number</a> </li>
    </sec:authorize>
    <sec:authorize access="hasRole('ROLE_ADMIN')">
        <li><a href="${pageContext.servletContext.contextPath}/showAdminDetails">Personal details</a> </li>
        <li><a href="${pageContext.servletContext.contextPath}/doctorOptions">Doctors</a> </li>
        <li><a href="${pageContext.servletContext.contextPath}/specializations">Specializations</a> </li>
        <li><a href="${pageContext.servletContext.contextPath}/officeOption">Offices</a> </li>
    </sec:authorize>

</ul>
</body>
</html>
