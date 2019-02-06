<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="partials/head.jsp" />
</head>
<body>

<jsp:include page="partials/navbar.jsp" />

<main class="container">

    <h1>Login to your account</h1>

    <form action="/login" method="POST">

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
