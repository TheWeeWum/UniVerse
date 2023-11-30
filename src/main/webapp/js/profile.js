document.addEventListener('DOMContentLoaded', function () {
    loadUserData();
});

function loadUserData() {
    const container = document.getElementById('reviewContainer');

    // Fetch additional building data
    fetch('user_data')
        .then(response => response.json())
        .then(userData => {
            renderUserSection(userData, container);
            renderFavouriteSection(userData, container);
            renderReviewsSection(userData, container);
        })
        .catch(error => console.error('Error fetching user data:', error));
}

function renderUserSection(userData, container) {
    const userSection = document.createElement('section');
    userSection.innerHTML = `
        <h2>User Information</h2>
        <p>Username: ${userData.username}</p>
        <p>User ID: ${userData.userId}</p>
        <!-- Add more user information here -->
    `;
    container.appendChild(userSection);
}

function renderFavouriteSection(userData, container) {
    const favouriteSection = document.createElement('section');
    const favouriteBuildingsList = userData.favouriteBuildings
        .map(building => `<li>${building}</li>`)
        .join('');
    const favouriteRoomsList = userData.favouriteRooms
        .map(room => `<li>${room}</li>`)
        .join('');

    favouriteSection.innerHTML = `
        <h2>Favourites</h2>
        <div>
            <h3>Favourite Buildings</h3>
            <ul>${favouriteBuildingsList}</ul>
        </div>
        <div>
            <h3>Favourite Rooms</h3>
            <ul>${favouriteRoomsList}</ul>
        </div>
    `;
    container.appendChild(favouriteSection);
}

function renderReviewsSection(userData, container) {
    const reviewsSection = document.createElement('section');
    const reviewsList = userData.reviews
        .map(review => `
            <div>
                <h3>${review.title}</h3>
                <p>${review.content}</p>
                <p>Rating: ${review.rating}</p>
            </div>
        `)
        .join('');

    reviewsSection.innerHTML = `
        <h2>User Reviews</h2>
        ${reviewsList}
    `;
    container.appendChild(reviewsSection);
}
