document.addEventListener('DOMContentLoaded', function() {
    movePlanetRandomly();
});

function movePlanetRandomly() {
    const planet = document.getElementById('planet');
    const maxWidth = window.innerWidth - planet.clientWidth;
    const maxHeight = window.innerHeight - planet.clientHeight;

    function getRandomPosition() {
        const randomX = Math.floor(Math.random() * maxWidth);
        const randomY = Math.floor(Math.random() * maxHeight);
        return { left: randomX, top: randomY };
    }

    function updatePlanetPosition() {
        const newPosition = getRandomPosition();
        planet.style.left = `${newPosition.left}px`;
        planet.style.top = `${newPosition.top}px`;
    }

    // Update the planet's position every 5 seconds (adjust as needed)
    setInterval(updatePlanetPosition, 5000);
}