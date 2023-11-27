<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="css/login.css">
    <link rel="stylesheet" href="css/navbar.css">
    <link rel="stylesheet" href="css/standard_background.css">
    <title>UniVerse</title>
</head>
<body>

<!--    NAVBAR-->
<nav>
    <a href="index">Home</a>
    <a href="mainmap">Main Map</a>
    <div class="dropdown">
        <a class="dropbtn">Profile</a>
        <div class="dropdown-content">
            <a href="favourites">Favourites</a>
            <a href="#userReviews">Reviews</a>
            <a href="profile">Profile</a>
        </div>
    </div>
    <a href="#about">About</a>
    <a href="signup">Signup</a>
    <a href="login">Login</a>
    <a href="buildings">Buildings</a>

    <!-- Add more links as needed -->
</nav>

<header>
    <h1>Signup</h1>
</header>

<form action="signup" method="post">
    <div class="input-group">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required><br><br>
    </div>

    <div class="input-group">
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br><br>
    </div>

    <div class="input-group">
        <label for="repeat-password">Repeat Password:</label>
        <input type="password" id="repeat-password" name="repeated password" required><br><br>
    </div>
    <input type="submit" value="Signup">
</form>

<!--   if the getAttribute("errorMessage") of the request isn't 0, then there's an error with the Sign-Up.-->
<% if (request.getAttribute("errorMessage") != null) { %>
    <div class="error-frame">
        <div class="error-message">
            <%-- Display error message here --%>
            <p class="error-text"><%= request.getAttribute("errorMessage")%></p>
        </div>
    </div>
<% } %>



</body>
</html>
