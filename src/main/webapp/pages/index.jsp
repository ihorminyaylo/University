<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
<head>
    <title>HOME</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>
<jsp:include page="menu.jsp"/>
<div class="container">
    <c:choose>
        <c:when test="${empty students}">
            We don't have students.
        </c:when>
        <c:otherwise>
            <h2>Students</h2>
            <table class="table table-condensed">
                <thead>
                <tr>
                    <th>#</th>
                    <th>First name</th>
                    <th>Last name</th>
                    <th>ACTION for student</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${students}" var="st" varStatus="status">
                    <tr>
                        <td>${status.count}</td>
                        <td>${st.firstName}</td>
                        <td>${st.lastName}</td>
                        <td>
                            <div class="row">
                                <div class="col-md-2">
                                    <a type="button" href="/edit_student?id=${st.id}" class="btn btn-primary btn-md">Edit</a>
                                </div>
                                <div class="col-md-2">
                                    <form action="/delete_student?id=${st.id}" method="post">
                                        <input type="submit" value="Delete" class="btn btn-primary btn-md">
                                    </form>
                                </div>
                            </div>
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