<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create Post</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
    <h1>Create New Post</h1>
    <form action="createPost" method="post" enctype="multipart/form-data">
        <label for="title">Title:</label>
        <input type="text" id="title" name="title" required><br>
        <label for="content">Content:</label>
        <textarea id="content" name="content" required></textarea><br>        Image URL (optional): <input type="file" name="image"><br>
        
        <button type="submit">Create</button>
    </form>
</body>
</html>
