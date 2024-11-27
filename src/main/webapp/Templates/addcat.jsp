<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Category</title>
</head>
<body>
    <h1>Add Category</h1>
    <form action="/addcategory" method="post">
        <label for="categoryName">Category Name:</label>
        <input type="text" id="categoryName" name="categoryName" required>
        <br>
        <input type="submit" value="Add Category">
    </form>
    <a href="adminhome">Back to Admin Home</a>
</body>
</html>
