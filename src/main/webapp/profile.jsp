<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="partials/head.jsp" />

</head>
<body>

    <jsp:include page="partials/navbar.jsp" />
    <%

        String referrer = request.getHeader("referer"); // Yes, with the legendary misspelling.

        if(referrer.equals("http://localhost:8080/login.jsp")) {
            response.getWriter().println("<div class='alert alert-success' role='alert'>Welcome to your Profile</div>");
        }

    %>
    <main class="container">
        <h1>This is the profile page.</h1>
        <h2>You should only see this content if you're logged in!</h2>

    </main>

</body>
</html>
