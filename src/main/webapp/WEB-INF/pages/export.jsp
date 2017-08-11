<%--
  Created by IntelliJ IDEA.
  User: iminiatc
  Date: 09.08.2017
  Time: 16:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<html>
<head>
    <title>Export(JSON)</title>
    <link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
    <script src="<c:url value="/resources/jquery/external/jquery/jquery.js"/>"></script>
    <script src="<c:url value="/resources/jquery/jquery-ui.min.js"/>"></script>
    <script src="<c:url value="/resources/js/bootstrap.js"/>"></script>
    <jsp:include page="LoginSuccess.jsp"/>
</head>
<body>
<jsp:include page="menu.jsp"/>
<div class="container" align="center">
<form action="/export" method="post">
    <input type="submit" value="DUMP" class="btn btn-danger btn-md">
</form>
</div>
</body>
</html>
