<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
<head>
    <title>HOME</title>
    <link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
    <script src="<c:url value="/resources/jquery/external/jquery/jquery.js"/>"></script>
    <script src="<c:url value="/resources/jquery/jquery-ui.min.js"/>"></script>
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
                        <td>${status.count}</td>
                        <td>${st.firstName}</td>
                        <td>${st.lastName}</td>
                        </td>
                        <td>
                            <a type="button" href="/edit_student?id=${st.id}" class="btn btn-primary btn-md">Edit</a>
                        </td>
                        <td>

                            <script>
                                function deleteS(s) {
                                    var r = confirm(s);
                                    return r;
                                }

                                function keypress() {
                                    console.log( "Handler for .keypress() called." );
                                }
                            </script>

                            <form action="/delete_student?id=${st.id}" method="post">
                                <input type="submit" value="Delete" class="btn btn-danger btn-md" onclick="return keypress()('Are you sure you want to remove this student?')">
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