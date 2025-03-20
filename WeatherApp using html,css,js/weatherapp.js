document.addEventListener('DOMContentLoaded', () => {
     const container = document.querySelector('.container'); 
     const searchBtn = document.querySelector('.search-btn');
      const locationInput = document.querySelector('.location-input');
       const weatherBox = document.querySelector('.weather-box');
        const weatherDetails = document.querySelector('.weather-details'); 
        const notFound = document.querySelector('.not-found');
         const cityHide = document.querySelector('.city-hide');
          searchBtn.addEventListener('click', () => {
             const APIkey = '98740f4ebc0d63bc0f8ba70090e5a091'; 
             const city = locationInput.value.trim();
             
    if (city === '')
         return;
 fetch(`https://api.openweathermap.org/data/2.5/weather?q=${city}&units=metric&appid=${APIkey}`) 
 .then(response => response.json()) 
 .then(json => { 
    if (json.cod === '404') { 
        cityHide.style.display = 'block';
         weatherBox.style.display = 'none';
     weatherDetails.style.display = 'none';
      notFound.style.display = 'block';
       return;
     }
      cityHide.style.display = 'none';
       weatherBox.style.display = 'block';
        weatherDetails.style.display = 'flex';
         notFound.style.display = 'none';
          const image = document.querySelector('.weather-box img');
           const temperature = document.querySelector('.temperature');
     const description = document.querySelector('.description'); 
     const humidity = document.querySelector('.humidity span');
      const wind = document.querySelector('.wind span'); // Update weather image and details
       switch (json.weather[0].main) {
         case 'Clear': 
         image.src = 'clear.png'; 
         break; 
         case 'Rain': 
         image.src = 'rain.png'; 
         break;
          case 'Snow':
             image.src = 'snow.png'; 
             break; 
             case 'Clouds':
                 image.src = 'cloud.png';
                  break; 
            case 'Mist':
                 image.src = 'mist.png'; 
                 break;
                  case 'Haze':
                     image.src = 'haze.png'; 
                     break; 
                     default:
                         image.src = ''; 
                         image.style.display = 'none';
                         }
         temperature.innerHTML = `${parseInt(json.main.temp)}<span>°C</span>`; 
         description.textContent = json.weather[0].description;
          humidity.textContent = `${json.main.humidity}%`; 
          wind.textContent = `${parseInt(json.wind.speed)} km/h`;
         });
         });
         });
