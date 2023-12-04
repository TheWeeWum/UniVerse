document.addEventListener('DOMContentLoaded', function () {
    loadUserData();
});

function loadUserData() {
    const container = document.getElementById('userContainer');

    fetch('user_data')
        .then(response => response.json())
        .then(userData => {
            console.log(userData)
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
        ` + // <p>User ID: ${userData.userId}</p>
          <!-- Add more user information here -->
        `
    `;
    container.appendChild(userSection);
}

function renderFavouriteSection(userData, container) {
    const favouriteSection = document.createElement('section');

    const favouriteBuildingsList = document.createElement('ul');
    for (const building of userData.favouriteBuildings) {
        const listItem = document.createElement('li');
        listItem.textContent = building;
        favouriteBuildingsList.appendChild(listItem);
    }

    const favouriteRoomsList = document.createElement('ul');
    for (const room of userData.favouriteRooms) {
        const listItem = document.createElement('li');
        listItem.textContent = room;
        favouriteRoomsList.appendChild(listItem);
    }

    favouriteSection.innerHTML = `
        <h2>Favourites</h2>
        <div>
            <h3>Favourite Buildings</h3>
        </div>
        <div>
            <h3>Favourite Rooms</h3>
        </div>
    `;
    favouriteSection.querySelector('div:nth-child(1)').appendChild(favouriteBuildingsList);
    favouriteSection.querySelector('div:nth-child(2)').appendChild(favouriteRoomsList);

    container.appendChild(favouriteSection);
}

function renderReviewsSection(userData, container) {
    const reviewsSection = document.createElement('section');

    const reviewsList = document.createElement('div');
    for (const review of userData.reviews) {
        const newSection = document.createElement('div');
        newSection.classList.add('reviewSection');

        // Get the color for the rating
        const ratingColor = getColorForRating(review.rating);

        newSection.innerHTML = `
            <div class="reviewHeader">👤${review.user.username}</div>
            <div class="reviewDate">${review.date}</div>
            <div class="reviewRating" style="color: ${ratingColor};">Rating: ${review.rating}</div>
            <div class="reviewTitle">${review.title}</div>
            <div class="reviewContent">${review.content}</div>
        `;
        reviewsList.appendChild(newSection);
    }

    reviewsSection.innerHTML = `
        <h2>User Reviews</h2>
    `;
    reviewsSection.appendChild(reviewsList);

    container.appendChild(reviewsSection);
}

// Add the getColorForRating function and reviewsLoaded variable here as well
