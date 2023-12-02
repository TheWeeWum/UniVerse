<%--
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
    <a href="signout">Sign Out</a>
</nav>

<section>
    <h1>Welcome, <%= session.getAttribute("username")%></h1>
</section>

<div id="favouriteBuildingsContainer"> </div>

</body>
</html>
