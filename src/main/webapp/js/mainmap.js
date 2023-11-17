function initMap() {
    var map = new google.maps.Map(document.getElementById('map'), {
        center: { lat: 43.66234588623047, lng: -79.3955307006836 },
        zoom: 14
    });

    // Fetch marker data from the servlet using AJAX
    fetch('markers')
        .then(response => response.json())
        .then(markerData => {
            // Create markers based on the retrieved data
            markerData.forEach(function (markerInfo) {
                var marker = new google.maps.Marker({
                    position: { lat: markerInfo.lat, lng: markerInfo.lng },
                    map: map,
                    title: markerInfo.title
                });

                marker.addListener('click', function () {
                    document.getElementById('map').style.width = "70%";
                    document.getElementById('sidePanel').style.width = "30%";
                    // Update the side panel content when a marker is clicked
                    sidePanel.innerHTML = '<h2>' + markerInfo.title + '</h2>' +
                        '<p>Marker Information: Lat ' + markerInfo.lat + ', Lng ' + markerInfo.lng + '</p>';
                });
            });
        })
        .catch(error => console.error('Error fetching marker data:', error));
}