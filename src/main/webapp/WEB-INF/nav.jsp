<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<nav>
    <ul class="pagination">
        <c:if test="${!(currentPage == 1)}">
            <li><a href = "/students?current=${currentPage - 1}">&laquo;</a></li>
        </c:if>
    </ul>
    <ul class="pagination" id="paginationLinks"></ul>
    <ul class="pagination">
        <fmt:formatNumber var="countPages"
                          value="${(totalCount / pageSize)}"
                          maxFractionDigits="0" />
        <c:if test="${!(currentPage > countPages)}">
            <li><a href = "/students?current=${currentPage + 1}">&raquo;</a></li>
        </c:if>
    </ul>
    <script>
        function generationPaginationLinks(currentPage, totalCount, pageSize) {
            var countPages = Math.ceil(totalCount / pageSize);
            var startPage = (currentPage === 1) ? currentPage : currentPage - 1;
            var endPage = (currentPage === countPages) ? currentPage : currentPage + 1;
            var paginationLinks = $("#paginationLinks");
            for (var i = startPage; i <= endPage; i++) {
                var link = $("<li>").append($("<a></a>").attr("href","/students?current=" + i).text(i)).append($("</li>"));
                if (currentPage === i) {
                    link.addClass("active");
                }
                paginationLinks.append(link);
            }
        }
        $( document ).ready(function() {
        generationPaginationLinks(${currentPage}, ${totalCount}, ${pageSize});
    });</script>
</nav>