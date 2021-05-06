const successCallback = (position) => {
    const latitude = position.coords.latitude;
    const longitude = position.coords.longitude;

    const request = new XMLHttpRequest();
    request.open("GET", "https://api.openweathermap.org/data/2.5/onecall?lat=" + latitude + "&lon=" + longitude + "&units=imperial&appid=0edb866fd31c462e79250fe1185a0d06");
    request.send();
    request.onload = () => {
        const response = JSON.parse(request.response);
        // document.getElementById("weather")[0].appendChild(response.daily[0].clouds);
        console.log(response);

        let currentWeather = {

            temperature:response.daily[0].temp.day,
            weather:response.daily[0].weather[0].main,
            icon:response.daily[0].weather[0].icon
            



        };

        document.cookie = JSON.stringify(currentWeather);

        let parsedCookie = JSON.parse(document.cookie);





        let i = 0;
        var div = document.getElementById("weather");
        while (i < response.daily.length) {
            let icon = response.daily[i].weather[0].icon;
            div.innerHTML += '<div class="displayWeather"><img src="http://openweathermap.org/img/wn/' + icon + '@2x.png"/>' + `<p>Conditions: ` + response.daily[i].weather[0].main + `</p> <p>` + " Temperature: " + response.daily[i].temp.day + `</p></div>`;

            i++;
        }


    }


};

const errorCallback = (position) => {
    document.getElementById("zipCode").style.display="flex";

};

navigator.geolocation.getCurrentPosition(successCallback, errorCallback);
const zipButton = document.getElementById("zipButton");
zipButton.addEventListener("click", zipButtonFiring)

function zipButtonFiring() {

    const zipCode = document.getElementById("zip").value;
    const request = new XMLHttpRequest();
    request.open("GET", "https://api.openweathermap.org/data/2.5/weather?zip=" + zipCode + ",US&appid=0edb866fd31c462e79250fe1185a0d06");
    request.send();
    request.onload = () => {
        const response = JSON.parse(request.response);
        const lat = response.coord.lat;
        const lon = response.coord.lon;


        const requestZip = new XMLHttpRequest();
        requestZip.open("GET", "https://api.openweathermap.org/data/2.5/onecall?lat=" + lat + "&lon=" + lon + "&units=imperial&appid=0edb866fd31c462e79250fe1185a0d06")
        requestZip.send();
        requestZip.onload = () => {

            const zipResponse = JSON.parse(requestZip.response);
            let currentWeather = {

                temperature:zipResponse.daily[0].temp.day,
                weather:zipResponse.daily[0].weather[0].main,
                icon:zipResponse.daily[0].weather[0].icon




            };

            document.cookie = JSON.stringify(currentWeather);
            // document.getElementById("weather")[0].appendChild(response.daily[0].clouds);
            console.log(zipResponse);
            let i = 0;
            var div = document.getElementById("weather");
            while (i < zipResponse.daily.length) {
                let icon = zipResponse.daily[i].weather[0].icon;
                div.innerHTML += '<div class="displayWeather"><img src="http://openweathermap.org/img/wn/' + icon + '@2x.png"/>' + `<p>Conditions: ` + zipResponse.daily[i].weather[0].main + `</p> <p>` + " Temperature: " + zipResponse.daily[i].temp.day + `</p></div>`;

                i++;
            }


        };

    };

}
;