<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<html>
<head>
    <title>Edit student</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>
<jsp:include page="menu.jsp"/>
<form class="form-horizontal" action="/edit_student" method="POST">
    <h1>Edit information about ${student.firstName} ${student.lastName}</h1>
    <input type="hidden" id="id" value="${student.id}" name="id">
    <div class="form-group">
        <label class="control-label col-sm-2" for="firstName">First name</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="firstName" placeholder="Enter first name" name="newFirstName">
        </div>
    </div>
    <div class="form-group">
        <label class="control-label col-sm-2" for="lastName">Last name</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="lastName" placeholder="Enter last name" name="newLastName">
        </div>
    </div>
    <div class="form-group" align="center">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-default">OK</button>
        </div>
    </div>
</form>
</body>
</html>
