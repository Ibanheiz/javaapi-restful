angular
	.module('appJava', ['ngAnimate', 'ngRoute']);

angular.module('appJava').controller('headController', function($scope){
	$scope.titulo = "Angular com Java";
});

angular.module('appJava').controller('AppController', ['$scope', AppController]);

function AppController($scope) {
	$scope.quantidadeMensagemNotificacao = 75;
	$scope.name = "Angular Java";
}


angular.module('appJava').config(function($routeProvider, $locationProvider) {
	$routeProvider
		.when("/java-angular/cliente", {
			templateUrl: "/java-angular/view/cliente",
			controller: "ClienteController"
		});
	
	$locationProvider.html5Mode(true);
	console.log("Passou pelo ng route");
});