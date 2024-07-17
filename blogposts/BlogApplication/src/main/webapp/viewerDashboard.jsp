<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Viewer Dashboard</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
    <h1>Viewer Dashboard</h1>
    <c:forEach var="post" items="${posts}">
        <h2>${post.title}</h2>
        <p>${post.content}</p>
        <p>Posted on: ${post.createdAt}</p>
    </c:forEach>
    <c:if test="${currentPage > 1}">
        <a href="viewerDashboard?page=${currentPage - 1}&sort=${sort}">Previous</a>
    </c:if>
    <c:if test="${currentPage < totalPages}">
        <a href="viewerDashboard?page=${currentPage + 1}&sort=${sort}">Next</a>
    </c:if>
    <a href="logout">Logout</a>
</body>
</html>
