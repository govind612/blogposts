<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Update Post</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
    <h1>Update Post</h1>
    <form action="updatePost" method="post">
        <input type="hidden" name="id" value="${post.id}">
        <label for="title">Title:</label>
        <input type="text" id="title" name="title" value="${post.title}" required><br>
        <label for="content">Content:</label>
        <textarea id="content" name="content" required>${post.content}</textarea><br>
        <button type="submit">Update</button>
    </form>
</body>
</html>
