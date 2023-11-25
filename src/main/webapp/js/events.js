document.addEventListener('DOMContentLoaded', function() {
    loadMoreEvents();
});

let buildingsLoaded = 0;

function loadMoreEvents() {
    const container = document.getElementById('eventsContainer');

    // Fetch additional building data
    fetch('building_events')
        .then(response => response.json())
        .then(buildingData => {
            console.log(buildingData)
            const nextBuildings = buildingData.slice(buildingsLoaded, buildingsLoaded + 7);

            // Load additional buildings
            nextBuildings.forEach(buildingInfo => {
                const newSection = document.createElement('section');
                newSection.textContent = buildingInfo.name;
                container.appendChild(newSection);
            });

            buildingsLoaded += nextBuildings.length;

            // Show/hide the "Load More" button based on whether there are more buildings to load
            if (buildingsLoaded >= buildingData.length) {
                document.getElementById('loadMoreButton').style.display = 'none';
            }
        })
        .catch(error => console.error('Error fetching building data:', error));
}
