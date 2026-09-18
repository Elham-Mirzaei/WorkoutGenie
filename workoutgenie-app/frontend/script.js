document.getElementById('workout-form').addEventListener('submit', async function (event) {
    event.preventDefault(); // stop the page from reloading

    const requestData = {
        age: Number(document.getElementById('age').value),
        gender: document.getElementById('gender').value,
        weight: Number(document.getElementById('weight').value),
        height: Number(document.getElementById('height').value),
        goal: document.getElementById('goal').value,
        experience: document.getElementById('experience').value,
        availableDays: Number(document.getElementById('availableDays').value)
    };

    try {
        const response = await fetch('http://localhost:8080/recommend', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(requestData)
        });

        const data = await response.json();

        const planDescriptions = {
            FULL_BODY_3X: "Full Body Workout, 3 Days per Week",
            UPPER_LOWER_4X: "Upper/Lower Split, 4 Days per Week",
            PUSH_PULL_LEGS: "Push/Pull/Legs Split, 5+ Days per Week",
            HIIT_FAT_LOSS: "HIIT Fat Loss Program"
        };
        const friendlyPlan = planDescriptions[data.planType] || data.planType;

        document.getElementById('result').innerText =
            'Your recommended plan: ' + friendlyPlan;


    } catch (error) {
        document.getElementById('result').innerText =
            'Error: could not reach the server.';
        console.error(error);
    }
});