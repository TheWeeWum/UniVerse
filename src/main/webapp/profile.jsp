<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.entity.review.Review" %>
<%@ page import="com.entity.Reviewable" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="css/user-profile.css">
    <link rel="stylesheet" href="css/navbar.css">
    <link rel="stylesheet" href="css/footer.css">
    <link rel="stylesheet" href="css/standard_background.css">
    <title>User Profile</title>
</head>

<body>

<header>
    <h1>User Profile</h1>
</header>
<%
    // Retrieve the HttpSession object
    boolean loggedIn = false; // Default to false if no session or 'loggedIn' attribute found

// Check if the session exists and if the 'loggedIn' attribute is present and not null
    if (session != null && session.getAttribute("loggedIn") != null) {
        loggedIn = (boolean) session.getAttribute("loggedIn");
    }
%>
<nav>
    <a href="index">Home</a>
    <a href="mainmap">Main Map</a>
    <div class="dropdown">
        <a class="dropbtn">Profile</a>
        <div class="dropdown-content">
            <a href="#favourites">Favourites</a>
            <a href="#userReviews">Reviews</a>
            <a href="profile">Profile</a>
        </div>
    </div>
    <a href="#about">About</a>
        <% if (loggedIn == false) { %>
    <a href="signup">Signup</a>
    <a href="login">Login</a>
        <% } %>
    <a href="buildings">Buildings</a>
    <a href="signout">Sign Out</a>
</nav>

<section>
    <% Review[] reviews = (Review[]) session.getAttribute("reviews");%>
    <h1>Welcome, <%= session.getAttribute("username")%></h1>

    <h3>Your Reviews</h3>
    <ul id="reviews">
        <% if (reviews != null && reviews.length > 0) { %>
        <% for (Review review : reviews) { %>
        <li><%= review.getContent() %></li>
        <% } %>
        <% } else { %>
        <li>No reviews available.</li>
        <% } %>
    </ul>
    <% Reviewable[] favourites = (Reviewable[]) session.getAttribute("favourites");%>
    <h3>Your Favorites</h3>
    <ul id="favourites">
        <% if (favourites != null && favourites.length > 0) { %>
        <% for (Reviewable place : favourites) { %>
            <!-- get something-->
        <% } %>
        <% } else { %>
        <li>No reviews available.</li>
        <% } %>
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
