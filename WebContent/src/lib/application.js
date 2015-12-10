var app = angular.module('appJava', ['ngAnimate']);

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
	});
	
	promisse.error(function (err) {
		console.log(err);
	});
}

angular.module('appJava').controller('headController', function($scope){
	$scope.titulo = "Angular com Java";
});

app.controller('appController', function ($scope) {
	var quantidadeMensagemNotificacao = 75;
	$scope.name = "Angular Java";
	$scope.quantidadeMensagemNotificacao = quantidadeMensagemNotificacao;
});

app.controller('listaController', function($scope, $http) {
	_buscarClientes($scope, $http);
	
	function criarPessoa(nome, sexo, idade, email) {
		var cliente = {};
		cliente.nome = nome;
		cliente.sexo = sexo;
		cliente.idade = idade;
		cliente.email = email;
		
		return cliente;
	};
	
	$scope.adicionarCliente = function (cliente) {
		if (cliente) {
			$http.post("http://localhost:8080/java-angular/api/clientes", cliente).then(function(response){
				$scope.clientes.push(cliente);
				delete $scope.cliente;
				console.log(response);
			});
		}
	};
	
	$scope.alterarCliente = function (cliente) {
		if (cliente) {
			$http.put("http://localhost:8080/java-angular/api/clientes/"+cliente.id, cliente).then(function(response){
				$scope.clientes.push(cliente);
				delete $scope.cliente;
				alert("Cliente alterado com sucesso");
			});
		}
	};
	
	$scope.cancelar = function() {
		delete $scope.cliente;
	}
	
	$scope.selecionarPessoa = function(cliente) {
		$scope.cliente = cliente;
	}
	
	$scope.excluirPessoa = function(index) {
		_removerCliente(index, $scope, $http);
	}
});