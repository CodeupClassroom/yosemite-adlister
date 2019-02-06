<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@ include file="partials/logo.jsp"%>
<!--this is an html comment-->
<%-- this is a jsp comment--%>
<%! int i = 0; %>
<%! boolean even = true; %>

<% String greeting="Howdy"; %>
<% i++; %>
<% even = !even; %>
<h1> <%= greeting %>, this is our jsp!!</h1>
<h2>i = <%= i %></h2>
<h2><% if(even) { %>
    Even
    <% } else { response.sendError(404); } %>
</h2>
<p>Path: <%= request.getRequestURL() %></p>
<p>Query String: <%= request.getQueryString() %></p>
<p>"name" parameter: ${param.name}</p>
<p>User-Agent header: <%= request.getHeader("user-agent") %></p>

<c:forEach var="i" begin="1" end="30">
    <c:choose>
        <c:when test="${i%15==0}">
            Fizzbuzz<br>
        </c:when>
        <c:when test="${i%3==0}">
            Fizz<br>
        </c:when>
        <c:when test="${i%5==0}">
            Buzz<br>
        </c:when>
        <c:when test="${i%5!=0&&i%3!=0}">
            ${i}<br>
        </c:when>
    </c:choose>
</c:forEach>

<%@ include file="WEB-INF/partials/footer.jsp"%>
</body>
</html>
