<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>UniVerse</title>
    <link rel="stylesheet" href="css/standard_background.css">
    <link rel="stylesheet" href="css/building.css">
    <link rel="stylesheet" href="css/navbar.css">
    <link rel="stylesheet" href="css/footer.css">
    <link rel="stylesheet" href="css/header.css">

    <script async src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBNWxKThZ-Rq8dU0AH_DOrzJ-itEYicp-E&callback=initMap&libraries=maps,marker&v=beta"></script>
    <script src="js/building.js"></script>
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

<!-- Container for title -->
<header id="title"></header>

<!-- Container for building info -->
<div id="buildingContainer"></div>

<!-- Container for map header -->
<div id="mapTitle"></div>

<!-- Container for map -->
<div id="map"></div>

<!-- Container for events -->
<div id="events"></div>

<!-- Container for events -->
<button id="favouritesButton" onclick="favourite()" onmouseover="changeText()" onmouseout="restoreText()"> 🤍 Add to Favourites 🤍 </button>

<div class="contactInformation">
    <h1>
        Contact us
    </h1>
    <h3> The Gods of the UniVerse</h3>
    <p>
        Evan Wang<br>
        Isabella Nguyen<br>
        Ivan Kraskov<br>
        Liam Csiffary<br>
        Raon Kim<br>
    </p>
</div>

</body>
</html>
