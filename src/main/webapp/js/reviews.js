document.addEventListener('DOMContentLoaded', function() {
    loadReviews();
});

function loadReviews() {
    const reviewsContainer = document.getElementById('reviewsContainer');

    // Fetch reviews data
    fetch('review') // Update this with the endpoint to fetch reviews
        .then(response => response.json())
        .then(reviewsData => {
            console.log(reviewsData)
            const reviewsSection = document.createElement('section');
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

                reviewsSection.appendChild(reviewsList);
                reviewsContainer.appendChild(reviewsSection);
            } else {
                reviewsSection.innerHTML = '<p>No reviews available.</p>';
                reviewsContainer.appendChild(reviewsSection);
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
