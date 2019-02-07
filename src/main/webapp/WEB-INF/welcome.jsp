<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="partials/head.jsp" />
</head>
<body>

<jsp:include page="partials/navbar.jsp" />

<main class="container">

    <%-- Page Content Goes Here --%>
    ${greeting}, ${username}!

</main>

<jsp:include page="partials/footer.jsp" />

</body>
</html>
