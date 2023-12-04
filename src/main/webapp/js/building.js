document.addEventListener('DOMContentLoaded', function() { loadBuilding(); });

function getColorForRating(rating) {
    // Define a color scale based on the rating values
    if (rating >= 4) {
        return 'green'; // Higher ratings are green
    } else if (rating >= 2.5) {
        return 'orange'; // Moderate ratings are orange
    } else {
        return 'red'; // Lower ratings are red
    }
}

function loadBuilding() {
    const container1 = document.getElementById('title');
    fetch('building_info')
        .then(response => response.json())
        .then(buildingData => {
            var text = "\n🏫 " + buildingData.name + " 🏫\n";
            container1.append(text)

            var headerElement = document.getElementById('title')
            headerElement.style.fontSize = '32px'
            headerElement.style.fontWeight = 'bold';
        })
        .catch(error => console.error('Error fetching building data:', error));


    const container2 = document.getElementById('buildingContainer');
    // Fetch building data
    fetch('building_info')
        .then(response => response.json())
        .then(buildingData => {
            console.log(buildingData)
            var addressText =
                buildingData.address.street + ', ' +
                buildingData.address.city + ', ' +
                buildingData.address.province + ', ' +
                buildingData.address.country + ', ' +
                buildingData.address.postal
            ;

            var text =
                "Name: " + buildingData.name +
                "\n\nBuilding Code: " + buildingData.code +
                "\n\nAddress: " + addressText +
                "\n\nCampus: " + buildingData.campus;
            const newSection = document.createElement('section');
            newSection.innerText = text;
            container2.appendChild(newSection);

        })
        .catch(error => console.error('Error fetching building data:', error));


    const container4 = document.getElementById('map');
    container4.style.width = '839px'
    container4.style.outline = '2px solid grey'
    fetch('building_info')
        .then(response => response.json())
        .then(buildingData => {
            const lat = Number(buildingData.lat);
            const lng = Number(buildingData.lng);

            const container4Element1 = document.createElement('section');

            var map = new window.google.maps.Map(document.getElementById('map'), {
                center: { lat: lat, lng: lng },
                zoom: 18
            });
            // map.style.zIndex = '5';

            container4Element1.append(map);
            // Adjust size
            container4Element1.style.height = '300px'; // Set any height you prefer

            // Function to centre the container horizontally
            function centerContainer4() {
                var windowWidth = document.body.scrollWidth;

                var container4Width = container4.offsetWidth;

                // Calculate the center position
                var centerX = (windowWidth - container4Width) / 2;

                // Set the container position
                container4.style.left = centerX + 'px';
                container4.style.zIndex = 0;
            }

            // Function to add a marker to map
            function addMarker() {
                // Coordinates for the new marker
                var markerPosition = { lat: lat, lng: lng }; // Example: San Francisco, CA

                // Create a new marker and set its position on the existing map
                var marker = new google.maps.Marker({
                    position: markerPosition,
                    map: map,
                });
            }

            // Call a function to add the marker
            addMarker();

            // Call the function whenever the window is resized
            window.addEventListener('resize', centerContainer4);

            container4.appendChild(container4Element1);

            // Call the function initially
            centerContainer4();

            const container5 = document.getElementById('events');
            const container5Element = document.createElement('section');
            let eventText = '<h2>Events: </h2><ul>';
            buildingData.events.forEach(function (eventInfo) {
                eventText +=
                    `<li>
                    <h3>${eventInfo.name} </h3>
                    <p>Organizer ${eventInfo.organizer} </p>
                    <p>Location ${eventInfo.location.name} </p>
                    <p>Date ${eventInfo.date} </p>
                    </li>`
            });
            eventText += '</ul>';

            container5Element.innerHTML = eventText;
            container5.appendChild(container5Element);

            const container6 = document.getElementById('reviews');
            const container6Element = document.createElement('section');
            let reivewText = '<h2>Reviews: </h2><ul>';
            buildingData.reviews.forEach(function (reviewInfo) {
                const ratingColor = getColorForRating(reviewInfo.rating);
                reivewText +=
                    `<li>
                        <div class="reviewHeader">👤${reviewInfo.username}</div>
                        <div class="reviewDate">${reviewInfo.date}</div>
                        <div class="reviewRating" style="color: ${ratingColor};">Rating: ${reviewInfo.rating}</div>
                        <div class="reviewTitle">${reviewInfo.title}</div>
                        <div class="reviewContent">${reviewInfo.content}</div>
                    </li>`
            });
            reivewText += '</ul>';

            container6Element.innerHTML = reivewText;
            container6.appendChild(container6Element);

        })
        .catch(error => console.error('Error fetching building data:', error));

}

document.addEventListener("DOMContentLoaded", function () {
    var favouritesButton = document.getElementById("favouritesButton");
    // var isFavourited = false;

    favouritesButton.addEventListener("click", function() {

        // var isFavourited = true;

        // Check if the button is already clicked
        //var isClicked = favouritesButton.classList.contains("clicked");

        favouritesButton.value = '💞💖💕💗 Favourited 💗💕💖💞';
        favouritesButton.style.backgroundColor = "#fa93af";
        favouritesButton.style.boxShadow = "deeppink";

        // // Update the text based on the button's state
        // favouritesButton.value = '💞💖💕💗 Favourited 💗💕💖💞';
        // favouritesButton.style.backgroundColor = "#fa93af";
        // favouritesButton.style.boxShadow = "deeppink";

        // Toggle the "clicked" class to update the appearance
        //favouritesButton.classList.toggle("clicked");

        // favouritesButton.classList.add('favourited');
        // favouritesButton.textContent = '💞💖💕💗 Favourited 💗💕💖💞';

        // if (isFavourited) {
        //     favouritesButton.classList.add('favourited');
        //     favouritesButton.textContent = '💞💖💕💗 Favourited 💗💕💖💞';
        //     // Perform additional actions when favourited
        // }
        // else {
        //     favouritesButton.classList.remove('favourited');
        //     favouritesButton.textContent = '🤍 Add to Favourites 🤍';
        //     // Perform additional actions when not favourited
        // }
    });

    // Add event listener for mouseover (hover)
    // favouritesButton.addEventListener("mouseover", function() {
    //     // Change the text when hovered
    //     if (isFavourited) {
    //         favouritesButton.textContent = '💔 Remove from Favourites 💔';
    //         // Perform additional actions when favourited
    //     }
    // });
    //
    // // Add event listener for mouseout (when the mouse leaves)
    // favouritesButton.addEventListener("mouseout", function() {
    //     // Restore the original text
    //     if (isFavourited) {
    //         favouritesButton.textContent = '💞💖💕💗 Favourited 💗💕💖💞';
    //         // Perform additional actions when favourited
    //     }
    // });
});
