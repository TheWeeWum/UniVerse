
console.log("Hello, World!");
// Fetch marker data from the servlet using AJAX
fetch('buildings_list')
    .then(response => response.json())
    .then(buildingData => {
        // Create markers based on the retrieved data
        buildingData.forEach(function (buildingInfo) {
            // Create a new section element
            var newSection = document.createElement('section');

            // Set the content of the section
            newSection.textContent = buildingInfo.name;

            // Append the new section to the container
            document.getElementById('buildings list').appendChild(newSection);

            // var marker = new google.maps.Marker({
            //     position: { lat: markerInfo.lat, lng: markerInfo.lng },
            //     map: map,
            //     title: markerInfo.title
            // });
        });
    })
    .catch(error => console.error('Error fetching marker data:', error));