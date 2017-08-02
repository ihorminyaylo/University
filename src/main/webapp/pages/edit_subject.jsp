<%--
  Created by IntelliJ IDEA.
  User: iminiatc
  Date: 01.08.2017
  Time: 17:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit subject</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>
<jsp:include page="menu.jsp"/>
<form class="form-horizontal" action="/edit_subject" method="POST">
    <div class="container">
        <div class="col-md-12">
            <h1>Edit subject name for ${subject.subjectName}</h1>
        </div>
    </div>
    <div class="form-group">
        <label class="control-label col-sm-2" for="subjectName">Subject name</label>
        <div class="col-sm-5">
            <input type="text" class="form-control" id="subjectName" placeholder="Enter subject name" name="newSubjectName">
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-default">OK</button>
        </div>
    </div>
</form>
</body>
</html>
