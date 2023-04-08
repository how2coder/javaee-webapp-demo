<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Demo - ${department.name}</title>
</head>
<body>
<h2>Department: ${department.name}</h2>

<table border="1">
    <caption>List of employees</caption>
    <thead>
    <tr>
        <th>full name</th>
        <th>birthdate</th>
        <th>salary</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${department.employees}" var="employee">
        <tr>
            <td><a href="<c:out value="../employee/${employee.id}"/>">${employee.lastName} ${employee.firstName}</a></td>
            <td>${employee.birthDate}</td>
            <td>${employee.salary}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
