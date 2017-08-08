<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
<head>
    <title>HOME</title>
    <link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
    <script src="<c:url value="/resources/jquery/external/jquery/jquery.js"/>"></script>
    <script src="<c:url value="/resources/jquery/jquery-ui.min.js"/>"></script>
    <script src="<c:url value="/resources/js/bootstrap.js"/>"></script>
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
                            <form action="/delete_student?id=${st.id}" method="post">
                                <input type="submit" value="Delete" <c:if test="${studentHasMarks.get(st.id)}">disabled data-toggle="tooltip" title="The student has marks" data-placement="left"</c:if> class="btn btn-danger btn-md" onclick="return confirm('Are you sure?')">
                            </form>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:otherwise>
    </c:choose>
    <p><a type="button" href="/add_student" class="btn btn-primary btn-lg" cem>Add student</a></p>
        <jsp:include page="/WEB-INF/nav.jsp"/>
</body>
</html>