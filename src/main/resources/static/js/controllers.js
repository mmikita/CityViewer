app.controller('WeatherController', function($scope, $resource) {

	var vm = this;
	vm.getJsonWeather = function(city, country) {
		return $resource('http://api.openweathermap.org/data/2.5/weather?q='
				+ city + ',' + country
				+ '&appid=404101a11a4fe3ef3666d700746a52d8');
	}

	vm.getWeather = function(city, country) {
		var weather = vm.getJsonWeather(city, country);
		weather.get(function(data) {
			$scope.pogoda = data;
		});
	}
});

app.controller('TokyoCtrl', function($scope, WeatherService, $timeout, $http) {
	var vm = this;
	var vm = this;
	vm.clock = "loading clock..."; // initialise the time variable
	vm.tickInterval = 1000 // ms
	var tick = function() {
		vm.clock = moment().utcOffset(9).format('LTS'); // get the current time
		$timeout(tick, $scope.tickInterval); // reset the timer
	}
	$timeout(tick, $scope.tickInterval);

	vm.weather = WeatherService.getWeather('Tokyo', 'JP');
	vm.weather.get(function(data) {
		vm.pogoda = data;
		vm.niebo = WeatherService.translate(vm.pogoda.weather[0].description);

	});
	// get Weather Settings</>
	// Comments Settings <>
	var getComments = function() {
		$http.get('http://localhost:8181/tokyoinfo').then(successCallback,
				errorCallback);
		function successCallback(response) {
			console.log(response);
			$scope.cc = response.data;
		}
		function errorCallback(error) {
		}

	}

	getComments();

	// Comments Settings </>
	vm.putComment = function(text, name, id) {
		$http.put(
				"http://localhost:8181/putTokyoComment/" + text + "/" + name + "/"
						+ id).then(successCallback, errorCallback);
		function successCallback(response) {
			getComments();

		}
		function errorCallback(error) {
		}

	}
	vm.putNewComment = function(text, name) {
		$http.put("http://localhost:8181/putTokyoNewComment/" + text + "/" + name)
				.then(successCallback, errorCallback);
		function successCallback(response) {
			getComments();

		}
		function errorCallback(error) {
		}

	}

});
app.controller('BialyCtrl', function($scope, WeatherService, $timeout, $http) {
	// Clock settings<>
	var vm = this;
	vm.clock = "loading clock..."; // initialise the time variable
	vm.tickInterval = 1000 // ms
	var tick = function() {
		vm.clock = moment().utcOffset(2).format('LTS'); // get the current time
		$timeout(tick, $scope.tickInterval); // reset the timer
	}
	$timeout(tick, 1000);
	// Clock settings</>
	// get Weather Settings
	vm.weather = WeatherService.getWeather('Bialystok', 'PL');
	vm.weather.get(function(data) {
		vm.pogoda = data;
		vm.niebo = WeatherService.translate(vm.pogoda.weather[0].description);
	});
	// get Weather Settings</>
	// Comments Settings <>
	var getComments = function() {
		$http.get('http://localhost:8181/bialyinfo').then(successCallback,
				errorCallback);
		function successCallback(response) {
			console.log(response);
			$scope.cc = response.data;
		}
		function errorCallback(error) {
		}

	}

	getComments();

	// Comments Settings </>
	vm.putComment = function(text, name, id) {
		$http.put(
				"http://localhost:8181/putcomment/" + text + "/" + name + "/"
						+ id).then(successCallback, errorCallback);
		function successCallback(response) {
			getComments();

		}
		function errorCallback(error) {
		}

	}
	vm.putNewComment = function(text, name) {
		$http.put("http://localhost:8181/putnewcomment/" + text + "/" + name)
				.then(successCallback, errorCallback);
		function successCallback(response) {
			getComments();

		}
		function errorCallback(error) {
		}

	}

});
app.controller('WawaCtrl', function($scope, WeatherService, $timeout, $http) {
	var vm = this;
	var vm = this;
	vm.clock = "loading clock..."; // initialise the time variable
	vm.tickInterval = 1000 // ms
	var tick = function() {
		vm.clock = moment().utcOffset(2).format('LTS'); // get the current time
		$timeout(tick, $scope.tickInterval); // reset the timer
	}
	$timeout(tick, $scope.tickInterval);
	vm.weather = WeatherService.getWeather('Warsaw', 'PL');
	vm.weather.get(function(data) {
		vm.pogoda = data;
		vm.niebo = WeatherService.translate(vm.pogoda.weather[0].description);
	});

	var getComments = function() {
		$http.get('http://localhost:8181/warsinfo').then(successCallback,
				errorCallback);
		function successCallback(response) {
			console.log(response);
			$scope.cc = response.data;
		}
		function errorCallback(error) {
		}

	}
	getComments();
	// Comments Settings </>
	vm.putComment = function(text, name, id) {
		$http.put(
				"http://localhost:8181/putwarscomment/" + text + "/" + name + "/"
						+ id).then(successCallback, errorCallback);
		function successCallback(response) {
			getComments();

		}
		function errorCallback(error) {
		}

	}
	vm.putNewComment = function(text, name) {
		$http.put("http://localhost:8181/putwarsnewcomment/" + text + "/" + name)
				.then(successCallback, errorCallback);
		function successCallback(response) {
			getComments();

		}
		function errorCallback(error) {
		}

	}

});