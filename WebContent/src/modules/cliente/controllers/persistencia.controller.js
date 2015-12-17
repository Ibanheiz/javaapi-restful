'use strict'

angular
	.module('appJava')
	.controller('ClienteController', ['$scope', 'ClienteService', ClienteController]);

function ClienteController ($scope, ClienteService) {
	_buscarClientes($scope, ClienteService);
	
	function criarPessoa(nome, sexo, idade, email) {
		var cliente = {};
		cliente.nome = nome;
		cliente.sexo = sexo;
		cliente.idade = idade;
		cliente.email = email;
		
		return cliente;
	}
	
	$scope.adicionarCliente = function (cliente) {
		if (cliente) {
			ClienteService.save(cliente).then(function(response){
				$scope.clientes.push(cliente);
				delete $scope.cliente;
			});
		}
	};
	
	$scope.alterarCliente = function (cliente) {
		if (cliente) {
			ClienteService.update(cliente).then(function(response) {
				var clientes = $scope.clientes;
				
				for (var index = 0; index < clientes.length; index++) {
					if (clientes[index].id === cliente.id) {
						console.log("index " + index + " tamnaho array" + clientes.length);
						clientes[index] = cliente;
						continue;
					}
				}
				delete $scope.cliente;
			});
		}
	};
	
	$scope.cancelar = function() {
		delete $scope.cliente;
	};
	
	$scope.selecionarCliente = function (cliente) {
		$scope.cliente = angular.copy(cliente);
	};
	
	$scope.excluirCliente = function (index) {
		_removerCliente(index, $scope, $http);
	};
}

function _buscarClientes($scope, ClienteService) {
	ClienteService.findAll().success(function (data) {
		console.log(data.cliente);
		$scope.clientes = data.cliente;
	});
}

function _removerCliente(index, $scope) {
	var cliente = $scope.clientes[index];
	var promisse = ClienteService.remove(Cliente);
	
	promisse.success(function (data){
		$scope.clientes.splice(index, 1);
		delete $scope.cliente;
	});
	
	promisse.error(function (err) {
		console.log(err);
	});
}