<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="css/signup.css">
    <title>Signup</title>
</head>
<body>
<header>
    <h1>Signup</h1>
</header>
<form action="signup" method="post">
    <label for="username">Username:</label>
    <input type="text" id="username" name="username" required><br><br>

    <label for="password">Password:</label>
    <input type="password" id="password" name="password" required><br><br>

    <label for="repeat password">Repeat Password:</label>
    <input type="password" id="repeat password" name="repeat password" required><br><br>

    <input type="submit" value="Signup">
</form>
</body>
</html>
