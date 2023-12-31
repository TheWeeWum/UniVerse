<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>UniVerse</title>
    <link rel="stylesheet" href="css/standard_background.css">
    <link rel="stylesheet" href="css/buildings.css">
    <link rel="stylesheet" href="css/navbar.css">
    <link rel="stylesheet" href="css/footer.css">
    <link rel="stylesheet" href="css/header.css">
    <link rel="stylesheet" href="css/buildingreviews.css">
    <script src="js/buildingreviews.js"></script>
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

<header id="title"></header>

<!-- Container for building sections -->
<div id="reviewsContainer"></div>

<!-- Load More button -->
<button id="loadMoreButton" onclick="loadMoreReviews()"> Load More Reviews ↓</button>


</body>
</html>

