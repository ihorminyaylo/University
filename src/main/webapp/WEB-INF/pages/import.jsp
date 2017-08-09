<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<html>
<head>
    <title>Import(JSON)</title>
    <link href="<c:url value="/resources/css/bootstrap.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/but_imp_exp.css"/>">


    <link href="<c:url value="/resources/jquery/jquery-ui.min.css"/>" rel="stylesheet">
    <script src="<c:url value="/resources/jquery/external/jquery/jquery.js"/>"></script>
    <script src="<c:url value="/resources/jquery/jquery-ui.min.js"/>"></script>
</head>
<body>
<jsp:include page="menu.jsp"/>
<div class="container">
<h2>IMPORT/EXPORT</h2>
<div class="input-group">
    <label class="input-group-btn">
                    <span class="btn btn-primary">
                        Browse&hellip; <input type="file" style="display: none;" multiple>
                    </span>
    </label>
</div>
<a type="button" href="/import" class="btn btn-primary btn-md">Import</a>
<input type="submit" value="IMPORT">
</div>
</body>
</html>
