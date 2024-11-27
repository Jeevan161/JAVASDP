<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false"%> 
<%@ taglib uri="jakarta.tags.core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
    <title>Add Subcategory</title>
</head>
<body>
    <h1>Add Subcategory</h1>
    <form action="addsubcategory" method="post">
        <label for="subCategoryName">Subcategory Name:</label>
        <input type="text" id="subCategoryName" name="subCategoryName" required>
        <br>
        <label for="categoryId">Select Category:</label>
        <select id="categoryId" name="categoryId" required>
            <c:forEach items="${categoryList}" var="category">
                <option value="${category.id}">${category.name}</option>
            </c:forEach>
        </select>
        <br>
        <input type="submit" value="Add Subcategory">
    </form>
    <a href="adminhome">Back to Admin Home</a>
</body>
</html>
