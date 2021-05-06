console.log(document.cookie);
let currentWeather = JSON.parse(document.cookie);

console.log(currentWeather.weather);


// let outfitWeather = document.getElementById("weatherCheck").getAttribute("name");
document.getElementById("weather").innerHTML = `


 <div class="displayWeatherSingle">

<img src="http://openweathermap.org/img/wn/` + currentWeather.icon + '@2x.png"/> <br><span>Conditions: ' + currentWeather.weather + `</span> <br> <span>Temperature: ` + currentWeather.temperature + `</span> 

</div>`;


for (var element of document.getElementsByClassName("weatherCheck")) {
    if (element.getAttribute("name") == currentWeather.weather) {

        element.style.display = "block";
    }
}

