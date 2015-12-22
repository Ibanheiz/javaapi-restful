'use strict';

angular
	.module('appJava')
	.controller('ClienteController', ['$scope', 'ClienteService', ClienteController]);

function ClienteController ($scope, ClienteService) {
	_buscarClientes($scope, ClienteService);
	
	$scope.adicionarCliente = function (cliente) {
		ClienteService.save(cliente).success(function(data){
			_buscarClientes($scope, ClienteService);
			delete $scope.cliente;
		});
	};
	
	$scope.alterarCliente = function (cliente) {
		ClienteService.update(cliente).then(function(response) {
			_buscarClientes($scope, ClienteService);
		});
	};
	
	$scope.cancelar = function() {
		delete $scope.cliente;
	};
	
	$scope.selecionarCliente = function (cliente) {
		$scope.cliente = angular.copy(cliente);
	};
	
	$scope.excluirCliente = function (index) {
		_removerCliente(index, $scope);
	};
	
	function _buscarClientes($scope, ClienteService) {
		ClienteService.findAll().success(function (data) {
			$scope.clientes = [];
			$scope.clientes = $scope.clientes.concat(data.cliente);
		});
	}

	function _removerCliente(index, $scope) {
		var cliente = $scope.clientes[index];
		var promisse = ClienteService.remove(cliente);
		
		promisse.success(function (data){
			$scope.clientes.splice(index, 1);
			delete $scope.cliente;
		});
		
		promisse.error(function (err) {
			console.log(err);
		});
	}
}
