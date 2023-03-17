<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Demo - main</title>
</head>
<body>
<h2>JavaEE Webapp Demo - Main page</h2>
<c:url value="/departments" var="departments"/>
<c:url value="/managers" var="managers"/>
<c:url value="/employees" var="employees"/>
<ul>
    <li><a href="<c:out value="${departments}"/>">departments</a></li>
    <li><a href="<c:out value="${managers}"/>">managers</a></li>
    <li><a href="<c:out value="${employees}"/>">employees</a></li>
</ul>
</body>
</html>
