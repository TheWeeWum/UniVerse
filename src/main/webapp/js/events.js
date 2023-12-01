document.addEventListener('DOMContentLoaded', function() {
    loadMoreEvents();
});

let buildingsLoaded = 0;

function loadMoreEvents() {
    const container = document.getElementById('eventsContainer');

    // Fetch additional building data
    fetch('building_events')
        .then(response => response.json())
        .then(eventData => {
            console.log(eventData)
            const nextEvents = eventData.slice(buildingsLoaded, buildingsLoaded + 7);

            // Load additional buildings
            nextEvents.forEach(eventInfo => {
                const newSection = document.createElement('section');
                newSection.innerHTML =
                    "<h2>" + eventInfo.name + "</h2><br>" +
                    "<p>Organizer: " + eventInfo.organizer + "</p><br>" +
                    "<p>Location: " + eventInfo.location + "</p><br>" +
                    "<p>Date: " + eventInfo.date + "</p><br>";

                container.appendChild(newSection);
            });

            buildingsLoaded += nextEvents.length;

            // Show/hide the "Load More" button based on whether there are more buildings to load
            if (buildingsLoaded >= eventData.length) {
                document.getElementById('loadMoreButton').style.display = 'none';
            }
        })
        .catch(error => console.error('Error fetching building data:', error));
}
