<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.entity.review.Review" %>
<%@ page import="com.entity.Reviewable" %>
<%@ page import="java.util.List" %>

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
</header><nav>
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
        <a href="buildings">Buildings</a>
        <a href="signup">Signup</a>
        <a href="login">Login</a>
    </nav>

<%--    Add sign out button?--%>


<% if (session.getAttribute("loggedIn") == null|| session.getAttribute("loggedIn").equals(false))  { %>
<h1>Please Login to View Profile or Sign up to Start</h1>
<%} else { %>
<h1>Welcome, <%= session.getAttribute("username")%></h1>
<% } %>
<section id="favourites">
    <h2>Favourites</h2>
    <div id="favouritesContainer">
        <!-- Iterate over the favoriteBuildings data and create list items -->
        <ul>
            <%
                List<String> favouriteBuildings = (List<String>) request.getAttribute("favouriteBuildings");
                if (favouriteBuildings != null) {
                    for (String building : favouriteBuildings) {
            %>
            <li><%= building %></li>
            <%
                    }
                }
            %>
        </ul>
    </div>
</section>
<section id="reviews">
    <h2>Your Reviews</h2>
    <div id="reviewContainer">
        <!-- Iterate over the reviews data and create review items -->
        <%
            List<Review> reviews = (List<Review>) request.getAttribute("reviews");
            if (reviews != null) {
                for (Review review : reviews) {
        %>
        <div class="review-item">
            <h3><%= review.getTitle() %></h3>
            <p><%= review.getContent() %></p>
            <p>Rating: <%= review.getRating() %></p>
        </div>
        <%
                }
            }
        %>
    </div>
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
