<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Demo - Department create</title>
</head>
<body>
<c:url value="/departments" var="departments"/>
<form action="<c:out value="${departments}"/>" method="POST">
    <div>
        <label for="name">Name</label>
        <input name="dep_name" id="name" />
    </div>
    <div>
        <button>create</button>
    </div>
</form>

</body>
</html>
