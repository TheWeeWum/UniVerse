<%@ page import="com.entity.Reviewable" %><%--
  Created by IntelliJ IDEA.
  User: evan
  Date: 11/17/2023
  Time: 3:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="css/user-profile.css">
    <link rel="stylesheet" href="css/navbar.css">
    <link rel="stylesheet" href="css/footer.css">
    <link rel="stylesheet" href="css/standard_background.css">
    <script src="js/favourites.js"></script>

    <title>Favourites</title>

</head>
<body>

<header>
    <h1>Favourites</h1>
</header>

<!--    NAVBAR-->
<nav>
    <a href="index">Home</a>
    <a href="mainmap">Main Map</a>
    <div class="dropdown">
        <a class="dropbtn">Profile</a>
        <div class="dropdown-content">
            <a href="favourites">Favourites</a>
            <a href="reviews_page">Reviews</a>
            <a href="profile">Profile</a>
        </div>
    </div>
    <a href="about">About</a>
    <a href="signup">Signup</a>
    <a href="login">Login</a>
    <a href="buildings">Buildings</a>

    <!-- Add more links as needed -->
</nav>

<section>
    <h1>Welcome, <%= session.getAttribute("username")%></h1>

    <h3>Your Favorites</h3>
    <% Reviewable[] favourites = (Reviewable[]) session.getAttribute("favourites");%>
    <h3>Your Favorites</h3>
    <ul id="favourites">
        <% if (favourites != null && favourites.length > 0) { %>
        <% for (Reviewable place : favourites) { %>
        <!-- get something-->
        <% } %>
        <% } else { %>
        <li>No favourites available.</li>
        <% } %>
    </ul>
</section>

<div id="favouriteBuildingsContainer"> </div>

</body>
</html>
