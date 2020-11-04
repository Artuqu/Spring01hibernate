<%--
  Created by IntelliJ IDEA.
  User: Art
  Date: 2020-10-24
  Time: 11:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Validation Show</title>
</head>
<body>
<div>Zapisano błędy z formularza</div>
    <c:forEach items="${violantions}" var="v">
    ${v.propertyPath} : ${v.message}<br>

    </c:forEach>
</body>
</html>
