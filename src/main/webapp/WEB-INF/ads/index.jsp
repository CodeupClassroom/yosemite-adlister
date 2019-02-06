<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <jsp:include page="../partials/head.jsp" />
</head>
<body>

<jsp:include page="../partials/navbar.jsp" />

<main class="container">

    <%-- Page Content Goes Here --%>
    <h1>This is our ads page</h1>
        <ul>
        <c:forEach var="ad" items="${ads}">
            <li>
                <h3>${ad.title}</h3>
                <h4>${ad.description}</h4>
            </li>
        </c:forEach>
        </ul>

</main>

<jsp:include page="../partials/footer.jsp" />

</body>
</html>
