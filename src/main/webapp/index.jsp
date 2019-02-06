<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="WEB-INF/partials/head.jsp" />

    <title><%= "Welcome to the Home Page" %></title>
</head>
<body>
    <jsp:include page="WEB-INF/partials/navbar.jsp" />

    <main class="container">
        <h1>Welcome to the Home Page of the Ad-Lister</h1>

        <img src="images/retro-ads.jpg" alt="retro advertisement for advertisements">
    </main>
</body>
</html>
