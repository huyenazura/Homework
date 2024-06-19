document.addEventListener('DOMContentLoaded', function () {
    const newsGroups = document.querySelectorAll('.news-group');
    const dots = document.querySelectorAll('.dot');
    let currentIndex = 0;

    dots.forEach((dot, index) => {
        dot.addEventListener('click', () => {
            currentIndex = index;
            updateSlider();
        });
    });

    function updateSlider() {
        const offset = currentIndex * -100;
        newsGroups.forEach((group) => {
            group.style.transform = `translateX(${offset}%)`;
        });

        dots.forEach((dot, index) => {
            if (index === currentIndex) {
                dot.classList.add('active');
            } else {
                dot.classList.remove('active');
            }
        });
    }
});
