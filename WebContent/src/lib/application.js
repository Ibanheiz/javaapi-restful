angular
	.module('appJava', ['ngAnimate', 'ngRoute']);

angular.module('appJava').controller('headController', function($scope){
	$scope.titulo = "Angular com Java";
});

angular.module('appJava').controller('appController', AppController);

function AppController() {
	var vm = this;
	var quantidadeMensagemNotificacao = 75;
	vm.name = "Angular Java";
	vm.quantidadeMensagemNotificacao = quantidadeMensagemNotificacao;
}


angular.module('appJava').config(function($routeProvider) {
	$routeProvider
		.when("/cliente", {
			templateUrl: "src/template/cliente.html",
			controller: "ClienteController"
		});
		
	console.log("Passou pelo ng route");
});