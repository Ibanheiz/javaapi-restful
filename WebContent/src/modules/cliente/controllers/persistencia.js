'use strict'

angular
	.module('appJava')
	.controller('ClienteController', ClienteController);

function ClienteController () {
	_buscarClientes($scope, $http);
	
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
			$http.post("http://localhost:8080/java-angular/api/clientes", cliente).then(function(response){
				$scope.clientes.push(cliente);
				delete $scope.cliente;
			});
		}
	};
	
	$scope.alterarCliente = function (cliente) {
		if (cliente) {
			$http.put("http://localhost:8080/java-angular/api/clientes/" + cliente.id, cliente).then(function(response) {
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

function _buscarClientes($scope, $http) {
	var promisse = $http.get("http://localhost:8080/java-angular/api/clientes");
	promisse.success(function (data) {
		console.log(data.cliente);
		$scope.clientes = data.cliente;
	});
	promisse.error(function (err) {
		console.log(err);
	});
}

function _removerCliente(index, $scope, $http) {
	var cliente = $scope.clientes[index];
	var promisse = $http.delete("http://localhost:8080/java-angular/api/clientes/" + cliente.id);
	
	promisse.success(function (data){
		$scope.clientes.splice(index, 1);
		delete $scope.cliente;
	});
	
	promisse.error(function (err) {
		console.log(err);
	});
}