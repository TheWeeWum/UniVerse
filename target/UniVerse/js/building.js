document.addEventListener('DOMContentLoaded', function() { loadBuilding(); });

// let buildingsLoaded = 0;

function loadBuilding() {
    const container1 = document.getElementById('title');
    const container2 = document.getElementById('buildingsContainer');

    // Fetch building info
    fetch('building_info')
        .then(response => response.json())
        .then(buildingData => {
            // const nextBuildings = buildingData.slice(buildingsLoaded, buildingsLoaded + 7);
            const building = buildingData[0]

            // Load additional buildings
            // nextBuildings.forEach(buildingInfo => {
            building(buildingInfo => {
                const newSection = document.createElement('section');
                newSection.textContent = buildingInfo.name;
                container2.appendChild(newSection);
            });

            // });

            // buildingsLoaded += nextBuildings.length;

            // Show/hide the "Load More" button based on whether there are more buildings to load
            // if (buildingsLoaded >= buildingData.length) {
            //     document.getElementById('loadMoreButton').style.display = 'none';
            // }
        })
        .catch(error => console.error('Error fetching building data:', error));
}
