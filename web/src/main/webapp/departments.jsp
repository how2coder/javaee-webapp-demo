<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Demo - departments</title>
</head>
<body>
<h2>List of departments</h2>

<ul>
    <c:forEach items="${departments}" var="department">
    <li><a href="<c:out value="departments/${department.id}"/>">${department.name}</a></li>
    </c:forEach>
</ul>

</body>
</html>
