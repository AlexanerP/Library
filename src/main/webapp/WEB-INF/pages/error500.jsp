<%--
  Created by IntelliJ IDEA.
  User: Александр
  Date: 16.12.2021
  Time: 18:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="/WEB-INF/pages/error500.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Error</title>
</head>
<body>
<div class="container" >
    <div class="center">
        <a class="button" href="Controller?command=GoToMainPage"><fmt:message key="main_page"></fmt:message></a>
    </div>
</div>
<br><br>
<div align="center"><img src="/images/error500.jpeg"> </div>
</body>
</html>
