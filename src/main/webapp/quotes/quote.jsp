<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/partials/head.jsp">
        <jsp:param name="title" value="Viewing a random quote." />
    </jsp:include>
</head>
<body>
<jsp:include page="/partials/navbar.jsp" />


<div class="container">
    <h1>Quote: ${quote.quote}</h1>
    <p>Author: ${quote.author}</p>
</div>

</body>
</html>
