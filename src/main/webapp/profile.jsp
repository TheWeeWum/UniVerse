<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="css/user-profile.css">
    <title>User Profile</title>
</head>

<body>

<header>
    <h1>User Profile</h1>
</header>

<nav>
    <a href="index.html">Main Map</a>
    <a href="#about">About</a>
    <a href="profile">Profile</a>
</nav>

<section>
    <h1>Welcome, <%= session.getAttribute("username")%></h1>

    <h3>Your Reviews</h3>
    <ul id="reviews">
        <li>Review 1: This is your first review.</li>
        <li>Review 2: You reviewed another place.</li>
    </ul>

    <h3>Your Favorites</h3>
    <ul id="favourites">
        <li>Favorite 1: Your favorite study spot.</li>
        <li>Favorite 2: The cleanest bathroom on campus.</li>
    </ul>
</section>

<div class="contactInformation">
    <h1>Contact Us</h1>
    <h3>The Gods of the UniVerse</h3>
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
