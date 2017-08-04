<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
<head>
    <title>HOME</title>
    <link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
    <script src="<c:url value="/resources/jquery/external/jquery/jquery.js"/>"></script>
    <script src="<c:url value="/resources/jquery/jquery-ui.min.js"/>"></script>
    <script src="<c:url value="/WEB-INF/js/validate.js"/>"></script>
</head>
<body>
<jsp:include page="menu.jsp"/>
<div class="container">
    <c:choose>
        <c:when test="${empty students}">
            <h1>We don't have students.</h1>
        </c:when>
        <c:otherwise>
            <h2>Students</h2>
            <table class="table table-condensed">
                <thead>
                <tr>
                    <th>#</th>
                    <th>First name</th>
                    <th>Last name</th>
                    <th class="col-md-1"></th>
                    <th class="col-md-1"></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${students}" var="st" varStatus="status">
                    <tr>
                        <td><a href="/student/marks?id=${st.id}">${status.count}</a></td>
                        <td><a href="/student/marks?id=${st.id}">${st.firstName}</a></td>
                        <td><a href="/student/marks?id=${st.id}">${st.lastName}</a></td>
                        <td>
                            <a type="button" href="/edit_student?id=${st.id}" class="btn btn-primary btn-md">Edit</a>
                        </td>
                        <td>
                            <%--<script>
                                function deleteS(b) {
                                    if (b) {
                                        alert('This student has marks. You can not deleted this student!');
                                        return false;
                                    }
                                    else {
                                        var r;
                                        r = confirm('Are you sure you want to remove this student?');
                                        return r;
                                    }
                                }
                            </script>--%>
                            <form action="/delete_student?id=${st.id}" method="post">
                                <input type="submit" value="Delete" class="btn btn-danger btn-md" onclick="return deleteS(${studentHasMarks})">
                            </form>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:otherwise>
    </c:choose>
    <p><a type="button" href="/add_student" class="btn btn-primary btn-lg" cem>Add student</a></p>
</div>
</body>
</html>