<!-- Add this in your HTML where you want to display reviews -->
<div id="reviewsContainer"></div>
document.addEventListener('DOMContentLoaded', function() {
    loadReviews();
});

function loadReviews() {
    const reviewsContainer = document.getElementById('reviewsContainer');

    // Fetch reviews data
    fetch('reviews_info') // Update this with the endpoint to fetch reviews
        .then(response => response.json())
        .then(reviewsData => {
            // Check if there are reviews to display
            if (reviewsData.length > 0) {
                // Create a list to hold reviews
                const reviewsList = document.createElement('ul');

                // Loop through reviews and create list items
                reviewsData.forEach(review => {
                    const listItem = document.createElement('li');

                    // Display review information
                    listItem.innerHTML = `
                        <strong>${review.title}</strong><br>
                        ${review.content}<br>
                        <small>${formatDate(review.date)}</small>
                    `;

                    // Add a click event listener to expand the review
                    listItem.addEventListener('click', function() {
                        // Toggle the 'expanded' class to show/hide the full review
                        listItem.classList.toggle('expanded');
                    });

                    reviewsList.appendChild(listItem);
                });

                reviewsContainer.appendChild(reviewsList);
            } else {
                reviewsContainer.innerHTML = 'No reviews available.';
            }
        })
        .catch(error => console.error('Error fetching reviews data:', error));
}

// Function to format date
function formatDate(dateString) {
    const options = { year: 'numeric', month: 'long', day: 'numeric', hour: 'numeric', minute: 'numeric', second: 'numeric' };
    const formattedDate = new Date(dateString).toLocaleDateString('en-US', options);
    return formattedDate;
}
