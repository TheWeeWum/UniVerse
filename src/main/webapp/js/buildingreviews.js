document.addEventListener('DOMContentLoaded', function() {
    loadMoreReviews();
});

let reviewsLoaded = 0;

function loadMoreReviews() {
    const container = document.getElementById('reviewsContainer');

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

                newSection.innerHTML = `
                        <div class="reviewHeader">${reviewInfo.user.username}</div>
                        <div class="reviewDate">${reviewInfo.date}</div>
                        <div class="reviewRating">Rating: ${reviewInfo.rating}</div>
                        <div class="reviewTitle">${reviewInfo.title}</div>
                        <div class="reviewContent">${reviewInfo.content}</div>
                    `;
                container.appendChild(newSection);
            });

            reviewsLoaded += nextReviews.length;

            // Show/hide the "Load More" button based on whether there are more reviews to load
            if (reviewsLoaded >= reviewData.length) {
                document.getElementById('loadMoreButton').style.display = 'none';
            }
        })
        .catch(error => console.error('Error fetching review data:', error));
}