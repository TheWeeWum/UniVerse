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

<header>
    <h1>Add Event</h1>
</header>

<form action="add_event" method="post">
    <div class="input-group">
        <label for="title">Title:</label>
        <input type="text" id="title" name="title" required><br><br>
    </div>

    <div class="input-group">
        <label for="organizer">Organizer:</label>
        <input type="text" id="organizer" name="organizer" required><br><br>
    </div>

    <div class="input-group">
        <label for="room">Room:</label>
        <input type="text" id="room" name="room" required><br><br>
    </div>

    <div class="input-group">
        <label for="time">Time:</label>
        <input type="datetime-local" id="time" name="time" required><br><br>
    </div>

    <div class="input-group">
        <label for="description">Description:</label>
        <input type="text" id="description" name="description" required><br><br>
    </div>

    <input type="submit" value="AddEvent">
</form>

<!--   if the getAttribute("errorMessage") of the request isn't 0, then there's an error with the AddEvent.-->
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
