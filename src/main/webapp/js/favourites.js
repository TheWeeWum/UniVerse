document.addEventListener('DOMContentLoaded', function() { getFavourites(); });


function getFavourites() {
    const container = document.getElementById('favouriteBuildingsContainer');

    // Fetch additional building data
    fetch('favourites_info')
        .then(response => response.json())
        .then(favouritesData => {

            // Load additional buildings
            favouritesData.forEach(favouriteData => {
                var text = favouriteData.name;
                const newSection = document.createElement('section');
                newSection.innerHTML = text;
                container.appendChild(newSection);
            });
        })
        .catch(error => console.error('Error fetching favourites data:', error));
}
