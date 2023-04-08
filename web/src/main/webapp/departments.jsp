<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Demo - departments</title>
</head>
<body>
<h2>List of departments</h2>

<ul>
    <c:forEach items="${departments}" var="department">
    <li>${department.name}</li>
    </c:forEach>
</ul>

</body>
</html>
