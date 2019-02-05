<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/partials/head.jsp">
        <jsp:param name="title" value="Viewing all of the quotes!" />
    </jsp:include>
</head>
<body>
<jsp:include page="/partials/navbar.jsp" />

    <div class="container">

        <h1>Here Are all the quotes!</h1>

        <c:forEach var="quote" items="${quotes}">
            <div class="col-md-6">
                <h2>${quote.quote}</h2>
                <p>Author: ${quote.author}</p>
            </div>
        </c:forEach>
    </div>
</body>
</html>
