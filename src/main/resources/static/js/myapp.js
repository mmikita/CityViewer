var app = angular.module('ngHelloWorld', [ 'ngResource', 'ngRoute' ]);
app.config(function($routeProvider) {

	$routeProvider.when("/bialy", {
		templateUrl : "partials/bialy.html",
		controller : 'BialyCtrl',
		controllerAs : 'ctrl'

	}).when("/tokyo", {
		templateUrl : "partials/tokyo.html",
		controller : 'TokyoCtrl',
		controllerAs : 'ctrl'
	}).when("/wawa", {
		templateUrl : "partials/wawa.html",
		controller : 'WawaCtrl',
		controllerAs : 'ctrl'
	})

});

