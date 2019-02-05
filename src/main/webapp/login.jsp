<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="partials/head.jsp" />
</head>
<body>

<%
    if(request.getMethod().equalsIgnoreCase("post")) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if(username.equals("admin") && password.equals("password")) {
            response.sendRedirect("/profile.jsp");
        } else {
            response.getWriter().println("<div class='alert alert-danger' role='alert'>The username or password is incorrect!</div>");
        }

    }
%>

<jsp:include page="partials/navbar.jsp" />

<main class="container">

    <h1>Login to your account</h1>

    <form action="login.jsp" method="POST">

        <div class="form-group">
            <label for="username">Username:</label>
            <input type="text" name="username" id="username" placeholder="Your username">
        </div>

        <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" name="password" id="password" placeholder="Your password">
        </div>

        <button type="submit" class="btn btn-primary">Login</button>
    </form>

</main>

</body>
</html>
