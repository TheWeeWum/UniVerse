document.addEventListener('DOMContentLoaded', function() {
    loadMoreReviews();
});

function getColorForRating(rating) {
    // Define a color scale based on the rating values
    if (rating >= 4) {
        return 'green'; // Higher ratings are green
    } else if (rating >= 2.5) {
        return 'orange'; // Moderate ratings are orange
    } else {
        return 'red'; // Lower ratings are red
    }
}

let reviewsLoaded = 0;

function loadMoreReviews() {
    const container1 = document.getElementById('title');
    fetch('building_info')
        .then(response => response.json())
        .then(buildingData => {
            const buildingInfo = buildingData[0]
            var text = "Reviews for " + buildingInfo.name;
            container1.append(text)

            var headerElement = document.getElementById('title')
            headerElement.style.fontSize = '32px'
            headerElement.style.fontWeight = 'bold';
        })
        .catch(error => console.error('Error fetching building data:', error));


    const container2 = document.getElementById('reviewsContainer');
    // Fetch additional review data
    fetch('building_reviews')
        .then(response => response.json())
        .then(reviewData => {
            console.log(reviewData)
            const nextReviews = reviewData.slice(reviewsLoaded, reviewsLoaded + 7);

            // Load additional reviews
            nextReviews.forEach(reviewInfo => {
                const newSection = document.createElement('div');
                newSection.classList.add('reviewSection');

                // Get the color for the rating
                const ratingColor = getColorForRating(reviewInfo.rating);

                newSection.innerHTML = `
                        <div class="reviewHeader">👤${reviewInfo.user.username}</div>
                        <div class="reviewDate">${reviewInfo.date}</div>
                        <div class="reviewRating" style="color: ${ratingColor};">Rating: ${reviewInfo.rating}</div>
                        <div class="reviewTitle">${reviewInfo.title}</div>
                        <div class="reviewContent">${reviewInfo.content}</div>
                    `;
                container2.appendChild(newSection);
            });

            reviewsLoaded += nextReviews.length;

            // Show/hide the "Load More" button based on whether there are more reviews to load
            if (reviewsLoaded >= reviewData.length) {
                document.getElementById('loadMoreButton').style.display = 'none';
            }
        })
        .catch(error => console.error('Error fetching review data:', error));
}