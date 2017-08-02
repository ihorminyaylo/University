<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<html>
<head>
    <title>Edit lesson</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>
<jsp:include page="menu.jsp"/>
<form class="form-horizontal" action="edit_lesson" method="post">
    <h1>Edit information about lesson</h1>
    <div class="form-group">
        <select>
            <option value="0">Select subject</option>
            <c:forEach items="${subjectList}" var="s">
                <option value="${s.idSubject}">${s.subjectName}</option>
            </c:forEach>
        </select>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="subjectName" placeholder="Enter subject name" name="newSubjectName">
        </div>
    </div>
</form>
</body>
</html>
