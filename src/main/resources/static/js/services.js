app.service('WeatherService', function($resource, $http) {

	var city;
	var country;

	this.saveWeather = function(city, country) {
		this.city = city;
		this.country = country;
	}

	this.getWeather = function(city, country) {
		return $resource('http://api.openweathermap.org/data/2.5/weather?q='
				+ city + ',' + country
				+ '&appid=404101a11a4fe3ef3666d700746a52d8');
	
	}




	this.translate = function(engWeather) {
		var plWeather;
		if (engWeather === "clear sky")
			plWeather = "czyste niebo";
		else if (engWeather === "few clouds")
			plWeather = "małe zachmurzenie";
		else if (engWeather === "few clouds")
			plWeather = "rozproszone chmury";
		else if (engWeather === "broken clouds")
			plWeather = "zachmurzenie umiarkowane";
		else if (engWeather === "shower rain")
			plWeather = "deszcz przelotny";
		else if (engWeather === "rain")
			plWeather = "deszcz";
		else if (engWeather === "thunderstorm")
			plWeather = "burza";
		else if (engWeather === "snow")
			plWeather = "śnieg";
		else if (engWeather === "overcast clouds")
			plWeather = "znaczne zachmurzenie";
		else if (engWeather === "mist")
			plWeather = "mgła";
		else
			plWeather = engWeather;

		return plWeather;
	}

});

app.service('CommentService', function($http) {
	this.getComments = function() {
		
	}

});

