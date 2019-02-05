<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="partials/head.jsp" />

    <title><%= "Welcome to the Home Page" %></title>
</head>
<body>
    <jsp:include page="partials/navbar.jsp" />

    <main class="container">
        <h1>Welcome to the Home Page of the Ad-Lister</h1>

        <img src="https://cdn.glitch.com/c1e65908-81db-4c5b-8274-40cc385dfa54%2Fretro-ads.jpg?1549401801633" alt="retro advertisement for advertisements">
    </main>
</body>
</html>
