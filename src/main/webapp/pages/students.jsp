<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Students</title>
</head>
<body>
    <c:choose>
        <c:when test="${empty students}">
            We don't have students.
        </c:when>
    </c:choose>
    <c:otherwise>
        <table>
            <thead>
                <tr>
                    <th>#</th>
                    <th>First name</th>
                    <th>Last name</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${students}" var="student">
                    <td></td>
                    <td>${student.firstName}</td>
                    <td>${student.lastName}</td>
                </c:forEach>
            </tbody>
        </table>
    </c:otherwise>
</body>
</html>
