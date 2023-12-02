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

<% if (session.getAttribute("loggedIn") == null || session.getAttribute("loggedIn").equals(false))  { %>
<h1>Please Login to View Profile or Sign up to Start</h1>
<%} else { %>
<h1>Welcome, <%= session.getAttribute("username")%></h1>
<% } %>

<section id="favourites">
    <h2>Favourites</h2>
    <div id="favouritesContainer">
        <!-- Favourites content goes here -->
    </div>

    <h2>Your Reviews</h2>
    <div id="reviewContainer">
        <!-- Reviews content goes here -->
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
