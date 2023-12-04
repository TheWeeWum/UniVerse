document.addEventListener('DOMContentLoaded', function() { loadMoreBuildings(); });

let buildingsLoaded = 0;

function loadMoreBuildings() {
    const container = document.getElementById('buildingsContainer');

    // Fetch additional building data
    fetch('buildings_list')
        .then(response => response.json())
        .then(buildingData => {
            console.log(buildingData)
            const nextBuildings = buildingData.slice(buildingsLoaded, buildingsLoaded + 7);

            // Load additional buildings
            nextBuildings.forEach(buildingInfo => {
                var text = '' + '<h3><a href=building?buildingCode=' + buildingInfo.code + '>' + buildingInfo.name + '</a></h3>'

                const newSection = document.createElement('section');
                newSection.innerHTML = text;
                // newSection.style.background = 'pink';
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
