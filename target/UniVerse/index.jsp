<!DOCTYPE html>
<html lang="">
<head>
    <link rel="stylesheet" href="css/index.css">
    <link rel="stylesheet" href="css/navbar.css">
    <link rel="stylesheet" href="css/footer.css">
    <link rel="stylesheet" href="css/standard_background.css">
    <title>Title</title>
</head>


<body>

<header>
    <h1>UniVerse</h1>
</header>

<!--    NAVBAR-->
<nav>
    <a href="#mainMap">Main Map</a>
    <div class="dropdown">
        <a class="dropbtn">Profile</a>
        <div class="dropdown-content">
            <a href="#favourites">Favourites</a>
            <a href="#userReviews">Reviews</a>
            <a href="profile">Profile</a>
        </div>
    </div>
    <a href="#about">About</a>
    <a href="signup">Signup</a>
    <a href="login">Login</a>

    <!-- Add more links as needed -->
</nav>

<section>
    <h1> Welcome to UniVerse </h1>

    <h3>Domain: Maps and Education / Campus Resource</h3>

    <h3>What is UniVerse?</h3>
    <p>
        Universe is an awesome UofT centered website made to help you discover awesome new study spots!
        And let others know about your favourites!
    </p>
</section>

<section>
    <h3>What UniVerse Can Do</h3>
    <ul>
        <li>
            Students can write reviews for lecture halls, bathrooms, cafeteria,
            or overall facilities for specific buildings
        </li>

        <li>
            Indicate amenities on campus (e.g - microwaves)
        </li>

        <li>
            Students can log in to create and save pins
        </li>

        <li>
            Create a heat map of student population/population density
            for areas so students can avoid crowded areas
        </li>
    </ul>
</section>

<section>
    <h3> Team Story </h3>
    <p>
        UofT students want to com.view the best spots on campus.
        They open Uni-verse to see the most highly rated spots.
    </p>
    <h3>User Stories</h3>
    <UL>
        <LI>
            Bobette wants to look for a new study spot since he is sick of Robarts library.
            He uses UniVerse to look for study spots frequented/pinned
            by other students other than the library.
            He is shown potential spots and chooses the ones that he is
            interested in or ones that are convenient for him.
        </LI>

        <LI>
            Bobe is an extremely picky, yet lazy student, he only wants to use a clean bathroom.
            To do that, he would need to check each bathroom on each floor of the building.
            Instead of walking up and down the stairs, he uses UniVerse
            to see which bathroom has the best reviews (is the cleanest).
            Bobe also wants to share his favorite study spot/bathroom with others,
            so he leaves a great review on UniVerse.
        </LI>
    </UL>
</section>

<section>
    <h3> Software Specifications </h3>
    <UL>
        <LI> Google Maps API: <br>
            This API will be used to show the map of the campus with the location of all the buildings
            Potentially, Google Map's Collections Feature could be used to “filter” buildings by type
        </LI>

        <LI> Youtube API: <br>
            This API will be used to display Youtube Videos in the JFrame,
            showcasing different parts of campus and its surroundings.
        </LI>

        <LI> Favourites <br>
            The Application will contain a tab containing default, and user-made lists.
            One potential feature will connect the Google Maps collection to the Favourites Tab.
        </LI>

        <LI> Buildings <br>
            Major Buildings should have their own pages, with relevant information about them.
        </LI>
    </UL>
</section>

<section>
    <h3> Proposed Entities </h3>
    <UL>
        <LI> Building: <br>
            <ul>
                <li> Library extends Building
                <li> Study Spots extends Building
                <li> Lecture Halls extends Building
            </ul>
        </LI>

        <LI> Room: <br>
            <ul>
                <li> Lecture Room extends Room
                <li> Tutorial Room extends Room
                <li> Bathroom extends Room
                <li> int stalls
                <li> String gender
            </ul>
        </LI>

        <LI> Person <br>
            <ul>
                <li> Staff extends Person
                <li> staffId
                <li> Student extends Person

            </ul>
        </LI>

        <LI> Reviews <br>
            Since people can leave reviews,
            we would want them to be formatted correctly
            and have all of the required information.
        </LI>

    </UL>
</section>

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