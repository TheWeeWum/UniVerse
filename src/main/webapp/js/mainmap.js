function initMap() {
    var map = new google.maps.Map(document.getElementById('map'), {
        center: { lat: 43.66234588623047, lng: -79.3955307006836 },
        zoom: 16
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
                    var address = markerInfo.address.street.split(' ');
                    var addr = "";
                    for (let i = 0; i < address.length; i++) {
                        addr += address[i] + "+";
                    }

                    var reviewstr = "";
                    console.log(markerInfo.reviews)
                    for (let i = 0; i < markerInfo.reviews.length; i++) {
                        var review = markerInfo.reviews[i];
                        console.log(review);
                        reviewstr +=
                            'Username: ' + review.user.username + '<br>' +
                            'Date: ' + review.date + '<br>' +
                            'Title: ' + review.title + '<br>' +
                            'Rating: ' + review.rating + '<br>' +
                            'Comment: ' + review.content + '<br><br>';
                    }


                    var eventstr = ""
                    for (let i = 0; i < markerInfo.events.length; i++) {
                        var event = markerInfo.events[i];
                        if (event.room !== '') {
                            eventstr +=
                                'Event name: ' + event.name + '<br>' +
                                'Room: ' + event.room + '<br>' +
                                'Organizer: ' + event.organizer + '<br>' +
                                'Event date: ' + event.date + '<br><br>';
                        } else {
                            eventstr +=
                                'Event name: ' + event.name + '<br>' +
                                'Organizer: ' + event.organizer + '<br>' +
                                'Event date: ' + event.date + '<br><br>';
                        }
                    }

                    // Update the side panel content when a marker is clicked
                    sidePanel.innerHTML = '<h1>' + markerInfo.name + '</h1>' +
                        '<h2> Building Information: </h2>' +
                        '<p> Building Code: ' + markerInfo.code + '</p>' +
                        '<p> Campus: ' + markerInfo.campus + '</p>' +
                        '<p> ' +
                        'Address: ' +
                        markerInfo.address.street + '<br>' +
                        markerInfo.address.city + ', ' +
                        markerInfo.address.province + ', ' +
                        markerInfo.address.country + ', ' +
                        markerInfo.address.postal +
                        '</p>' +
                        '<p> ' +
                        'Lat ' + markerInfo.lat + ', ' +
                        'Lng ' + markerInfo.lng +
                        '</p>' +
                        '<p>GoogleMaps: <a href=https://www.google.com/maps/search/?api=1&query=' + addr + '>Link to GoogleMaps</a></p>' +
                        '<h2><a href=reviews?buildingCode=' + markerInfo.code + '>Reviews:</a><br></h2><p>' + reviewstr + '</p>' +
                        '<h2><a href=events?buildingCode=' + markerInfo.code + '>Events:</a><br></h2><p>' + eventstr + '</p>' +
                        '';
                });
            });
        })
        .catch(error => console.error('Error fetching marker data:', error));
}