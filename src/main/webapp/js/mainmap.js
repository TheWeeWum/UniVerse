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
                    title: markerInfo.name
                });

                marker.addListener('click', function () {
                    document.getElementById('map').style.width = "70%";
                    document.getElementById('sidePanel').style.width = "30%";
                    // Update the side panel content when a marker is clicked
                    sidePanel.innerHTML = '<h2>' + markerInfo.name + '</h2>' +
                        '<h1> Building Information: </h1>' +
                        '<p>' +
                        'Building Code: ' + markerInfo.code + '<br>' +
                        'Campus: ' + markerInfo.campus + '<br>' +
                        'Street: ' + markerInfo.street + '<br>' +
                        'City: ' + markerInfo.city + '<br>' +
                        'Province: ' + markerInfo.province + '<br>' +
                        'Country: ' + markerInfo.country + '<br>' +
                        'Postal: ' + markerInfo.postal + '<br>' +
                        'Lat ' + markerInfo.lat + ', ' +
                        'Lng ' + markerInfo.lng + '<br>' +
                        '</p>';
                });
            });
        })
        .catch(error => console.error('Error fetching marker data:', error));
}