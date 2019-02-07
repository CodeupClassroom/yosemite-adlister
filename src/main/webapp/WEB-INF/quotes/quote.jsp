<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="../partials/head.jsp" />
</head>
<body>
<jsp:include page="../partials/navbar.jsp" />


<div class="container">
    <div class="quote">
        <h1>Quote: ${quote.quote}</h1>
        <p>Author: ${quote.author}</p>
    </div>
    <a href="/quotes/random" class="btn btn-primary">Get another random quote!</a>
</div>

</body>
</html>
